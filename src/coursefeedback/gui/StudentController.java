package coursefeedback.gui;

import coursefeedback.data.Course;
import coursefeedback.data.StudentModel;
import java.util.Observable;
import java.util.Observer;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import com.jfoenix.controls.JFXButton;
import coursefeedback.data.FeedbackModel;
import java.util.Arrays;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StudentController implements Observer {

    @FXML
    private Label IDStudent1;

    @FXML
    private Label courseStudent1;

    @FXML
    private Label IDStudent10;

    @FXML
    private Label IDStudent7;

    @FXML
    private Label IDStudent9;

    @FXML
    private Label IDStudent8;

    @FXML
    private Label IDStudent6;

    @FXML
    private Label IDStudent5;

    @FXML
    private Label IDStudent4;

    @FXML
    private Label IDStudent3;

    @FXML
    private Label IDStudent2;

    @FXML
    private Label courseStudent10;

    @FXML
    private Label courseStudent9;

    @FXML
    private Label courseStudent8;

    @FXML
    private Label courseStudent7;

    @FXML
    private Label courseStudent6;

    @FXML
    private Label courseStudent5;

    @FXML
    private Label courseStudent4;

    @FXML
    private Label courseStudent3;

    @FXML
    private Label courseStudent2;

    @FXML
    private JFXButton feedStudent1;

    @FXML
    private JFXButton feedStudent10;

    @FXML
    private JFXButton feedStudent9;

    @FXML
    private JFXButton feedStudent8;

    @FXML
    private JFXButton feedStudent7;

    @FXML
    private JFXButton feedStudent6;

    @FXML
    private JFXButton feedStudent5;

    @FXML
    private JFXButton feedStudent4;

    @FXML
    private JFXButton feedStudent3;

    @FXML
    private JFXButton feedStudent2;

    @FXML
    private Label secStudent1;

    @FXML
    private Label secStudent10;

    @FXML
    private Label secStudent9;

    @FXML
    private Label secStudent8;

    @FXML
    private Label secStudent7;

    @FXML
    private Label secStudent6;

    @FXML
    private Label secStudent5;

    @FXML
    private Label secStudent4;

    @FXML
    private Label secStudent3;

    @FXML
    private Label secStudent2;

    @FXML
    private Label welcomeStudent;

    @FXML
    private Label nameStudent;

    private Course[] courses;
    private StudentModel model;

    public void initialize() {
        reset();
        Sender.getInstance().addObserver(this);
    }

    @Override
    public void update(Observable subject, Object msg) {
        if (msg != null) {
            if (msg instanceof SendPackage) {
                SendPackage pack = (SendPackage) msg;
                if (pack.getMessage().equals("UPDATE STUDENT DATA")) {
                    if (pack.getObject() instanceof StudentModel) {
                        reset();
                        model = (StudentModel) pack.getObject();
                        courses = model.getCourses();
                        Course temp;
                        if (courses.length > 0) {
                            temp = courses[0];
                            IDStudent1.setText(temp.getCourseID());
                            courseStudent1.setText(" " + temp.getCourseName());
                            secStudent1.setText(Integer.toString(temp.getSection()));
                            if (Arrays.asList(model.getNotSentFeedbackCourse()).contains(temp)) {
                                feedStudent1.setText("Send Feedback");
                                feedStudent1.setDisable(false);
                            }
                            feedStudent1.setVisible(true);
                        }
                        if (courses.length > 1) {
                            temp = courses[1];
                            IDStudent2.setText(temp.getCourseID());
                            courseStudent2.setText(" " + temp.getCourseName());
                            secStudent2.setText(Integer.toString(temp.getSection()));
                            if (Arrays.asList(model.getNotSentFeedbackCourse()).contains(temp)) {
                                feedStudent2.setText("Send Feedback");
                                feedStudent2.setDisable(false);
                            }
                            feedStudent2.setVisible(true);
                        }
                        if (courses.length > 2) {
                            temp = courses[2];
                            IDStudent3.setText(temp.getCourseID());
                            courseStudent3.setText(" " + temp.getCourseName());
                            secStudent3.setText(Integer.toString(temp.getSection()));
                            if (Arrays.asList(model.getNotSentFeedbackCourse()).contains(temp)) {
                                feedStudent3.setText("Send Feedback");
                                feedStudent3.setDisable(false);
                            }
                            feedStudent3.setVisible(true);
                        }
                        if (courses.length > 3) {
                            temp = courses[3];
                            IDStudent4.setText(temp.getCourseID());
                            courseStudent4.setText(" " + temp.getCourseName());
                            secStudent4.setText(Integer.toString(temp.getSection()));
                            if (Arrays.asList(model.getNotSentFeedbackCourse()).contains(temp)) {
                                feedStudent4.setText("Send Feedback");
                                feedStudent4.setDisable(false);
                            }
                            feedStudent4.setVisible(true);
                        }
                        if (courses.length > 4) {
                            temp = courses[4];
                            IDStudent5.setText(temp.getCourseID());
                            courseStudent5.setText(" " + temp.getCourseName());
                            secStudent5.setText(Integer.toString(temp.getSection()));
                            if (Arrays.asList(model.getNotSentFeedbackCourse()).contains(temp)) {
                                feedStudent5.setText("Send Feedback");
                                feedStudent5.setDisable(false);
                            }
                            feedStudent5.setVisible(true);
                        }
                        if (courses.length > 5) {
                            temp = courses[5];
                            IDStudent6.setText(temp.getCourseID());
                            courseStudent6.setText(" " + temp.getCourseName());
                            secStudent6.setText(Integer.toString(temp.getSection()));
                            if (Arrays.asList(model.getNotSentFeedbackCourse()).contains(temp)) {
                                feedStudent6.setText("Send Feedback");
                                feedStudent6.setDisable(false);
                            }
                            feedStudent6.setVisible(true);
                        }
                        if (courses.length > 6) {
                            temp = courses[6];
                            IDStudent7.setText(temp.getCourseID());
                            courseStudent7.setText(" " + temp.getCourseName());
                            secStudent7.setText(Integer.toString(temp.getSection()));
                            if (Arrays.asList(model.getNotSentFeedbackCourse()).contains(temp)) {
                                feedStudent7.setText("Send Feedback");
                                feedStudent7.setDisable(false);
                            }
                            feedStudent7.setVisible(true);
                        }
                        if (courses.length > 7) {
                            temp = courses[7];
                            IDStudent8.setText(temp.getCourseID());
                            courseStudent8.setText(" " + temp.getCourseName());
                            secStudent8.setText(Integer.toString(temp.getSection()));
                            if (Arrays.asList(model.getNotSentFeedbackCourse()).contains(temp)) {
                                feedStudent8.setText("Send Feedback");
                                feedStudent8.setDisable(false);
                            }
                            feedStudent8.setVisible(true);
                        }
                        if (courses.length > 8) {
                            temp = courses[8];
                            IDStudent9.setText(temp.getCourseID());
                            courseStudent9.setText(" " + temp.getCourseName());
                            secStudent9.setText(Integer.toString(temp.getSection()));
                            if (Arrays.asList(model.getNotSentFeedbackCourse()).contains(temp)) {
                                feedStudent9.setText("Send Feedback");
                                feedStudent9.setDisable(false);
                            }
                            feedStudent9.setVisible(true);
                        }
                        if (courses.length > 9) {
                            temp = courses[9];
                            IDStudent10.setText(temp.getCourseID());
                            courseStudent10.setText(" " + temp.getCourseName());
                            secStudent10.setText(Integer.toString(temp.getSection()));
                            if (Arrays.asList(model.getNotSentFeedbackCourse()).contains(temp)) {
                                feedStudent10.setText("Send Feedback");
                                feedStudent10.setDisable(false);
                            }
                            feedStudent10.setVisible(true);
                        }
                        nameStudent.setText(model.getStudent().toString());
                    }
                }
            }
        }
    }

    private void reset() {
        nameStudent.setText("Loading...");
        feedStudent1.setVisible(false);
        feedStudent1.setDisable(true);
        feedStudent1.setText("Feedback Sent");
        feedStudent2.setVisible(false);
        feedStudent2.setDisable(true);
        feedStudent2.setText("Feedback Sent");
        feedStudent3.setVisible(false);
        feedStudent3.setDisable(true);
        feedStudent3.setText("Feedback Sent");
        feedStudent4.setVisible(false);
        feedStudent4.setDisable(true);
        feedStudent4.setText("Feedback Sent");
        feedStudent5.setVisible(false);
        feedStudent5.setDisable(true);
        feedStudent5.setText("Feedback Sent");
        feedStudent6.setVisible(false);
        feedStudent6.setDisable(true);
        feedStudent6.setText("Feedback Sent");
        feedStudent7.setVisible(false);
        feedStudent7.setDisable(true);
        feedStudent7.setText("Feedback Sent");
        feedStudent8.setVisible(false);
        feedStudent8.setDisable(true);
        feedStudent8.setText("Feedback Sent");
        feedStudent9.setVisible(false);
        feedStudent9.setDisable(true);
        feedStudent9.setText("Feedback Sent");
        feedStudent10.setVisible(false);
        feedStudent10.setDisable(true);
        feedStudent10.setText("Feedback Sent");
        secStudent1.setText("");
        secStudent2.setText("");
        secStudent3.setText("");
        secStudent4.setText("");
        secStudent5.setText("");
        secStudent6.setText("");
        secStudent7.setText("");
        secStudent8.setText("");
        secStudent9.setText("");
        secStudent10.setText("");
        courseStudent1.setText("");
        courseStudent2.setText("");
        courseStudent3.setText("");
        courseStudent4.setText("");
        courseStudent5.setText("");
        courseStudent6.setText("");
        courseStudent7.setText("");
        courseStudent8.setText("");
        courseStudent9.setText("");
        courseStudent10.setText("");
        IDStudent1.setText("");
        IDStudent2.setText("");
        IDStudent3.setText("");
        IDStudent4.setText("");
        IDStudent5.setText("");
        IDStudent6.setText("");
        IDStudent7.setText("");
        IDStudent8.setText("");
        IDStudent9.setText("");
        IDStudent10.setText("");
    }

    @FXML
    void send1(ActionEvent event) {
        try {
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(ClassLoader.getSystemResource("coursefeedback/gui/Feedback.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setTitle("Course " + courses[0].getCourseID() + " : " + courses[0].getCourseName() + " - Feedback");
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();
            Sender.getInstance().send(new FeedbackModel(model.getStudent(), courses[0]), "OPEN COURSE FEEDBACK");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @FXML
    void send2(ActionEvent event) {
        try {
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(ClassLoader.getSystemResource("coursefeedback/gui/Feedback.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setTitle("Course " + courses[1].getCourseID() + " : " + courses[1].getCourseName() + " - Feedback");
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();
            Sender.getInstance().send(new FeedbackModel(model.getStudent(), courses[1]), "OPEN COURSE FEEDBACK");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @FXML
    void send3(ActionEvent event) {
        try {
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(ClassLoader.getSystemResource("coursefeedback/gui/Feedback.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setTitle("Course " + courses[2].getCourseID() + " : " + courses[2].getCourseName() + " - Feedback");
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();
            Sender.getInstance().send(new FeedbackModel(model.getStudent(), courses[2]), "OPEN COURSE FEEDBACK");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @FXML
    void send4(ActionEvent event) {
        try {
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(ClassLoader.getSystemResource("coursefeedback/gui/Feedback.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setTitle("Course " + courses[3].getCourseID() + " : " + courses[3].getCourseName() + " - Feedback");
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();
            Sender.getInstance().send(new FeedbackModel(model.getStudent(), courses[3]), "OPEN COURSE FEEDBACK");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @FXML
    void send5(ActionEvent event) {
        try {
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(ClassLoader.getSystemResource("coursefeedback/gui/Feedback.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setTitle("Course " + courses[4].getCourseID() + " : " + courses[4].getCourseName() + " - Feedback");
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();
            Sender.getInstance().send(new FeedbackModel(model.getStudent(), courses[4]), "OPEN COURSE FEEDBACK");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @FXML
    void send6(ActionEvent event) {
        try {
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(ClassLoader.getSystemResource("coursefeedback/gui/Feedback.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setTitle("Course " + courses[5].getCourseID() + " : " + courses[5].getCourseName() + " - Feedback");
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();
            Sender.getInstance().send(new FeedbackModel(model.getStudent(), courses[5]), "OPEN COURSE FEEDBACK");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @FXML
    void send7(ActionEvent event) {
        try {
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(ClassLoader.getSystemResource("coursefeedback/gui/Feedback.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setTitle("Course " + courses[6].getCourseID() + " : " + courses[6].getCourseName() + " - Feedback");
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();
            Sender.getInstance().send(new FeedbackModel(model.getStudent(), courses[6]), "OPEN COURSE FEEDBACK");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @FXML
    void send8(ActionEvent event) {
        try {
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(ClassLoader.getSystemResource("coursefeedback/gui/Feedback.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setTitle("Course " + courses[7].getCourseID() + " : " + courses[7].getCourseName() + " - Feedback");
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();
            Sender.getInstance().send(new FeedbackModel(model.getStudent(), courses[7]), "OPEN COURSE FEEDBACK");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @FXML
    void sent9(ActionEvent event) {
        try {
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(ClassLoader.getSystemResource("coursefeedback/gui/Feedback.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setTitle("Course " + courses[8].getCourseID() + " : " + courses[8].getCourseName() + " - Feedback");
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();
            Sender.getInstance().send(new FeedbackModel(model.getStudent(), courses[8]), "OPEN COURSE FEEDBACK");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @FXML
    void sent10(ActionEvent event) {
        try {
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(ClassLoader.getSystemResource("coursefeedback/gui/Feedback.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setTitle("Course " + courses[9].getCourseID() + " : " + courses[9].getCourseName() + " - Feedback");
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();
            Sender.getInstance().send(new FeedbackModel(model.getStudent(), courses[9]), "OPEN COURSE FEEDBACK");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

}
