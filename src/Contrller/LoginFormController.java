package Contrller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginFormController {
    public AnchorPane root;

    public void login_on_action(ActionEvent actionEvent) {
    }

    public void txt_password_onaction(ActionEvent actionEvent) {
    }

    public void txt_username_onaction(ActionEvent actionEvent) {
    }

    public void hypercreatenewaccountonmouseclick(MouseEvent mouseEvent) throws IOException {
        Parent parent = FXMLLoader.load(this.getClass().getResource("../view/create_new_acc_Form.fxml"));
        Scene scene=new Scene(parent);
        Stage stage= (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Create New Account");
        stage.centerOnScreen();
    }
}
