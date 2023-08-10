package com.example.test_ks.controller;

import com.example.test_ks.service.TeacherService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/canbo")
public class TeacherController {

    private final TeacherService teacherService;

    @PostMapping("/import-canbo")
    public void importCanBo(@RequestParam("file") MultipartFile multipartFile) {
        teacherService.importTeacher(multipartFile);
    }
}
