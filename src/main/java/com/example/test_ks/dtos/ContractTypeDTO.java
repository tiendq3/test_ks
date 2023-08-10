package com.example.test_ks.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ContractTypeDTO {
    private Long id;

    private String title;

    private String description;

    private Long duration;

    private String code;

    private Integer index;
}
