package coursefeedback.gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import coursefeedback.data.Course;

import coursefeedback.data.LoginModel;
import coursefeedback.data.StudentModel;
import coursefeedback.data.User;
import java.util.List;

public class LoginController {

    @FXML
    private JFXTextField username;

    @FXML
    private JFXPasswordField password;

    @FXML
    private JFXButton login;

    @FXML
    private Label status;

    @FXML
    public void login(ActionEvent event) throws Exception {
        status.setText("Please wait...");
        login.setDisable(true);
        LoginModel model = new LoginModel(username.getText(), password.getText());
        try {
            if (model.verifyUser()) {
                try {
                    User user = new User(model.getUsername());
                    if(user.getUserStatus() == 1) {
                        Stage primaryStage = new Stage();
                        Parent root = FXMLLoader.load(ClassLoader.getSystemResource("coursefeedback/gui/Student.fxml"));
                        Scene scene = new Scene(root);
                        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
                        primaryStage.setTitle("Feedback for student");
                        primaryStage.setScene(scene);
                        primaryStage.setResizable(false);
                        primaryStage.show();
                        Stage loginStage = (Stage) login.getScene().getWindow();
                        loginStage.close();
                        Sender.getInstance().send(new StudentModel(user), "UPDATE STUDENT DATA");
                    }
                    else if(user.getUserStatus() == 3) {
                        Stage primaryStage = new Stage();
                        Parent root = FXMLLoader.load(ClassLoader.getSystemResource("coursefeedback/gui/Teacher.fxml"));
                        Scene scene = new Scene(root);
                        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
                        primaryStage.setTitle("Feedback for student");
                        primaryStage.setScene(scene);
                        primaryStage.setResizable(false);
                        primaryStage.show();
                        Stage loginStage = (Stage) login.getScene().getWindow();
                        loginStage.close();
                        Sender.getInstance().send(user, "SET TEACHER DATA");
                    }
                    else {
                        status.setText("Incorrect user status : Access Denied");
                    }
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                    e.printStackTrace();
                }
            } else {
                status.setText("Incorrect username and/or password");
            }
        } catch (SQLException | ClassNotFoundException e) {
            status.setText("ERROR : " + e.getMessage());
        }
        finally {
            login.setDisable(false);
        }
    }

}
