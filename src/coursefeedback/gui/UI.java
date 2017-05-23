package coursefeedback.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class UI extends Application {

    public UI() {
    }

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

    public static void run(String[] args) {
        launch(args);
    }
}
