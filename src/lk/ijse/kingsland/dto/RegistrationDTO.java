package lk.ijse.kingsland.dto;

public class RegistrationDTO {
    private int regId;
    private String regDate;
    private double regFee;
    private String regDuration;
    private String regStudent;
    private String regCourse;

    public RegistrationDTO() {
    }

    public RegistrationDTO(int regId, String regDate, double regFee, String regDuration, String regStudent, String regCourse) {
        this.regId = regId;
        this.regDate = regDate;
        this.regFee = regFee;
        this.regDuration = regDuration;
        this.regStudent = regStudent;
        this.regCourse = regCourse;
    }

    public int getRegId() {
        return regId;
    }

    public void setRegId(int regId) {
        this.regId = regId;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public double getRegFee() {
        return regFee;
    }

    public void setRegFee(double regFee) {
        this.regFee = regFee;
    }

    public String getRegDuration() {
        return regDuration;
    }

    public void setRegDuration(String regDuration) {
        this.regDuration = regDuration;
    }

    public String getRegStudent() {
        return regStudent;
    }

    public void setRegStudent(String regStudent) {
        this.regStudent = regStudent;
    }

    public String getRegCourse() {
        return regCourse;
    }

    public void setRegCourse(String regCourse) {
        this.regCourse = regCourse;
    }
}
