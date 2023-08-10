package com.example.test_ks.utils;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public final class TeacherConfigField {
    public static final MappingColumnNameToField ID = MappingColumnNameToField
            .builder()
            .fieldName("Id")
            .columnNames(List.of("ID", "id", "Id"))
            .dataType("Long")
            .build();

    public static final MappingColumnNameToField userName = MappingColumnNameToField
            .builder()
            .fieldName("userName")
            .columnNames(List.of("Tên đăng nhập", "username"))
            .dataType("String")
            .build();

    public static final MappingColumnNameToField password = MappingColumnNameToField
            .builder()
            .fieldName("password")
            .columnNames(List.of("Mật khẩu", "password"))
            .dataType("String")
            .build();

    public static final MappingColumnNameToField password2 = MappingColumnNameToField
            .builder()
            .fieldName("password2")
            .columnNames(List.of("Mật khẩu 2", "password2"))
            .dataType("String")
            .build();

    public static final MappingColumnNameToField fullName = MappingColumnNameToField
            .builder()
            .fieldName("fullName")
            .columnNames(List.of("Họ và tên", "Họ và Tên", "fullName"))
            .dataType("String")
            .build();

    public static final MappingColumnNameToField firstName = MappingColumnNameToField
            .builder()
            .fieldName("firstName")
            .columnNames(List.of("Tên", "firstName"))
            .dataType("String")
            .build();

    public static final MappingColumnNameToField lastName = MappingColumnNameToField
            .builder()
            .fieldName("lastName")
            .columnNames(List.of("Họ", "lastName"))
            .dataType("String")
            .build();

    public static final MappingColumnNameToField gender = MappingColumnNameToField
            .builder()
            .fieldName("gender")
            .columnNames(List.of("Giới tính", "gender"))
            .dataType("Integer")
            .build();

    public static final MappingColumnNameToField staffCode = MappingColumnNameToField
            .builder()
            .fieldName("staffCode")
            .columnNames(List.of("Mã Cán Bộ", "Mã CB", "staffCode"))
            .dataType("String")
            .build();//CAN_BO_ID
    public static MappingColumnNameToField age;
    public static MappingColumnNameToField commonName;
    public static MappingColumnNameToField subName;
    public static MappingColumnNameToField title;
    public static MappingColumnNameToField degree;
    public static MappingColumnNameToField jobType;
    public static MappingColumnNameToField jobName;
    public static MappingColumnNameToField contractType;

    public static MappingColumnNameToField contractNotes;
    public static MappingColumnNameToField position; // Position
    public static MappingColumnNameToField departmentId; // 0: CNPM, 1: HTTT, 2: KHMT
    public static final MappingColumnNameToField rootId = MappingColumnNameToField
            .builder()
            .fieldName("rootId")
            .columnNames(List.of("Mã Đơn Vị", "rootId"))
            .dataType("Long")
            .build();

    public static MappingColumnNameToField uniId;
    public static MappingColumnNameToField source; // 1: from QLDT; 2: from QLCB
    public static MappingColumnNameToField vaccinated;
    public static MappingColumnNameToField partyUnitId;
    public static final MappingColumnNameToField rootName = MappingColumnNameToField
            .builder()
            .fieldName("rootName")
            .columnNames(List.of("Tên Đơn Vị", "rootName"))
            .build();
    private static MappingColumnNameToField departmentName;
    private static MappingColumnNameToField partyUnitName;
    private static MappingColumnNameToField unionUnitId;
    private static MappingColumnNameToField unionUnitName;
    private static MappingColumnNameToField docNumberId; //ma ho so

    @JsonIgnore
    private List<String> semesters = new ArrayList<String>();
    //	@JsonIgnore private String taxNumber = Config.NULL_TXT;
    private static MappingColumnNameToField notes;
    //	@JsonIgnore private String idNumber = Config.NULL_TXT;
//	@JsonIgnore private String idNumberPlace = Config.NULL_TXT;
//	@JsonIgnore private Long idNumberPlaceId = Config.NULL_ID;
//	@JsonIgnore private Long idNumberDate = Config.NULL_ID;
//	@JsonIgnore private String idNumberFront = Config.NULL_TXT;
//	@JsonIgnore private String idNumberBack = Config.NULL_TXT;
//	@JsonIgnore private String assuranceNumber = Config.TEXT_EMPTY;
//	@JsonIgnore private Long assuranceDate = Config.NULL_ID;
    private static MappingColumnNameToField stateOfficialDate;        //Ngày vào biên chế

    private static MappingColumnNameToField prevHiredDate;

    private static MappingColumnNameToField prevPosition;

    private static MappingColumnNameToField prevCompany;

    private static MappingColumnNameToField hiredDate;

    private static MappingColumnNameToField hiredPosition;

    private static MappingColumnNameToField contractEndDate;
    private static MappingColumnNameToField contractEndNumber;
    private static MappingColumnNameToField nickName;

    private static MappingColumnNameToField qlnnId;

    private static MappingColumnNameToField llctId;

    private static MappingColumnNameToField itLevelId;
    private static MappingColumnNameToField seniorityDate;
    private static MappingColumnNameToField refCode;
    private static MappingColumnNameToField salaryNextDate;
    private static MappingColumnNameToField seniorityNextDate;
    private static MappingColumnNameToField salaryLastDate;
    private static MappingColumnNameToField seniorityLastDate;
    private static MappingColumnNameToField salaryInterval;
    private static MappingColumnNameToField kCd;

    //	@JsonIgnore private String bankAccount = Config.NULL_TXT;
//	@JsonIgnore private String bankInfo = Config.NULL_TXT;

    private static MappingColumnNameToField website;

    private static MappingColumnNameToField researchBio;

    private static MappingColumnNameToField personalBio;

    private static MappingColumnNameToField profileUrl;

    private static MappingColumnNameToField candidateGroup;
    private static MappingColumnNameToField recruitTime;
    private static MappingColumnNameToField recruitId;
    private static MappingColumnNameToField recruitName;
    private static MappingColumnNameToField researchPlan;
    private static MappingColumnNameToField researchResume;

    public static MappingColumnNameToField birthDate = MappingColumnNameToField
            .builder()
            .fieldName("birthDate")
            .columnNames(List.of("Ngày Sinh", "birthDate"))
            .dataType("Long")
            .build();

    private static MappingColumnNameToField birthPlace;
    private static MappingColumnNameToField birthPlaceId;

    private static MappingColumnNameToField birthDateStr;

    private static final MappingColumnNameToField workEmail = MappingColumnNameToField
            .builder()
            .fieldName("workEmail")
            .columnNames(List.of("Email", "workEmail"))
            .dataType("String")
            .build();
    private static MappingColumnNameToField personalEmail;

    public static final MappingColumnNameToField workPhoneNumber = MappingColumnNameToField
            .builder()
            .fieldName("workPhoneNumber")
            .columnNames(List.of("Số điện thoại", "SĐT", "workPhoneNumber", "phone","Điện Thoại"))
            .dataType("String")
            .build();
    private static MappingColumnNameToField cellPhoneNumber;
    private static MappingColumnNameToField otherEmails = null;
    private static MappingColumnNameToField otherPhoneNumbers = null;
    private static MappingColumnNameToField workAddress;

    private static MappingColumnNameToField partyDate;

    private static MappingColumnNameToField officialPartyDate;

    private static MappingColumnNameToField marriedStatus;

    private static MappingColumnNameToField info;
    private static MappingColumnNameToField facebookToken;
    private static MappingColumnNameToField facebookId;
    private static MappingColumnNameToField facebookName;
    private static MappingColumnNameToField relatedEmail;
    private static MappingColumnNameToField lastLoggedIn;
    private static MappingColumnNameToField avatarUrl;
    private static MappingColumnNameToField projectStatus;
    private static MappingColumnNameToField courseIds;
    private static MappingColumnNameToField activated;
    private static MappingColumnNameToField roomId;
    private static MappingColumnNameToField roomName;
    private static MappingColumnNameToField probation;
    private static MappingColumnNameToField probationFrom;
    private static MappingColumnNameToField probationTo;
    private static MappingColumnNameToField salaryRaiseDate;
    private static MappingColumnNameToField status;
    private static MappingColumnNameToField tmpStatus;
    private static MappingColumnNameToField lastUpdate;

}
