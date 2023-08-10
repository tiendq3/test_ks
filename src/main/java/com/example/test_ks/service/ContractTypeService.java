package com.example.test_ks.service;

import com.example.test_ks.dtos.ContractTypeDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ContractTypeService {
    List<ContractTypeDTO> getAllContractType();
}
