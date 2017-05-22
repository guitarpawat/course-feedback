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
		LoginModel model = new LoginModel(username.getText(), password.getText());
		try {
			if (model.verifyUser()) {
				try {
                                        User student = new User(model.getUsername());
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
                                        Sender.getInstance().send(new StudentModel(student),"UPDATE STUDENT DATA");
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}
			} else {
				status.setText("Failed!");
			}
		} catch (SQLException | ClassNotFoundException e) {
			status.setText("ERROR : " + e.getMessage());
		}
	}

}
