package lk.ijse.kingsland.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import lk.ijse.kingsland.bo.BOFactory;
import lk.ijse.kingsland.bo.custom.CourseBO;
import lk.ijse.kingsland.bo.custom.RegistrationBO;
import lk.ijse.kingsland.dto.CourseDTO;
import lk.ijse.kingsland.dto.RegistrationDTO;
import lk.ijse.kingsland.dto.StudentDTO;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;

public class RegistrationFormController implements Initializable{

    public TextField txtStdId;
    public TextField txtStdName;
    public TextField txtAddress;
    public TextField txtContact;
    public TextField txtDob;
    public ComboBox txtCmbox;
    public TextField txtRegDate;
    public TextField txtRegFee;
    //public JFXComboBox cmbLoadCombo;
    public TextField txtStdGender;
    public TextField txtCourseDura;
    public ComboBox cmbCourseCode;
    public JFXTextField txtRegId;

    //ObservableList<String> box = FXCollections.observableArrayList("Male","Female");

    //static CourseBO crBo = (CourseBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.COURSE);
    static RegistrationBO regBo = (RegistrationBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.REGISTRATION);

    public void initialize(URL location, ResourceBundle resources) {
        //txtCmbox.setItems(box);
        genarateDate();

        loadCourseCode();

        getRegIdAuto();

        getStuId();
    }

    private void getStuId() {
        try {
            String studentId = regBo.getStudentId();
            if (studentId != null){
                //studentId = studentId.split("[A-Z]")[1];
                studentId = "S" + (Integer.parseInt(studentId)+1);
                txtStdId.setText(studentId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getRegIdAuto() {
        try {
            String regIdAuto = regBo.getRegIdAuto();
            int regID = Integer.parseInt(regIdAuto);
            regID = regID + 1;
            String registerID = String.valueOf(regID);
            txtRegId.setText(registerID);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadCourseCode() {
        List<CourseDTO> allData = null;
        try {
            allData = regBo.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<String> list = new ArrayList<>();
        for (CourseDTO o : allData) {
            list.add(o.getCourseCode());
        }
        cmbCourseCode.setItems(FXCollections.observableArrayList(list));
    }

    private void genarateDate() {
        String s = LocalDate.now().toString();
        txtRegDate.setText(s);
    }

    public void studentAddONAction(ActionEvent actionEvent) {
        String stdId = txtStdId.getText();
        String stdName = txtStdName.getText();
        String stdAddress = txtAddress.getText();
        String stdContact = txtContact.getText();
        String stdDob = txtDob.getText();
        String stdGender = txtStdGender.getText();

        int regIdText = Integer.parseInt(txtRegId.getText());
        String regDate = txtRegDate.getText();
        double regFee = Double.parseDouble(txtRegFee.getText());
        String dura = txtCourseDura.getText();
        String cCode = cmbCourseCode.getSelectionModel().getSelectedItem().toString();

        ArrayList<RegistrationDTO> regDetails = new ArrayList();

        RegistrationDTO regDTO = new RegistrationDTO(regIdText,regDate,regFee,dura,stdId,cCode);
        regDetails.add(regDTO);

        StudentDTO studentDTO = new StudentDTO(stdId,stdName,stdAddress,stdContact,stdDob,stdGender,regDetails);

        try {
            boolean add = regBo.addRegistration(studentDTO);
            if (add) {
                new Alert(Alert.AlertType.INFORMATION,"Registration Successfully", ButtonType.OK).show();
            }else {
                new Alert(Alert.AlertType.INFORMATION,"Registration Unsuccessfully", ButtonType.OK).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void selectCurDetOnAction(ActionEvent actionEvent) {
        String curCode = cmbCourseCode.getSelectionModel().getSelectedItem().toString();
        try {
            CourseDTO serachCourse = regBo.serachCourse(curCode);
            if (serachCourse != null){
                txtRegFee.setText(serachCourse.getCourseFee()+"");
                txtCourseDura.setText(serachCourse.getCourseDuration());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
