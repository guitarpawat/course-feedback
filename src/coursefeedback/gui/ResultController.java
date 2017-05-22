package coursefeedback.gui;

import java.awt.Label;
import java.io.IOException;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollBar;
import javafx.stage.Stage;

public class ResultController {
	
	 @FXML
	    private Label score1;

	    @FXML
	    private Label score2;

	    @FXML
	    private Label score5;

	    @FXML
	    private Label score4;

	    @FXML
	    private Label score3;

	    @FXML
	    private Label comment;

	    @FXML
	    private ScrollBar scrolllBar;

	    @FXML
	    private JFXButton preComment;

	    @FXML
	    private JFXButton nextComment;

	    @FXML
	    private JFXButton backToTeach;

    
    @FXML
    void back(ActionEvent event) {
    	Stage primaryStage = new Stage();
    	Parent root;
		try {
			root = FXMLLoader.load(ClassLoader.getSystemResource("coursefeedback/gui/Teacher.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("");
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}

    }

}

