package lk.ijse.kingsland.dto;

import java.util.ArrayList;

public class StudentDTO {

    private String studId;
    private String studName;
    private String studAddress;
    private String studContact;
    private String studDate;
    private String studGender;
    private ArrayList<RegistrationDTO> registrationDetails;

    public StudentDTO() {
    }

    public StudentDTO(String studId, String studName, String studAddress, String studContact, String studDate, String studGender, ArrayList<RegistrationDTO> registrationDetails) {
        this.studId = studId;
        this.studName = studName;
        this.studAddress = studAddress;
        this.studContact = studContact;
        this.studDate = studDate;
        this.studGender = studGender;
        this.registrationDetails = registrationDetails;
    }

    public String getStudId() {
        return studId;
    }

    public void setStudId(String studId) {
        this.studId = studId;
    }

    public String getStudName() {
        return studName;
    }

    public void setStudName(String studName) {
        this.studName = studName;
    }

    public String getStudAddress() {
        return studAddress;
    }

    public void setStudAddress(String studAddress) {
        this.studAddress = studAddress;
    }

    public String getStudContact() {
        return studContact;
    }

    public void setStudContact(String studContact) {
        this.studContact = studContact;
    }

    public String getStudDate() {
        return studDate;
    }

    public void setStudDate(String studDate) {
        this.studDate = studDate;
    }

    public String getStudGender() {
        return studGender;
    }

    public void setStudGender(String studGender) {
        this.studGender = studGender;
    }

    public ArrayList<RegistrationDTO> getRegistrationDetails() {
        return registrationDetails;
    }

    public void setRegistrationDetails(ArrayList<RegistrationDTO> registrationDetails) {
        this.registrationDetails = registrationDetails;
    }
}
