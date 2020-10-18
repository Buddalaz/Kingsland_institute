package lk.ijse.kingsland.entity;

public class Student {
    private String studId;
    private String studName;
    private String studAddress;
    private String studContact;
    private String studDate;
    private String studGender;

    public Student() {

    }

    public Student(String studId, String studName,String studAddress,
                   String studContact,String studDate,String studGender){
        this.studId = studId;
        this.studName = studName;
        this.studAddress = studAddress;
        this.studContact = studContact;
        this.studDate = studDate;
        this.studGender = studGender;
    }

    public void setStudId(String id){ this.studId = id;}

    public String getStudId(){ return studId;}

    public void setStudName(String name){this.studName = name;}

    public String getStudName(){ return studName; }

    public void setStudAddress(String address){this.studAddress = address;}

    public String getStudAddress(){ return studAddress; }

    public void setStudContact(String contact){this.studContact = contact;}

    public String getStudContact(){ return studContact; }

    public void setStudDate(String date){this.studContact = date;}

    public String getStudDate(){ return studDate;}

    public void setStudGender(String gender){this.studGender = gender;}

    public String getStudGender(){ return studGender; }
}
