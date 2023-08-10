package com.example.test_ks.service.impl;


import com.example.test_ks.dtos.ContractTypeDTO;
import com.example.test_ks.dtos.EducationUnitDTO;
import com.example.test_ks.dtos.EmployeeTitleDTO;
import com.example.test_ks.dtos.TeacherDTO;
import com.example.test_ks.exception.BadRequestException;
import com.example.test_ks.exception.NotFoundException;
import com.example.test_ks.service.ContractTypeService;
import com.example.test_ks.service.EducationUnitService;
import com.example.test_ks.service.EmployeeTitleService;
import com.example.test_ks.service.TeacherService;
import com.example.test_ks.utils.ClientUtils;
import com.example.test_ks.utils.JsonConverter;
import com.example.test_ks.utils.MappingColumnNameToField;
import com.example.test_ks.utils.TeacherConfigField;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.example.test_ks.utils.ExcelUtils.getCellValue;


@Service
@AllArgsConstructor
@Slf4j
public class TeacherServiceImpl implements TeacherService {

    private final EducationUnitService educationUnitService;

    private final EmployeeTitleService employeeTitleService;

    private final ContractTypeService contractTypeService;

    @Override
    public void importTeacher(MultipartFile canBoFile) {
        String canBoDTOListJson = readJsonDataFromFile(canBoFile);

        String apiUrl = "https://testapp-dot-set-hust.appspot.com/utils";
        String response = ClientUtils.postDataToServer(apiUrl + "?accessToken=" + "tpY57fIFF2Kssr1cuxNJ-hungnt111", canBoDTOListJson,
                "updateteachers");
        log.warn(response);

        // Tạo HttpEntity với body
//        RestTemplate restTemplate = new RestTemplate();
//        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
//        params.add("type", "updatenewteachers");
//        params.add("accessToken", "tpY57fIFF2Kssr1cuxNJ-hungnt111");
//        params.add("data", canBoDTOListJson);
//
//        // HttpHeaders cũng là 1 MultiValueMap<String,String>
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//
//        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(params, headers);
//        ResponseEntity<String> responseEntity = restTemplate.exchange(apiUrl, HttpMethod.GET, requestEntity, String.class);

//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//
//        HttpEntity<String> entity = new HttpEntity<>(null,headers);
//        // Khi gửi json trên param( hay là gửi json với yêu cầu GET)
//        // RestTemplate hiểu dấu {} là trình giữ chỗ cho các biến của URI
//        String apiUrl = "https://testapp-dot-set-hust.appspot.com/utils?type=updatenewteachers&accessToken=tpY57fIFF2Kssr1cuxNJ&data="+canBoDTOListJson;
//        // đối số cuối cùng là giá trị của biến {data}
//        ResponseEntity<String> responseEntity = restTemplate.exchange(apiUrl, HttpMethod.POST, entity, String.class,canBoDTOListJson);
//        if (responseEntity.getStatusCode() == HttpStatus.OK) {
//            log.warn(responseEntity.getBody());
//        } else {
//            log.error("Yêu cầu không thành công. Mã trạng thái: " + responseEntity.getStatusCodeValue());
//        }
    }

    private String readJsonDataFromFile(MultipartFile multipartFile) {
        List<EducationUnitDTO> educationUnitDTOS = educationUnitService.getAllEducationUnit();
        List<EmployeeTitleDTO> employeeTitleDTOS = employeeTitleService.getAllEmployeeTitle();
        List<ContractTypeDTO> contractTypeDTOS = contractTypeService.getAllContractType();

        EducationUnitDTO eduUnit = null;
        for (EducationUnitDTO educationUnitDTO : educationUnitDTOS) {
            if (educationUnitDTO.getName().equals("Test")) {
                eduUnit = educationUnitDTO;
                break;
            }
        }
        if (eduUnit == null) throw new NotFoundException("Not found unit Test");

        List<TeacherDTO> teacherDTOList = new ArrayList<>();
        try {
            Workbook workbook = new XSSFWorkbook(multipartFile.getInputStream());
            Sheet sheet = workbook.getSheet("VĐT RHM");
            for (int i = 0; i < sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i + 1);
                String fullName = String.valueOf(row.getCell(2));
                if (fullName == null) throw new BadRequestException("fullname mustn't empty");
                String birthDate = getCellValue(row.getCell(4));
                if (birthDate == null) break;
                TeacherDTO teacherDTO = TeacherDTO
                        .builder()
                        .staffCode(getCellValue(row.getCell(1)))
                        .userName(getCellValue(row.getCell(5)))
                        .fullName(fullName)
                        .firstName(firtNameFromFullName(fullName))
                        .lastName(lastNameFromFullName(fullName))
                        .birthDate(convertDateStringToUnixTime(getCellValue(row.getCell(4))))
                        .workEmail(getCellValue(row.getCell(5)))
                        .workPhoneNumber(getCellValue(row.getCell(6)))
                        .rootId(eduUnit.getId())
                        .rootName(eduUnit.getName())
                        .status(0)
                        .birthDateStr("10/10/2000")
                        .age(10)
                        .build();
                String titleInput = getCellValue(row.getCell(14)).toLowerCase();
                String degreeInput = getCellValue(row.getCell(15)).toLowerCase();
                String jobPositionInput = getCellValue(row.getCell(13)).toLowerCase();
                String contractTypeInput = getCellValue(row.getCell(8));

                for (EmployeeTitleDTO employeeTitleDTO : employeeTitleDTOS) {
                    if (employeeTitleDTO.getTitle().toLowerCase().equals(titleInput)) {
                        teacherDTO.setTitle(employeeTitleDTO.getId());
                    }
                    if (employeeTitleDTO.getDescription().toLowerCase().equals(degreeInput)) {
                        teacherDTO.setDegree(employeeTitleDTO.getId());
                    }
                    if (employeeTitleDTO.getDescription().toLowerCase().equals(jobPositionInput)) {
                        teacherDTO.setJobType(employeeTitleDTO.getId());
                    }
                }
                for (ContractTypeDTO contractTypeDTO : contractTypeDTOS) {
                    String contractTypeDB = contractTypeDTO.getTitle();
                    if (contractTypeDB.equals(contractTypeInput)) {
                        teacherDTO.setContractType(contractTypeDTO.getId());
                    }
                }
                teacherDTOList.add(teacherDTO);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return JsonConverter.convertListToJson(teacherDTOList);
    }

    private Long convertDateStringToUnixTime(String dateString) {
        String pattern = "dd/MM/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date date;
        try {
            date = sdf.parse(dateString);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return date.getTime();
    }

    private String lastNameFromFullName(String fullName) {
        String[] names = fullName.split(" ");
        return names[names.length - 1];
    }

    private String firtNameFromFullName(String fullName) {
        return fullName.split(" ")[0];
    }

    void setFieldModel(TeacherDTO teacherDTO, String columnName, String valueCell) {
        TeacherConfigField teacherConfigField = new TeacherConfigField();
        Class<?> teacherConfigFieldClass = TeacherConfigField.class;
        Field[] fields = teacherConfigFieldClass.getFields();
        // for qua cac truong của TeacherConfigField
        for (Field field : fields) {
            try {
                MappingColumnNameToField mappingColumnNameToField = (MappingColumnNameToField) field.get(teacherConfigField);
                List<String> strings = mappingColumnNameToField.getColumnNames();
                for (String s : strings) {
                    if (s.equals(columnName)) {
                        Method method = teacherDTO.getClass().getMethod("set" + capitalize(field.getName()));
                        method.invoke(teacherDTO, valueCell);
                    }
                }
            } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }
}
