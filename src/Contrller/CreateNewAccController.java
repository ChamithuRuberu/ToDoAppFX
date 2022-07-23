package Contrller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class CreateNewAccController {
    public AnchorPane root;
    public Button btnregister;
    public PasswordField txtnewpassword;
    public PasswordField txtconfirmpassword;
    public TextField txtusername;
    public TextField txtemail;
    public Label lblpasswordnotmatchtwo;
    public Label lblid;
    public Label lblpasswordnotmatchone;


    public void btnaddnewuseronaction(ActionEvent actionEvent) {
    }

    public void txtnewpasswordonaction(ActionEvent actionEvent) {
    }

    public void txtconfirmpasswordonaction(ActionEvent actionEvent) {
    }

    public void txtusernameonaction(ActionEvent actionEvent) {
    }

    public void txtemailonaction(ActionEvent actionEvent) {
    }

    public void btnregonaction(ActionEvent actionEvent) {

    }

    public void btnBackOnaction(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(this.getClass().getResource("/view/LoginForm.fxml"));
        Scene scene = new Scene(parent);
        Stage primarystage = (Stage) root.getScene().getWindow();
        primarystage.centerOnScreen();
        primarystage.setScene(scene);

    }
}
