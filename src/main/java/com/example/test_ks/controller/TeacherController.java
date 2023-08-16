package com.example.test_ks.controller;

import com.example.test_ks.Test;
import com.example.test_ks.dtos.TeacherDTO;
import com.example.test_ks.service.TeacherService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/canbo")
public class TeacherController {

    private final TeacherService teacherService;

    private final Test test;

    @PostMapping("/import-canbo")
    public void importCanBo(@RequestParam("file") MultipartFile multipartFile) {
        teacherService.importTeacher(multipartFile);
    }

    @PostMapping("/import-teachers")
    public ResponseEntity<List<TeacherDTO>> importTeacher(@RequestParam("file") MultipartFile multipartFile,
                                                          @RequestParam(defaultValue = "TeacherDTO") String modelName) {
        return ResponseEntity.ok(test.listObjectFromFileData(multipartFile, modelName));
    }

    @GetMapping(value = "/export-teachers", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<byte[]> exportTeacher(@RequestParam(value = "columnNames") List<String> columnNames,
                                                @RequestParam(defaultValue = "TeacherDTO") String modelName) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", "TeacherList.xlsx");

        List<TeacherDTO> teacherDTOList = new ArrayList<>();
        TeacherDTO teacherDTO = TeacherDTO
                .builder()
                .staffCode("1111")
                .fullName("dqt")
                .birthDate(new Date().getTime())
                .build();
        TeacherDTO teacherDTO1 = TeacherDTO
                .builder()
                .staffCode("2222")
                .fullName("dqt")
                .birthDate(new Date().getTime())
                .build();
        teacherDTOList.add(teacherDTO1);
        teacherDTOList.add(teacherDTO);

        return ResponseEntity.ok()
                .headers(headers)
                .body(test.exportListObjectToExcel(teacherDTOList, columnNames, modelName).toByteArray());
    }
}
