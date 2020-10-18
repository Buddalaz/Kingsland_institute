package lk.ijse.kingsland.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DefaultFormController implements Initializable {

    public AnchorPane context;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            loadDefault();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadDefault() throws IOException {
        setUi("RegistrationForm");
    }

    private void setUi(String location) throws IOException {
        context.getChildren().clear();
        context.getChildren().add(FXMLLoader.load(this.getClass().getResource("/lk/ijse/kingsland/view/" +location+".fxml")));
    }

    public void addOnAction(ActionEvent actionEvent) throws IOException {
           loadDefault();
    }

    public void courseOnAction(ActionEvent actionEvent) throws IOException {
        setUi("CourseAddForm");
    }

    public void displayONAction(ActionEvent actionEvent) throws IOException {
        setUi("InformationForm");
    }
}
