package lk.ijse.kingsland.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.kingsland.bo.BOFactory;
import lk.ijse.kingsland.bo.custom.CourseBO;
import lk.ijse.kingsland.dto.CourseDTO;
import lk.ijse.kingsland.view.tm.CourseTM;

import javax.swing.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CourseAddFormController implements Initializable {

    public TextField txtCrCode;
    public TextField txtCrName;
    public TextField txtCrIntake;
    public TextField txtCrFee;
    public TextField txtCrDuration;
    public TableView<CourseTM> tblCourse;

    CourseBO creBO = (CourseBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.COURSE);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //initilizing the Course table
        tblCourse.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("courseCode"));
        tblCourse.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("courseName"));
        tblCourse.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("courseIntake"));
        tblCourse.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("courseFee"));
        tblCourse.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("courseDuration"));

        tblCourse.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            txtCrCode.setText(newValue.getCourseCode());
            txtCrName.setText(newValue.getCourseName());
            txtCrIntake.setText(newValue.getCourseIntake());
            txtCrFee.setText(newValue.getCourseFee()+"");
            txtCrDuration.setText(newValue.getCourseDuration());
        });

        getAllCourseDetails();
    }

    private void getAllCourseDetails() {
        try {
            ArrayList<CourseDTO> all = creBO.getAll();
            ObservableList<CourseTM> courseTmList = FXCollections.observableArrayList();
            for (CourseDTO courseDTO : all) {
                courseTmList.add(new CourseTM(courseDTO.getCourseCode(),courseDTO.getCourseName(),courseDTO.getCourseIntake(),courseDTO.getCourseFee(),courseDTO.getCourseDuration()));
            }
            tblCourse.setItems(courseTmList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addOnAction(ActionEvent actionEvent) throws Exception {
        String courseCode = txtCrCode.getText();
        String courseName = txtCrName.getText();
        String courseIntake = txtCrIntake.getText();
        double courseFee = Double.parseDouble(txtCrFee.getText());
        String courseDuration = txtCrDuration.getText();

        CourseDTO courseDTO = new CourseDTO(courseCode,courseName,courseIntake,courseFee,courseDuration);
        boolean addCustomer = creBO.addCourse(courseDTO);
        if (addCustomer) {
            new Alert(Alert.AlertType.CONFIRMATION, "Course Saved Successfully!", ButtonType.OK).show();
        } else {
            new Alert(Alert.AlertType.WARNING, "Try Again!", ButtonType.OK).show();
        }
        clearAllTextField();
        getAllCourseDetails();
    }

    public void updateOnAction(ActionEvent actionEvent) {

        CourseDTO courseDTO = new CourseDTO(txtCrCode.getText(),txtCrName.getText(),txtCrIntake.getText(),Double.parseDouble(txtCrFee.getText()),txtCrDuration.getText());
        try {
            boolean updateCourse = creBO.updateCourse(courseDTO);
            if (updateCourse){
                new Alert(Alert.AlertType.CONFIRMATION,"Course Update Successfully!", ButtonType.OK).show();
                clearAllTextField();
            }else {
                new Alert(Alert.AlertType.WARNING,"Course Update Unsuccessfully!", ButtonType.OK).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        getAllCourseDetails();
    }

    public void searchOnAction(ActionEvent actionEvent) {
        String crCodeText = txtCrCode.getText();
        try {
            CourseDTO courseDTO = creBO.serachCourse(crCodeText);
            if (courseDTO != null){
                txtCrCode.setText(courseDTO.getCourseCode());
                txtCrName.setText(courseDTO.getCourseName());
                txtCrIntake.setText(courseDTO.getCourseIntake());
                txtCrFee.setText(courseDTO.getCourseFee()+"");
                txtCrDuration.setText(courseDTO.getCourseDuration());
            }else {
                new Alert(Alert.AlertType.INFORMATION,"There's No Such Course That Equels to Serach!!!!!!", ButtonType.OK).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteOnAction(ActionEvent actionEvent) {
        try {
            boolean deleteCourse = creBO.deleteCourse(txtCrCode.getText());
            if (deleteCourse){
                new Alert(Alert.AlertType.CONFIRMATION,"Course Delete Successfully!", ButtonType.OK).show();
                clearAllTextField();
            }else {
                new Alert(Alert.AlertType.WARNING,"Course Delete Unsuccessfully!", ButtonType.OK).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        getAllCourseDetails();
    }

    public void clearOnAction(ActionEvent actionEvent) {
        clearAllTextField();
    }

    public void clearAllTextField(){
        txtCrCode.clear();
        txtCrName.clear();
        txtCrIntake.clear();
        txtCrFee.clear();
        txtCrDuration.clear();
    }
}

