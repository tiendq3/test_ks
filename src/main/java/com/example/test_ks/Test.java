package com.example.test_ks;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;

import static com.example.test_ks.utils.ExcelUtils.getCellValue;

@RestController
public class Test {

    //import
    public <T> List<T> listObjectFromFileData(MultipartFile multipartFile, String modelName) {
        // Mỗi row trong sheet tạo thành 1 object - tương ứng với 1 Map<String,Object>
        // Map<String,Object> - key: tên cột (sau sẽ map với tên trường)
        //                    - value: Cell value (sau sẽ map giá trị của trường)
        List<Map<String, Object>> mapListDataInput = new ArrayList<>();
        try {
            Workbook workbook = new XSSFWorkbook(multipartFile.getInputStream());
            Sheet sheet = workbook.getSheetAt(0);

            // tên các cột
            Map<Integer, String> indexAndNameOfColumnMap = new HashMap<>();
            for (Cell cell : sheet.getRow(0)) {
                indexAndNameOfColumnMap.put(cell.getColumnIndex(), (String) getCellValue(cell));
            }

            for (int rowIndex = 1; rowIndex < sheet.getLastRowNum(); rowIndex++) {
                Row row = sheet.getRow(rowIndex);
                if (row == null) break;
                // mỗi row là 1 object
                Map<String, Object> objectInput = new HashMap<>();
                for (int cellIndex = 0; cellIndex < row.getLastCellNum(); cellIndex++) {
                    Cell cell = row.getCell(cellIndex);
                    //?
                    if (cell == null || indexAndNameOfColumnMap.get(cell.getColumnIndex()) == null) continue;
                    // tên côt - giá trị
                    String columnName = indexAndNameOfColumnMap.get(cell.getColumnIndex());
                    Object cellValue = getCellValue(cell);
                    objectInput.put(columnName, cellValue);
                }
                mapListDataInput.add(objectInput);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<T> outPutList = new ArrayList<>();
        for (Map<String, Object> map : mapListDataInput) {
            // chuyển từ map chứa: (tên cột-value) --> (tên trường -value)
            Map<String, Object> objectMap = columnNameToFieldNameInMap(map, modelName);

            boolean checkObjectNull = objectMap.values().stream().allMatch(Objects::isNull);
            if (checkObjectNull) continue;
            T t = convertMapToObject(objectMap, modelName);
            outPutList.add(t);
        }
        return outPutList;
    }

    Map<String, Object> columnNameToFieldNameInMap(Map<String, Object> columnNameInputMap, String modelName) {
        Map<String, Object> res = new HashMap<>();

        // xử lý mapping key trong mapInput ( tên cột) với tên thuộc tính của dataType
        try {
            Class<?> tClass = Class.forName("com.example.test_ks.dtos." + modelName);
            Object objOfModelName = tClass.getDeclaredConstructor().newInstance();
            Method method = tClass.getMethod("fieldMappingColumnName");
            Object outPutOfMethod = method.invoke(objOfModelName);

            // map gồm key - tên field và value - tên gọi khác của nó (tên cột)
            Map<String, List<String>> fieldMappingColumnNameMap = (Map<String, List<String>>) outPutOfMethod;

            // xóa đi 1 phần tử trong lúc đang duyệt Set thì sẽ gặp lỗi
            // còn List thì k bị?
            // lỗi ở đây là do thay đổi cấu trúc của set đang trong lúc duyệt
            // solution: dùng iterator:
            Iterator<String> fieldMappingColumnNameIterator = fieldMappingColumnNameMap.keySet().iterator();
            while (fieldMappingColumnNameIterator.hasNext()) {
                String fieldNameCurrent = fieldMappingColumnNameIterator.next();
                List<String> columnNamesCurrent = fieldMappingColumnNameMap.get(fieldNameCurrent);
                for (String columnNameInput : columnNameInputMap.keySet()) {
                    if (columnNamesCurrent.contains(columnNameInput)) {
                        res.put(fieldNameCurrent, columnNameInputMap.get(columnNameInput));

                        // khi đã tìm map 1 tên cột vs 1 tên trường thì xóa chúng và thoát
                        columnNameInputMap.remove(columnNameInput);
                        fieldMappingColumnNameIterator.remove();
                        break;
                    }
                }
            }
            return res;
        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException |
                 IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    <T> T convertMapToObject(Map<String, Object> map, String modelName) {
        try {
            Class<?> tClass = Class.forName("com.example.test_ks.dtos." + modelName);
            Field[] fields = tClass.getDeclaredFields();
            Object obj = tClass.getDeclaredConstructor().newInstance();
            for (Field field : fields) {
                field.setAccessible(true);

                if (Modifier.isStatic(field.getModifiers())) continue;
                //?
                Class<?> fieldDataType = field.getType();
                Object value = convertObjectToRealType(map.get(field.getName()), fieldDataType);
                field.set(obj, value);
            }
            return (T) obj;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //return Double, typeName = int, obj = Double
    Object convertObjectToRealType(Object obj, Class<?> tClass) {
        // lưu ý kiểu số, ngày, enum
        if (obj == null) {
            if (tClass.equals(int.class)) return 0;
            if (tClass.equals(long.class)) return 0L;
            if (tClass.equals(double.class)) return 0D;
            if (tClass.equals(float.class)) return 0F;
            if (tClass.equals(byte.class)) return 0;
        } else if (obj instanceof Number && tClass.isPrimitive()) {
            if (tClass.equals(Integer.class) || tClass.equals(int.class))
                return Double.valueOf(String.valueOf(obj)).intValue();
            if (tClass.equals(Long.class) || tClass.equals(long.class))
                return Double.valueOf(String.valueOf(obj)).longValue();
            if (tClass.equals(Double.class) || tClass.equals(double.class))
                return Double.valueOf(String.valueOf(obj));
            if (tClass.equals(Float.class) || tClass.equals(float.class))
                return Double.valueOf(String.valueOf(obj)).floatValue();
            if (tClass.equals(Byte.class) || tClass.equals(byte.class))
                return Double.valueOf(String.valueOf(obj)).byteValue();
        } else if (obj instanceof Number && tClass.equals(String.class)) {
            return String.valueOf((long) Double.parseDouble(obj.toString()));
        }
        return obj;
    }

    public <T> ByteArrayOutputStream exportListObjectToExcel(List<T> dataList,
                                                             List<String> columnNames,
                                                             String modelName) {
        try (Workbook workbook = new SXSSFWorkbook()) {
            Set<Map<String, Object>> outPutDataSet = new HashSet<>();
            for (T t : dataList) {
                Method method = t.getClass().getMethod("fieldMappingColumnName");
                Object objMap = method.invoke(t);
                Map<String, List<String>> fieldMappingColumnNameMap = (Map<String, List<String>>) objMap;
                Map<String, Object> outPutMap = new HashMap<>();
                for (String columnNameInput : columnNames) {
                    for (String fieldName : fieldMappingColumnNameMap.keySet()) {
                        List<String> columnNamesConfig = fieldMappingColumnNameMap.get(fieldName);
                        if (columnNamesConfig.contains(columnNameInput)) {
                            Method methodGetFieldName = t.getClass().getMethod("get" + capitalize(fieldName));
                            Object valueField = methodGetFieldName.invoke(t);
                            outPutMap.put(columnNameInput, valueField);

                            // xóa phần tử đã tìm thấy và thoát
                            fieldMappingColumnNameMap.remove(fieldName);
                            break;
                        }
                    }
                }
                outPutDataSet.add(outPutMap);
            }

            Sheet sheet = workbook.createSheet(modelName + "List");
            Row headerRow = sheet.createRow(0);

            // đổ dữ liệu vào sheet
            int columnIndex = 0;
            int rowIndex = 1;
            for (Map<String, Object> row : outPutDataSet) {
                if (columnIndex < row.keySet().size())
                    for (String columnNameOutPut : row.keySet()) {
                        Cell cell = headerRow.createCell(columnIndex);
                        cell.setCellValue(columnNameOutPut);
                        columnIndex++;
                    }
                Row rowOutPut = sheet.createRow(rowIndex);
                columnIndex = 0;
                for (Object valueCellOutPut : row.values()) {
                    Cell cell = rowOutPut.createCell(columnIndex);
                    cell.setCellValue(String.valueOf(valueCellOutPut));
                    columnIndex++;
                }
                rowIndex++;
            }
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            workbook.write(outputStream);
            return outputStream;
        } catch (IOException | NoSuchMethodException | InvocationTargetException |
                 IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }

}
