package com.example.test_ks.service.impl;


import com.example.test_ks.Test;
import com.example.test_ks.dtos.TeacherDTO;
import com.example.test_ks.service.ContractTypeService;
import com.example.test_ks.service.EducationUnitService;
import com.example.test_ks.service.EmployeeTitleService;
import com.example.test_ks.service.TeacherService;
import com.example.test_ks.utils.ClientUtils;
import com.example.test_ks.utils.JsonConverter;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@Service
@AllArgsConstructor
@Slf4j
public class TeacherServiceImpl implements TeacherService {

    private final EducationUnitService educationUnitService;

    private final EmployeeTitleService employeeTitleService;

    private final ContractTypeService contractTypeService;

    private final Test test;

    @Override
    public void importTeacher(MultipartFile canBoFile) {
        List<TeacherDTO> teacherDTOList = test.listObjectFromFileData(canBoFile, "TeacherDTO");
        String canBoDTOListJson = JsonConverter.convertListToJson(teacherDTOList);

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

}
