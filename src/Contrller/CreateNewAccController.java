package Contrller;

import db.DBConnection;
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
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateNewAccController {
    public AnchorPane root;
    public Button btnregister;
    public PasswordField txt_New_Password;
    public PasswordField txt_Confirm_Password;
    public TextField txtusername;
    public TextField txtemail;
    public Label lblpasswordnotmatchtwo;
    public Label lblid;
    public Label lblpasswordnotmatchone;
    public Label LblID;
    public Button BtnBackID;

    public void initialize() {
        lblpasswordnotmatchone.setVisible(false);
        lblpasswordnotmatchtwo.setVisible(false);
        txtusername.setDisable(true);
        txtemail.setDisable(true);
        txt_New_Password.setDisable(true);
        txt_Confirm_Password.setDisable(true);
        btnregister.setDisable(true);
        BtnBackID.setDisable(true);
    }

    public void btnaddnewuseronaction(ActionEvent actionEvent) {
        txtusername.setDisable(false);
        txtemail.setDisable(false);
        txt_New_Password.setDisable(false);
        txt_Confirm_Password.setDisable(false);
        btnregister.setDisable(false);
        BtnBackID.setDisable(false);
        txtusername.requestFocus();
        autogenaratedID();

    }

    public void txtusernameonaction(ActionEvent actionEvent) {
        txtemail.requestFocus();
    }

    public void txtnewpasswordonaction(ActionEvent actionEvent) {
        txt_Confirm_Password.requestFocus();

    }

    public void txtemailonaction(ActionEvent actionEvent) {
        txt_New_Password.requestFocus();

    }

    public void txtconfirmpasswordonaction(ActionEvent actionEvent) {
        register();
    }

    public void btnregonaction(ActionEvent actionEvent) {
        register();

    }

    public void register() {
        String new_password = txt_New_Password.getText();
        String confirm_password = txt_Confirm_Password.getText();

        boolean equals = new_password.equals(confirm_password);
        if (equals) {
            txt_New_Password.setStyle("-fx-border-color: transparent");
            txt_Confirm_Password.setStyle("-fx-border-color: transparent");
            lblpasswordnotmatchone.setVisible(false);
            lblpasswordnotmatchtwo.setVisible(false);
        } else {
            txt_New_Password.setStyle("-fx-border-color: red");
            txt_Confirm_Password.setStyle("-fx-border-color: red");
            txt_New_Password.requestFocus();
            lblpasswordnotmatchone.setVisible(true);
            lblpasswordnotmatchtwo.setVisible(true);
        }
    }

    public void btnBackOnaction(ActionEvent actionEvent) throws IOException {
        Parent parent = FXMLLoader.load(this.getClass().getResource("/view/LoginForm.fxml"));
        Scene scene = new Scene(parent);
        Stage primarystage = (Stage) root.getScene().getWindow();
        primarystage.centerOnScreen();
        primarystage.setScene(scene);

    }

    public void autogenaratedID() {
        Connection connection = DBConnection.getInstance().getConnection();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(" select id from user order by id desc limit 1");

            boolean IsAvailable = resultSet.next();

            if (IsAvailable) {
                String oldID = resultSet.getString(1);
                int length = oldID.length();
                oldID=oldID.substring(1,oldID.length());
                int intid = Integer.parseInt(oldID);//cover id into id format
                intid=intid+1;
                LblID.setText("U00"+intid);
                if (intid<10){
                    LblID.setText("U00"+intid);
                } else if (intid<100) {
                    LblID.setText("U0"+intid);

                }
                else {
                    lblid.setText("U"+intid);
                }


            } else {
                LblID.setText("U001");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
