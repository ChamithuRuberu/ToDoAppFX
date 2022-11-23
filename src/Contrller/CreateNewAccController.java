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
    public PasswordField txt_New_Password;
    public PasswordField txt_Confirm_Password;
    public Label lblpasswordnotmatchone;
    public TextField extremal;
    public TextField username;
    public Button unregister;
    public Label lblpasswordnotmatchtwo;
    public Button BtnBackID;
    public Label LblID;
    public AnchorPane root;
    public Button btnregister;
    public TextField txtusername;
    public TextField txtemail;

    public void initialize(){
        lblpasswordnotmatchone.setVisible(false);
        lblpasswordnotmatchtwo.setVisible(false);
    }
    public void btnregonaction(ActionEvent actionEvent) {
        register();
    }

    public void txtnewpasswordonaction(ActionEvent actionEvent) {
        txt_Confirm_Password.requestFocus();
    }

    public void txtconfirmpasswordonaction(ActionEvent actionEvent) {
        register();
    }

    public void txtusernameonaction(ActionEvent actionEvent) {
        txtemail.requestFocus();
    }

    public void txtemailonaction(ActionEvent actionEvent) {
        txt_New_Password.requestFocus();
    }

    public void btnaddnewuseronaction(ActionEvent actionEvent) {
        txtusername.requestFocus();
    }

    public void btnBackOnaction(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(this.getClass().getResource("../view/LoginForm.fxml"));
        Scene scene=new Scene(parent);
        Stage stage= (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Login Form");
        stage.centerOnScreen();
        }


    // method for validate password
    public void register() {
        String new_password = txt_New_Password.getText();
        String confirm_password = txt_Confirm_Password.getText();

        boolean equals = new_password.equals(confirm_password);

        if (equals){
            txt_New_Password.setStyle("-fx-border-color: transparent");
            txt_Confirm_Password.setStyle("-fx-border-color: transparent");
            lblpasswordnotmatchone.setVisible(false);
            lblpasswordnotmatchtwo.setVisible(false);
        }
        else {
            txt_New_Password.setStyle("-fx-border-color: red");
            txt_Confirm_Password.setStyle("-fx-border-color: red");
            lblpasswordnotmatchtwo.setVisible(true);
            lblpasswordnotmatchone.setVisible(true);
            txt_New_Password.requestFocus();
        }
    }
}




