package com.example.test_ks.dtos;

import com.example.test_ks.config.Config;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO implements FieldMappingColumnName {
    Long id;
    String studentId = Config.NULL_TXT;

    private String fullName = Config.NULL_TXT;
    @JsonIgnore
    private String password = Config.NULL_TXT;
    @JsonIgnore
    private String password2 = Config.NULL_TXT;

    private long birthdate = Config.NULL_ID;
    private String birthdateStr = Config.TEXT_EMPTY;
    private String birthPlace = Config.TEXT_EMPTY;
    private long departmentId = Config.NULL_ID;
    private long programId = Config.NULL_ID;                //4: DHCQ
    private long majorId = Config.NULL_ID;
    private String majorName = Config.NULL_TXT;
    private String majorCode = Config.NULL_TXT;
    private String studentYear = Config.NULL_TXT;        //K50, K51, K52
    private int year = 0;        //2015, 2016, ...

    private int gender = -1;
    private String tokenKey = Config.TEXT_EMPTY;

    private String ethnicity = Config.NULL_TXT;

    private String phoneNumber = Config.NULL_TXT;
    @JsonIgnore
    private String englishInfo = Config.NULL_TXT;
    @JsonIgnore
    private String creditInfo = Config.NULL_TXT;
    @JsonIgnore
    private double cpa = 0.0;
    @JsonIgnore
    private double gpa = 0.0;
    @JsonIgnore
    private double gpa2s = 0.0;
    @JsonIgnore
    private double ctpa = 0.0;            //Cumulative training point: Điểm rèn luyện tích luỹ
    @JsonIgnore
    private double tpa = 0.0;            //Training point average
    @JsonIgnore
    private double tpa2s = 0.0;            //Training point average for 2 last semesters
    @JsonIgnore
    private int totalCredit = 0;
    @JsonIgnore
    private String bankAccount = Config.NULL_TXT;
    @JsonIgnore
    private String bankName = Config.NULL_TXT;
    private String admissionCode = Config.NULL_TXT;
    private String admissionName = Config.NULL_TXT;
    private int admissionType = -1;
    private long graduationDate = Config.NULL_ID;

    private String email = Config.NULL_TXT;
    private String personalEmail = Config.NULL_TXT;
    @JsonIgnore
    private String passportNumber = Config.TEXT_EMPTY;
    @JsonIgnore
    private Integer passportType = -1;
    @JsonIgnore
    private String passportIssuedBy = Config.NULL_TXT;
    @JsonIgnore
    private Long passportExpiry = Config.NULL_ID;
    @JsonIgnore
    private String idNumber = Config.TEXT_EMPTY;
    @JsonIgnore
    private String idNumberPlace = Config.TEXT_EMPTY;
    @JsonIgnore
    private Long idNumberPlaceId = Config.NULL_ID;
    @JsonIgnore
    private Long familyEcoType = Config.NULL_ID;

    @JsonIgnore
    private Long idNumberDate = Config.NULL_ID;
    private long lastLoggedIn = Config.NULL_ID;
    private int status = Config.USER_STATUS_NORMAL;
    private Long rootId = Config.NULL_ID;
    private Long oldRootId = Config.NULL_ID;
    private Long uniId = Config.NULL_ID;
    private Long classId = Config.NULL_ID;
    private String lastSemester = Config.NULL_TXT;
    private List<String> semesters = new ArrayList<String>();
    private Integer vaccinated = -1;
    private String tmpValue = Config.NULL_TXT;
    private Long familyPolicyId = Config.NULL_ID;
    private List<String> docUrls = new ArrayList<String>();
    private int classOrder = 0;
    private String cvUrl = Config.NULL_TXT;
    private String avatarUrl = Config.NULL_TXT;
    private String className = Config.NULL_TXT;
    private String companyName = Config.NULL_TXT;
    private String scholarShip = Config.NULL_TXT;
    private String position = Config.NULL_TXT;
    private String notes = Config.NULL_TXT;
    private Long nationId = Config.NULL_ID;
    private String nationality = Config.NULL_TXT;
    private Long originNationId = Config.NULL_ID;
    private String originNation = Config.NULL_TXT;
    @JsonIgnore
    private String address = Config.TEXT_EMPTY;
    private Long countryId = Config.NULL_ID;
    private String countryName = Config.TEXT_EMPTY;
    private Long provinceId = Config.NULL_ID;
    private Long districtId = Config.NULL_ID;
    private Long communeId = Config.NULL_ID;

    private String homeCommune = Config.TEXT_EMPTY;    //Xã

    private String homeDistrict = Config.TEXT_EMPTY; //Huyện

    private String homeProvince = Config.TEXT_EMPTY; //Tỉnh
    private String homeAddress = Config.TEXT_EMPTY; //Tỉnh
    private String facebookToken = Config.NULL_TXT;
    private int studyMode = 0;                // Chính quy, VB2, VHVL, ...
    private String studentType = Config.TEXT_EMPTY;
    private String profileUrl = Config.NULL_TXT;
    private String facebookId = Config.NULL_TXT;
    private String relatedEmail = Config.NULL_TXT;
    private long createdDate = Config.NULL_ID;
    private long lastUpdate = Config.NULL_ID;
    private int tmpState = -1;
    private int source = Config.STUDENT_SOURCE_REGISTER;
    private String schoolName = Config.NULL_TXT;
    private String facebookName = Config.NULL_TXT;
    private String contactPerson = Config.NULL_TXT;
    private String contactPhone = Config.NULL_TXT;
    private Long contactProvinceId = Config.NULL_ID;
    private Long contactDistrictId = Config.NULL_ID;
    private Long contactCommuneId = Config.NULL_ID;
    private String contactCommune = Config.TEXT_EMPTY;    //Xã
    private String contactDistrict = Config.TEXT_EMPTY; //Huyện
    private String contactProvince = Config.TEXT_EMPTY; //Tỉnh
    private String contactAddress = Config.TEXT_EMPTY; //Tỉnh
    private String receptInfo = Config.TEXT_EMPTY;
    private String groupName = Config.NULL_TXT;
    @JsonIgnore
    private String familyInfo = Config.NULL_TXT;
    @JsonIgnore
    private String achievement = Config.NULL_TXT;
    @JsonIgnore
    private String otherAchievem = Config.NULL_TXT;

    private String sessionId;
    //    private Project project;
//    @JsonIgnore  private List<Training> trainings = new ArrayList<Training>();
//    @JsonIgnore  private List<StaffAward> staffAwards = new ArrayList<StaffAward>();
//    @JsonIgnore  private List<StaffAward> scholarships = new ArrayList<StaffAward>();
//    @JsonIgnore  private List<StaffDiscipline> staffDisciplines = new ArrayList<StaffDiscipline>();	//Cấp 2: Kỷ luật (dựng 2 phân hệ)
//    @JsonIgnore  private List<Person> relatives = new ArrayList<Person>();
//    private List<CourseMember> courses = new ArrayList<CourseMember>();
//    private List<Class> classes = new ArrayList<Class>();
//    private List<LanguageLevel> languageLevels = new ArrayList<LanguageLevel>();
//    @JsonIgnore  private List<Publication> publications = new ArrayList<Publication>();
//    @JsonIgnore  private List<ResearchProject> researchProjects = new ArrayList<ResearchProject>();
//    @JsonIgnore  private List<StatusChange> statusChanges = new ArrayList<StatusChange>();
//    @JsonIgnore  private List<Project> projects = new ArrayList<Project>();			//Cấp 2: Hướng dẫn thành công NCS/HV
//    private StudentClass studentClass = null;
//    private EducationUnit schoolUnit = null;
//    private EduMajor major = null;
//    private EduProgram program = null;
//    @JsonIgnore  Admission admission = null;
    @JsonIgnore
    private Boolean detailLoaded = false;

    public static final int TYPE_TRAINING_REGULAR = 1;//Chính quy
    public static final int TYPE_TRAINING_DEGREE_2 = 2;//Văn bằng 2
    public static final int TYPE_TRAINING_WORK_STUDY = 3;//Vừa học vừa làm

    public static final int TYPE_ADMISSION_TUYEN_THANG = 1;//XTTN
    public static final int TYPE_ADMISSION_CU_TUYEN = 2;//Cử tuyển
    public static final int TYPE_ADMISSION_DGTD = 3;
    public static final int TYPE_ADMISSION_THPT = 4;
    public static final int TYPE_ADMISSION_LHS = 5;//Lưu học sinh

    @Override
    public Map<String, List<String>> fieldMappingColumnName() {
        Map<String, List<String>> map = new HashMap<>();
        map.put("studentId", List.of("Mã sinh viên"));
        map.put("fullName", List.of("Họ và tên"));
        map.put("birthdate", List.of("Ngày sinh"));
        map.put("birthPlace", List.of("Nơi sinh"));
        map.put("groupName", List.of("Lớp"));
        map.put("phoneNumber", List.of("Điện thoại"));
        map.put("originNation", List.of("Dân tộc"));
        map.put("nationality", List.of("Quốc tịch"));
        map.put("majorName", List.of("Ngành đào tạo"));
        map.put("year", List.of("Năm nhập học"));
        map.put("email", List.of("Email Trường"));
        map.put("personalEmail", List.of("Email cá nhân"));
        map.put("address", List.of("Địa chỉ thường trú"));
        map.put("homeCommune", List.of("Xã thường trú"));
        map.put("homeDistrict", List.of("Huyện thường trú"));
        map.put("homeProvince", List.of("Tỉnh thường trú"));
        map.put("idNumber", List.of("Số CCCD/CMND"));
        return map;
    }
}
