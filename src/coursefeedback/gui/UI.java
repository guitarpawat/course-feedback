package coursefeedback.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * Run the application. Start from login until the last page.
 * 
 * @author Noppawan Kulchol
 * @author Pawat Nakpiphatkul
 *
 */
public class UI extends Application {

	public UI() {
	}

	/**
	 * For build the window of application that start from login.
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(ClassLoader.getSystemResource("coursefeedback/gui/Login.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Login");
			primaryStage.setResizable(false);
			primaryStage.show();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * This method is used for called launch(). It must not be
	 * called more than once or an exception will be thrown. The launch method
	 * does not return until the application has exited
	 * 
	 * @param args
	 */
	public static void run(String[] args) {
		launch(args);
	}
}
