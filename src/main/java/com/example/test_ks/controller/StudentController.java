package com.example.test_ks.controller;

import com.example.test_ks.Test;
import com.example.test_ks.dtos.StudentDTO;
import com.example.test_ks.dtos.TeacherDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
public class StudentController {

    private final Test test;

    @PostMapping("/import-students")
    public ResponseEntity<List<StudentDTO>> importStudents(@RequestParam("file") MultipartFile multipartFile,
                                                           @RequestParam(defaultValue = "StudentDTO") String modelName) {
        return ResponseEntity.ok(test.listObjectFromFileData(multipartFile, modelName));
    }
}
