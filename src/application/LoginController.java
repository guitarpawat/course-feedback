package application;

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

import coursefeedback.data.LoginModel;

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
   public void login(ActionEvent event)throws Exception {
	   LoginModel model = new LoginModel(username.getText(),password.getText());
	   try {
		   if(model.verifyUser()) {
			   try {
				   	Stage primaryStage = new Stage(); 
					Parent root = FXMLLoader.load(ClassLoader.getSystemResource("application/Main.fxml"));
					Scene scene = new Scene(root);
					scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
					primaryStage.setTitle("Login");
					primaryStage.setScene(scene);
					primaryStage.show();
				} catch(Exception e) {
					System.out.println(e.getMessage());
				}
		   }
		   else {
			   status.setText("Failed!");
		   }
	   } catch(SQLException | ClassNotFoundException e) {
		   status.setText("ERROR : "+e.getMessage());
	   }
}

   

}

