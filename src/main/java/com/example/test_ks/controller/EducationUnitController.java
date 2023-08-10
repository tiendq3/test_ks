package com.example.test_ks.controller;

import com.example.test_ks.dtos.EducationUnitDTO;
import com.example.test_ks.service.EducationUnitService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/donvi")
public class EducationUnitController {

    private final EducationUnitService educationUnitService;

    @GetMapping("/all")
    public ResponseEntity<List<EducationUnitDTO>> getAllEducationUnit() {
        return ResponseEntity.ok(educationUnitService.getAllEducationUnit());
    }
}
