package Contrller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class ToDoFormController {
    public AnchorPane root;
    public Label lbl_todo_title;
    public Pane subroot;
    public TextField txt_discription;
    public Label lbl_userID;
    public ListView lsttodo;

    public void initializer(){

    }
    public void btn_add_new_todo_action(ActionEvent actionEvent) {

    }

    public void addtolist_onaction(ActionEvent actionEvent) {

    }

    public void btn_logout_onaction(ActionEvent actionEvent) {

        Parent parent= null;
        try {
            parent = FXMLLoader.load(this.getClass().getResource("/view/LoginForm.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene scene=new Scene(parent);
        Stage primarystage= (Stage) root.getScene().getWindow();
        primarystage.setScene(scene);
        primarystage.setTitle("Login form");
        primarystage.centerOnScreen();

    }
}
