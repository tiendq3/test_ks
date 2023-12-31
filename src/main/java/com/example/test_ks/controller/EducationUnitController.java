package com.example.test_ks.controller;

import com.example.test_ks.Test;
import com.example.test_ks.dtos.EducationUnitDTO;
import com.example.test_ks.service.EducationUnitService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
public class EducationUnitController {

    private final Test test;

    private final EducationUnitService educationUnitService;

    @GetMapping(value = "/export-educationUnits", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<byte[]> exportEducationUnits(@RequestParam List<String> columnNames) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", "EducationUnitList.xlsx");

        List<EducationUnitDTO> educationUnitDTOS = educationUnitService.getAllEducationUnit();
        byte[] bytes = test.exportListObjectToExcel(educationUnitDTOS, columnNames, "EducationUnitDTO").toByteArray();
        return ResponseEntity
                .ok()
                .headers(headers)
                .body(bytes);
    }
}
