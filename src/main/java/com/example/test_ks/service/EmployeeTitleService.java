package com.example.test_ks.service;

import com.example.test_ks.dtos.EmployeeTitleDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeTitleService {
    List<EmployeeTitleDTO> getAllEmployeeTitle();
}
