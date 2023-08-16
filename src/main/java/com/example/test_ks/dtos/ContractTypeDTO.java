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
public class ContractTypeDTO implements FieldMappingColumnName {
    private Long id;

    private String title;

    private String description;

    private Long duration;

    private String code;

    private Integer index;

    @Override
    public Map<String, List<String>> fieldMappingColumnName() {
        Map<String, List<String>> map = new HashMap<>();
        map.put("title", List.of("Tên", "Hợp đồng", "Loại hợp đồng","title"));
        map.put("description", List.of("Mô tả", "Chi tiết", "Nội dung","description"));
        map.put("duration", List.of("Khoảng thời gian", "duration"));
        map.put("code", List.of("Mã hợp đồng", "code"));
        map.put("index", List.of("Vị trí", "STT", "index"));
        return map;
    }
}
