package lk.ijse.kingsland.entity;

public class Course {

    private String courseCode;
    private String courseName;
    private String courseIntake;
    private double courseFee;
    private String courseDuration;

    public Course(){

    }

    public Course(String courseCode, String courseName, String courseIntake, double courseFee, String courseDuration) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.courseIntake = courseIntake;
        this.courseFee = courseFee;
        this.courseDuration = courseDuration;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseIntake() {
        return courseIntake;
    }

    public void setCourseIntake(String courseIntake) {
        this.courseIntake = courseIntake;
    }

    public double getCourseFee() {
        return courseFee;
    }

    public void setCourseFee(double courseFee) {
        this.courseFee = courseFee;
    }

    public String getCourseDuration() {
        return courseDuration;
    }

    public void setCourseDuration(String courseDuration) {
        this.courseDuration = courseDuration;
    }
}
