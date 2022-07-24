package Contrller;

import db.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;

public class LoginFormController {
    public Button txt_login_id;
    public PasswordField txt_password_id;
    public TextField txt_username_id;
    public AnchorPane root;

    public void initialize(){
    txt_login_id.requestFocus();
    }

    public void hypercreatenewaccountonmouseclick(MouseEvent mouseEvent) throws IOException {
        Parent parent= FXMLLoader.load(this.getClass().getResource("/view/create_new_acc_Form.fxml"));
        Scene scene = new Scene(parent);
        Stage primarystage= (Stage) root.getScene().getWindow();
        primarystage.setScene(scene);
        primarystage.setTitle("Create New Form");
        primarystage.centerOnScreen();
    }

    public void txt_username_onaction(ActionEvent actionEvent) {
        txt_password_id.requestFocus();
    }

    public void txt_password_onaction(ActionEvent actionEvent) {
        txt_login_id.requestFocus();
    }

    public void login_on_action(ActionEvent actionEvent) {
        DBConnection object= DBConnection.getInstance();
        System.out.println("hi");
    }
}
