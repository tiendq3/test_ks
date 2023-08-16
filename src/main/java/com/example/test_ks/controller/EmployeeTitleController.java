package com.example.test_ks.controller;

import com.example.test_ks.Test;
import com.example.test_ks.dtos.EmployeeTitleDTO;
import com.example.test_ks.service.EmployeeTitleService;
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
public class EmployeeTitleController {
    private final Test test;

    private final EmployeeTitleService employeeTitleService;

    @GetMapping(value = "/export-employeeTitles", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<byte[]> exportEmployeeTitles(@RequestParam List<String> columnNames) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", "EmployeeTitleList.xlsx");

        List<EmployeeTitleDTO> employeeTitleDTOS = employeeTitleService.getAllEmployeeTitle();
        byte[] bytes = test.exportListObjectToExcel(employeeTitleDTOS, columnNames, "EmployeeTitleDTO").toByteArray();
        return ResponseEntity
                .ok()
                .headers(headers)
                .body(bytes);
    }
}
