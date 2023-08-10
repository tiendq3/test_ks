package com.example.test_ks.service;

import com.example.test_ks.dtos.EducationUnitDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EducationUnitService {
    List<EducationUnitDTO> getAllEducationUnit();
}
