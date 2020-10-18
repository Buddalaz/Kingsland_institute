package lk.ijse.kingsland.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.kingsland.bo.BOFactory;
import lk.ijse.kingsland.bo.custom.RegistrationBO;
import lk.ijse.kingsland.dto.CustomDTO;
import lk.ijse.kingsland.view.tm.CustomTM;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class InformationFormController implements Initializable {

    public TextField txtCurCode;
    public TableView<CustomTM> tblCursStudent;

    RegistrationBO registrationBO = (RegistrationBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.REGISTRATION);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tblCursStudent.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("curCode"));
        tblCursStudent.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("stdName"));
    }

    public void serachCruStuOnAction(ActionEvent actionEvent) {
        String cruText = txtCurCode.getText();
        try {
            ArrayList<CustomDTO> customDTOArrayList = registrationBO.searchOrderFromID(cruText);
            ObservableList<CustomTM> customTMS = FXCollections.observableArrayList();
            for (CustomDTO customDTO : customDTOArrayList) {
                customTMS.add(new CustomTM(customDTO.getCurCode(),customDTO.getStdName()));
            }
            tblCursStudent.setItems(customTMS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
