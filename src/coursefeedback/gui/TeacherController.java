package coursefeedback.gui;

import com.jfoenix.controls.JFXButton;
import coursefeedback.data.Course;
import coursefeedback.data.ResultModel;
import coursefeedback.data.User;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class TeacherController implements Observer {

    @FXML
    private Label nameTeacher;

    @FXML
    private Label IDTeach1;

    @FXML
    private Label IDTeach2;

    @FXML
    private Label IDTeach3;

    @FXML
    private Label IDTeach4;

    @FXML
    private Label IDTeach5;

    @FXML
    private Label IDTeach6;

    @FXML
    private Label IDTeach7;

    @FXML
    private Label IDTeach8;

    @FXML
    private Label IDTeach9;

    @FXML
    private Label IDTeach10;

    @FXML
    private Label courseTeach1;

    @FXML
    private Label courseTeach10;

    @FXML
    private Label courseTeach9;

    @FXML
    private Label courseTeach8;

    @FXML
    private Label courseTeach7;

    @FXML
    private Label courseTeach6;

    @FXML
    private Label courseTeach5;

    @FXML
    private Label courseTeach4;

    @FXML
    private Label courseTeach3;

    @FXML
    private Label courseTeach2;

    @FXML
    private Label secTeach1;

    @FXML
    private Label secTeach10;

    @FXML
    private Label secTeach9;

    @FXML
    private Label secTeach8;

    @FXML
    private Label secTeach7;

    @FXML
    private Label secTeach6;

    @FXML
    private Label secTeach5;

    @FXML
    private Label secTeach4;

    @FXML
    private Label secTeach3;

    @FXML
    private Label secTeach2;

    @FXML
    private JFXButton feedTeach1;

    @FXML
    private JFXButton feedTeach10;

    @FXML
    private JFXButton feedTeach9;

    @FXML
    private JFXButton feedTeach8;

    @FXML
    private JFXButton feedTeach7;

    @FXML
    private JFXButton feedTeach6;

    @FXML
    private JFXButton feedTeach5;

    @FXML
    private JFXButton feedTeach4;

    @FXML
    private JFXButton feedTeach3;

    @FXML
    private JFXButton feedTeach2;

    User teacher;
    Course[] courses;

    public void initialize() {
        nameTeacher.setText("Loading...");
        Sender.getInstance().addObserver(this);
    }

    @Override
    public void update(Observable subject, Object msg) {
        if (msg != null) {
            if (msg instanceof SendPackage) {
                SendPackage pack = (SendPackage) msg;
                if (pack.getMessage().equals("SET TEACHER DATA")) {
                    teacher = (User) pack.getObject();
                    try {
                        courses = teacher.getCoursesObject();
                    } catch (SQLException | ClassNotFoundException e) {
                        System.err.println(e.getMessage());
                        nameTeacher.setText("ERROR : " + e.getMessage());
                        return;
                    }
                    Course temp;
                    if (courses.length > 0) {
                        temp = courses[0];
                        IDTeach1.setText(temp.getCourseID());
                        courseTeach1.setText(" " + temp.getCourseName());
                        secTeach1.setText(temp.getSection() + "");
                        feedTeach1.setVisible(true);
                    }

                    if (courses.length > 1) {
                        temp = courses[1];
                        IDTeach2.setText(temp.getCourseID());
                        courseTeach2.setText(" " + temp.getCourseName());
                        secTeach2.setText(temp.getSection() + "");
                        feedTeach2.setVisible(true);
                    }

                    if (courses.length > 2) {
                        temp = courses[2];
                        IDTeach3.setText(temp.getCourseID());
                        courseTeach3.setText(" " + temp.getCourseName());
                        secTeach3.setText(temp.getSection() + "");
                        feedTeach3.setVisible(true);
                    }

                    if (courses.length > 3) {
                        temp = courses[3];
                        IDTeach4.setText(temp.getCourseID());
                        courseTeach4.setText(" " + temp.getCourseName());
                        secTeach4.setText(temp.getSection() + "");
                        feedTeach4.setVisible(true);
                    }

                    if (courses.length > 4) {
                        temp = courses[4];
                        IDTeach5.setText(temp.getCourseID());
                        courseTeach5.setText(" " + temp.getCourseName());
                        secTeach5.setText(temp.getSection() + "");
                        feedTeach5.setVisible(true);
                    }

                    if (courses.length > 5) {
                        temp = courses[5];
                        IDTeach6.setText(temp.getCourseID());
                        courseTeach6.setText(" " + temp.getCourseName());
                        secTeach6.setText(temp.getSection() + "");
                        feedTeach6.setVisible(true);
                    }

                    if (courses.length > 6) {
                        temp = courses[6];
                        IDTeach7.setText(temp.getCourseID());
                        courseTeach7.setText(" " + temp.getCourseName());
                        secTeach7.setText(temp.getSection() + "");
                        feedTeach7.setVisible(true);
                    }

                    if (courses.length > 7) {
                        temp = courses[7];
                        IDTeach8.setText(temp.getCourseID());
                        courseTeach8.setText(" " + temp.getCourseName());
                        secTeach8.setText(temp.getSection() + "");
                        feedTeach8.setVisible(true);
                    }

                    if (courses.length > 8) {
                        temp = courses[8];
                        IDTeach9.setText(temp.getCourseID());
                        courseTeach9.setText(" " + temp.getCourseName());
                        secTeach9.setText(temp.getSection() + "");
                        feedTeach9.setVisible(true);
                    }

                    if (courses.length > 9) {
                        temp = courses[9];
                        IDTeach10.setText(temp.getCourseID());
                        courseTeach10.setText(" " + temp.getCourseName());
                        secTeach10.setText(temp.getSection() + "");
                        feedTeach10.setVisible(true);
                    }
                    nameTeacher.setText(teacher.toString());
                }
            }
        }
    }

    @FXML
    void view1(ActionEvent event) {
        try {
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(ClassLoader.getSystemResource("coursefeedback/gui/Result.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setTitle("Course " + courses[0].getCourseID() + " : " + courses[0].getCourseName() + " - Results");
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();
            Sender.getInstance().send(new ResultModel(courses[0]), "GET COURSE RESULT");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @FXML
    void view2(ActionEvent event) {
        try {
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(ClassLoader.getSystemResource("coursefeedback/gui/Result.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setTitle("Course " + courses[1].getCourseID() + " : " + courses[1].getCourseName() + " - Results");
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();
            Sender.getInstance().send(new ResultModel(courses[1]), "GET COURSE RESULT");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @FXML
    void view3(ActionEvent event) {
        try {
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(ClassLoader.getSystemResource("coursefeedback/gui/Result.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setTitle("Course " + courses[2].getCourseID() + " : " + courses[2].getCourseName() + " - Results");
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();
            Sender.getInstance().send(new ResultModel(courses[2]), "GET COURSE RESULT");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @FXML
    void view4(ActionEvent event) {
        try {
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(ClassLoader.getSystemResource("coursefeedback/gui/Result.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setTitle("Course " + courses[3].getCourseID() + " : " + courses[3].getCourseName() + " - Results");
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();
            Sender.getInstance().send(new ResultModel(courses[3]), "GET COURSE RESULT");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @FXML
    void view5(ActionEvent event) {
        try {
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(ClassLoader.getSystemResource("coursefeedback/gui/Result.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setTitle("Course " + courses[4].getCourseID() + " : " + courses[4].getCourseName() + " - Results");
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();
            Sender.getInstance().send(new ResultModel(courses[4]), "GET COURSE RESULT");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @FXML
    void view6(ActionEvent event) {
        try {
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(ClassLoader.getSystemResource("coursefeedback/gui/Result.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setTitle("Course " + courses[5].getCourseID() + " : " + courses[5].getCourseName() + " - Results");
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();
            Sender.getInstance().send(new ResultModel(courses[5]), "GET COURSE RESULT");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @FXML
    void view7(ActionEvent event) {
        try {
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(ClassLoader.getSystemResource("coursefeedback/gui/Result.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setTitle("Course " + courses[6].getCourseID() + " : " + courses[6].getCourseName() + " - Results");
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();
            Sender.getInstance().send(new ResultModel(courses[6]), "GET COURSE RESULT");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @FXML
    void view8(ActionEvent event) {
        try {
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(ClassLoader.getSystemResource("coursefeedback/gui/Result.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setTitle("Course " + courses[7].getCourseID() + " : " + courses[7].getCourseName() + " - Results");
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();
            Sender.getInstance().send(new ResultModel(courses[7]), "GET COURSE RESULT");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @FXML
    void view9(ActionEvent event) {
        try {
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(ClassLoader.getSystemResource("coursefeedback/gui/Result.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setTitle("Course " + courses[8].getCourseID() + " : " + courses[8].getCourseName() + " - Results");
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();
            Sender.getInstance().send(new ResultModel(courses[8]), "GET COURSE RESULT");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @FXML
    void view10(ActionEvent event) {
        try {
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(ClassLoader.getSystemResource("coursefeedback/gui/Result.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setTitle("Course " + courses[9].getCourseID() + " : " + courses[9].getCourseName() + " - Results");
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();
            Sender.getInstance().send(new ResultModel(courses[9]), "GET COURSE RESULT");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
