package com.example.test_ks.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface StudentService {

    void importStudent(MultipartFile multipartFile);
}
