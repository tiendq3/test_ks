package com.example.test_ks.service.impl;

import com.example.test_ks.dtos.EducationUnitDTO;
import com.example.test_ks.service.EducationUnitService;
import com.example.test_ks.utils.JsonConverter;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class EducationUnitServiceImpl implements EducationUnitService {
    @Override
    public List<EducationUnitDTO> getAllEducationUnit() {
        String apiUrl = "https://set-hust.appspot.com/utils?type=getalleduunits&accessToken=tpY57fIFF2Kssr1cuxNJ-hungnt111";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(apiUrl, String.class);

        String jsonList = response.getBody();
        return JsonConverter.convertJsonToList(jsonList, EducationUnitDTO.class);
    }
}
