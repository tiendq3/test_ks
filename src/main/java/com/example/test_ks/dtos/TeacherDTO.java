package com.example.test_ks.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class TeacherDTO {
    private Long id;

    private String userName = "";

    @JsonIgnore
    private String password;

    @JsonIgnore
    private String password2;

    private String fullName = "";

    private String firstName = "";

    private String lastName = "";

    private Integer gender = 1;

    private String staffCode;//CAN_BO_ID
    private Integer age = 10;
    private String commonName = "";
    private String subName = "";
    private Long title = -1l;
    private Long degree = -1l;
    private Long jobType = -1l;
    private String jobName = "";
    private Long contractType = 0l;

    @JsonIgnore
    private String contractNotes;
    private Long position = 0l; // Position
    private Long departmentId = 0l; // 0: CNPM, 1: HTTT, 2: KHMT
    private Long rootId = 0l;// CNTT, Dien
    private Long uniId = 0l;
    private Integer source = 1; // 1: from QLDT; 2: from QLCB
    private Integer vaccinated = -1;
    private Long partyUnitId = 0l;
    private String rootName;
    private String departmentName;
    private String partyUnitName;
    private Long unionUnitId;
    private String unionUnitName;
    private String docNumberId; //ma ho so

    @JsonIgnore
    private List<String> semesters = new ArrayList<String>();
    //	@JsonIgnore private String taxNumber = Config.NULL_TXT;
    private String notes;
    //	@JsonIgnore private String idNumber = Config.NULL_TXT;
//	@JsonIgnore private String idNumberPlace = Config.NULL_TXT;
//	@JsonIgnore private Long idNumberPlaceId = Config.NULL_ID;
//	@JsonIgnore private Long idNumberDate = Config.NULL_ID;
//	@JsonIgnore private String idNumberFront = Config.NULL_TXT;
//	@JsonIgnore private String idNumberBack = Config.NULL_TXT;
//	@JsonIgnore private String assuranceNumber = Config.TEXT_EMPTY;
//	@JsonIgnore private Long assuranceDate = Config.NULL_ID;
    @JsonIgnore
    private Long stateOfficialDate = 0l;        //Ngày vào biên chế

    @JsonIgnore
    private Long prevHiredDate = -1l;

    @JsonIgnore
    private String prevPosition;

    @JsonIgnore
    private String prevCompany;

    private Long hiredDate = -1l;

    @JsonIgnore
    private String hiredPosition;

    @JsonIgnore
    private Long contractEndDate;
    private String contractEndNumber;
    private String nickName;

    private Long qlnnId;

    private Long llctId;

    private Long itLevelId = -1l;
    private Long seniorityDate = -1l;
    private String refCode;
    private Long salaryNextDate = -1l;
    private Long seniorityNextDate = -1l;
    private Long salaryLastDate = -1l;
    private Long seniorityLastDate = -1l;
    private Integer salaryInterval = -1;
    private Double kCd = 0.0;

    //	@JsonIgnore private String bankAccount = Config.NULL_TXT;
//	@JsonIgnore private String bankInfo = Config.NULL_TXT;

    @JsonIgnore
    private String website;

    @JsonIgnore
    private String researchBio;

    @JsonIgnore
    private String personalBio;

    @JsonIgnore
    private String profileUrl;

    @JsonIgnore
    private Integer candidateGroup = -1;
    @JsonIgnore
    private Long recruitTime;
    @JsonIgnore
    private Long recruitId;
    @JsonIgnore
    private String recruitName;
    @JsonIgnore
    private String researchPlan;
    @JsonIgnore
    private String researchResume;

    private Long birthDate = null;// new Date();

    private String birthPlace;
    private Long birthPlaceId;

    private String birthDateStr;

    private String workEmail;
    private String personalEmail;

    private String workPhoneNumber;
    @JsonIgnore
    private String cellPhoneNumber;
    @JsonIgnore
    private List<String> otherEmails = new ArrayList<String>();
    @JsonIgnore
    private List<String> otherPhoneNumbers = new ArrayList<String>();
    @JsonIgnore
    private String workAddress;

//	@JsonIgnore private String bloodType = Config.NULL_TXT;
//	@JsonIgnore private Long priorityTypeId = Config.NULL_ID;
//	@JsonProperty("GIA_DINH_CHINH_SACH_ID")
//	private Long familyPolicyId = Config.NULL_ID;
//	@JsonIgnore private Long highSchoolEduId = Config.NULL_ID;
//	@JsonIgnore private Long familyOriginId = Config.NULL_ID;

//	@JsonIgnore private int healthType = -1;
//	@JsonIgnore private String residentAddress = Config.NULL_TXT;
//	@JsonIgnore private Long residentCountryId = Config.NULL_ID;
//	@JsonIgnore private Long residentProvinceId = Config.NULL_ID;
//	@JsonIgnore private Long residentDistrictId = Config.NULL_ID;
//	@JsonIgnore private Long residentCommuneId = Config.NULL_ID;
//
//	@JsonIgnore private String homeTownAddress = Config.NULL_TXT;
    //	@JsonIgnore private Long homeTownCountryId = Config.NULL_ID;
//	@JsonIgnore private Long homeTownProvinceId = Config.NULL_ID;
//	@JsonIgnore private Long homeTownDistrictId = Config.NULL_ID;
//	@JsonIgnore private Long homeTownCommuneId = Config.NULL_ID;
//
//	@JsonIgnore private Long homeCountryId = Config.NULL_ID;
//	@JsonIgnore private Long homeProvinceId = Config.NULL_ID;
//	@JsonIgnore private Long homeDistrictId = Config.NULL_ID;
//	@JsonIgnore private Long homeCommuneId = Config.NULL_ID;
//	@JsonIgnore private String homeAddress = Config.NULL_TXT;


    private Long partyDate;

    private Long officialPartyDate;
//	@JsonProperty("NGAY_NHAP_NGU")
//	@JsonIgnore private Long enlistmentDate = Config.NULL_ID;
//	@JsonProperty("NGAY_XUAT_NGU")
//	@JsonIgnore private Long dischargeDate = Config.NULL_ID;

    @JsonIgnore
    private Long marriedStatus;

    @JsonIgnore
    private String info;
    @JsonIgnore
    private String facebookToken;
    @JsonIgnore
    private String facebookId;
    @JsonIgnore
    private String facebookName;
    @JsonIgnore

    private String relatedEmail;
    @JsonIgnore
    private long lastLoggedIn;
    private String avatarUrl;
    private int projectStatus;
    @JsonIgnore
    private List<Long> courseIds = new ArrayList<Long>();
    private Integer activated = 0;
    private Long roomId;
    private String roomName;
    @JsonIgnore
    private Integer probation = -1;
    @JsonIgnore
    private Long probationFrom;
    @JsonIgnore
    private Long probationTo;
    @JsonIgnore
    private Long salaryRaiseDate;
    private Integer status;
    private Integer tmpStatus;
    private long lastUpdate;
}
