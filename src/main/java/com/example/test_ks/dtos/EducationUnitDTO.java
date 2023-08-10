package com.example.test_ks.dtos;

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
public class EducationUnitDTO {

    private Long id;

    private long parentId;

    private String parentName;

    private int type = 0;

    private Integer status = 0;

    private long functionType;

    private Long partyUnitId;

    private String partyUnitName;

    private Long unionUnitId = -2L;

    private Long headId = -2L;

    private List<Long> deputyIds = new ArrayList<Long>();

    private Long rootId;

    private List<String> assetStaffIds = new ArrayList<String>();

    private List<String> researchStaffIds = new ArrayList<String>();
    private List<String> teachingStaffIds = new ArrayList<String>();
    private String facebookChannel;
    private String youtubeChannel;
    private String tiktokChannel;
    private int order = -1;
    private Integer api = 0;

    private String unitId;

    private String financeCode;
    private String logo;

    private String name;

    private String nameEn;
    private String shortNameVi;
    private String shortNameEn;
    private String abbrName;
    private String commonName;
    private String description;

    private String website;

    private String phoneNumber;

    private String faxNumber;

    private String email;

    private String address;
    private String unitCode;
    private Long foundedDate;
}