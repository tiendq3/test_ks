package com.example.test_ks.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MappingColumnNameToField {

    private String fieldName;

    private Class<?> dataType;

    private List<String> columnNames = new ArrayList<>();

}
