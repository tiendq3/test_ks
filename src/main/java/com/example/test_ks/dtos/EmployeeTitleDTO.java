package com.example.test_ks.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeTitleDTO implements FieldMappingColumnName {
    private Long id;
    private String title = "";
    private String titleEn = "";
    private String description = "";
    private String descriptionEn = "";
    private int teachingHour = 0;
    private int researchHour = 0;
    private int servicesHour = 0;
    private int type = 0; //1: Degree, 2:title, 3: job title, 4: certificates, 5: merite
    private Integer order = 0;
    private double kCD = 0;
    private String code = "";

    public static Integer TITLE_DEGREE = 1;
    public static Integer TITLE_TITLE = 2;
    public static Integer TITLE_JOB_TYPE = 3;
    public static Integer TITLE_CERTIFICATE = 4;
    public static Integer TITLE_MERITE = 5;

    @Override
    public Map<String, List<String>> fieldMappingColumnName() {
        Map<String, List<String>> map = new HashMap<>();
        map.put("title", List.of("title"));
        map.put("titleEn", List.of("titleEn"));
        map.put("description", List.of("description"));
        map.put("descriptionEn", List.of("descriptionEn"));
        map.put("teachingHour", List.of("teachingHour"));
        map.put("researchHour", List.of("researchHour"));
        map.put("servicesHour", List.of("servicesHour"));
        map.put("type", List.of("type"));
        map.put("order", List.of("order"));
        map.put("kCD", List.of("kCD"));
        map.put("code", List.of("code"));
        return map;
    }
}