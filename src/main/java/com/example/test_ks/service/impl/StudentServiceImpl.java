package com.example.test_ks.service.impl;

import com.example.test_ks.Test;
import com.example.test_ks.service.StudentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@AllArgsConstructor
@Slf4j
public class StudentServiceImpl implements StudentService {

    private final Test test;

    @Override
    public void importStudent(MultipartFile multipartFile) {

    }
}
