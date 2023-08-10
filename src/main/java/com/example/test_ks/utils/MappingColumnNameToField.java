package com.example.test_ks.utils;

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

    private String dataType;

    private List<String> columnNames = new ArrayList<>();

}
