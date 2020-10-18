package lk.ijse.kingsland.entity;

public class Registration {

    private int regNo;
    private String regDate;
    private double regFee;
    private String regDuration;
    private String regStudent;
    private String regCourse;

    public Registration() {
    }

    public Registration(int regNo, String regDate, double regFee, String regDuration, String regStudent, String regCourse) {
        this.regNo = regNo;
        this.regDate = regDate;
        this.regFee = regFee;
        this.regDuration = regDuration;
        this.regStudent = regStudent;
        this.regCourse = regCourse;
    }

    public int getRegNo() {
        return regNo;
    }

    public void setRegNo(int regNo) {
        this.regNo = regNo;
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
