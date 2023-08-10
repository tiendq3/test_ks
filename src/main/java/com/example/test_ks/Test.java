package com.example.test_ks;

import com.example.test_ks.dtos.TeacherDTO;
import com.example.test_ks.utils.MappingColumnNameToField;
import com.example.test_ks.utils.TeacherConfigField;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        String excelFilePath = "path/to/your/excel/file.xlsx";

        try (Workbook workbook = new XSSFWorkbook(excelFilePath)) {
            Sheet sheet = workbook.getSheetAt(0); // Lấy sheet đầu tiên

            List<TeacherDTO> modelList = new ArrayList<>();

            Row headerRow = sheet.getRow(0); // Dòng chứa tiêu đề (tên cột)
            Map<String, Integer> columnIndexMap = new HashMap<>();

            // Lưu trữ tên cột và chỉ số của cột tương ứng vào columnIndexMap
            for (Cell cell : headerRow) {
                columnIndexMap.put(cell.getStringCellValue(), cell.getColumnIndex());
            }

            for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                Row row = sheet.getRow(rowIndex);

                TeacherDTO model = new TeacherDTO(); // Tạo instance của model của bạn

                // Đọc dữ liệu từ các ô theo tên cột
                model.setFullName(row.getCell(columnIndexMap.get("ColumnName1")).getStringCellValue());
                model.setAge((int) row.getCell(columnIndexMap.get("ColumnName2")).getNumericCellValue());

                // ... Tiếp tục đọc và thiết lập các thuộc tính khác của model

                modelList.add(model);
            }

            // Bây giờ modelList chứa danh sách các model được tạo từ tệp Excel
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
