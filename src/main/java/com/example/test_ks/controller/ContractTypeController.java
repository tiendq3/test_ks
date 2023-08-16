package com.example.test_ks.controller;

import com.example.test_ks.Test;
import com.example.test_ks.dtos.ContractTypeDTO;
import com.example.test_ks.service.ContractTypeService;
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
public class ContractTypeController {
    private final Test test;

    private final ContractTypeService contractTypeService;

    @GetMapping(value = "/export-contracts", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<byte[]> exportContractTypeList(@RequestParam List<String> columnNames) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", "ContractTypeList.xlsx");

        List<ContractTypeDTO> contractTypeDTOS = contractTypeService.getAllContractType();
        byte[] bytes = test.exportListObjectToExcel(contractTypeDTOS, columnNames, "ContractTypeDTO").toByteArray();
        return ResponseEntity
                .ok()
                .headers(headers)
                .body(bytes);
    }

}
