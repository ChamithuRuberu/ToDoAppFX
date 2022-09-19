package Contrller;

import db.DBConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

import static javafx.fxml.FXMLLoader.load;

public class LoginFormController {
    public Button txt_login_id;
    public TextField txt_username_id;
    public AnchorPane root;
    public PasswordField txt_Password_id;


    public void initialize(){
    txt_login_id.requestFocus();
    }

    public void txt_username_onaction(ActionEvent actionEvent) {
        txt_Password_id.requestFocus();
    }

    public void txt_password_onaction(ActionEvent actionEvent)throws IOException {
   login();
    }

    public void login_on_action(ActionEvent actionEvent) throws IOException {
    login();
    }

    public void hypercreatenewaccountonmouseclick(MouseEvent mouseEvent) throws IOException {
        Parent parent= load(this.getClass().getResource("../view/create_new_acc_Form.fxml"));
        Scene scene = new Scene(parent);
        Stage primarystage= (Stage) root.getScene().getWindow();
        primarystage.setScene(scene);
        primarystage.setTitle("Create New Form");
        primarystage.centerOnScreen();
    }

public void login(){
    String username = txt_username_id.getText();
    String password = txt_Password_id.getText();
    Connection connection = DBConnection.getInstance().getConnection();
    try {
        PreparedStatement preparedStatement = connection.prepareStatement("select * from user where username = ? and confirm_password = ?");
        preparedStatement.setObject(1,username);
        preparedStatement.setObject(2,password);

        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){

        Parent parent=FXMLLoader.load(this.getClass().getResource("../view/ToDoForm.fxml"));
        Scene scene=new Scene(parent);
        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("ToDO Form");
        stage.centerOnScreen();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR,"Invalid");
            alert.showAndWait();
            txt_Password_id.clear();
            txt_username_id.clear();
            txt_username_id.requestFocus();
        }
    }
    catch (SQLException | IOException e) {
        throw new RuntimeException(e);
    }
    }

}
