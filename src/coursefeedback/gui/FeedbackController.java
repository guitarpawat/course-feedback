package coursefeedback.gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import coursefeedback.data.Course;
import coursefeedback.data.FeedbackModel;
import coursefeedback.data.StudentModel;
import coursefeedback.data.User;
import coursefeedback.db.DBConnector;
import coursefeedback.db.DBQuery;
import java.net.URL;
import java.sql.SQLException;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class FeedbackController extends DBQuery implements Observer {
    
    @FXML
    private JFXTextField feedback;

    @FXML
    private Label warn;

    @FXML
    private ToggleGroup q1;

    @FXML
    private ToggleGroup q2;

    @FXML
    private ToggleGroup q3;

    @FXML
    private ToggleGroup q4;

    @FXML
    private ToggleGroup q5;

    @FXML
    private JFXRadioButton q10;

    @FXML
    private JFXRadioButton q55;

    @FXML
    private JFXRadioButton q45;

    @FXML
    private JFXRadioButton q44;

    @FXML
    private JFXRadioButton q43;

    @FXML
    private JFXRadioButton q35;

    @FXML
    private JFXRadioButton q34;

    @FXML
    private JFXRadioButton q33;

    @FXML
    private JFXRadioButton q25;

    @FXML
    private JFXRadioButton q24;

    @FXML
    private JFXRadioButton q23;

    @FXML
    private JFXRadioButton q12;

    @FXML
    private JFXRadioButton q11;

    @FXML
    private JFXRadioButton q15;

    @FXML
    private JFXRadioButton q14;

    @FXML
    private JFXRadioButton q13;

    @FXML
    private JFXRadioButton q42;

    @FXML
    private JFXRadioButton q32;

    @FXML
    private JFXRadioButton q22;

    @FXML
    private JFXRadioButton q41;

    @FXML
    private JFXRadioButton q31;
 
    @FXML
    private JFXRadioButton q21;

    @FXML
    private JFXRadioButton q40;

    @FXML
    private JFXRadioButton q30;

    @FXML
    private JFXRadioButton q54;

    @FXML
    private JFXRadioButton q53;

    @FXML
    private JFXRadioButton q52;

    @FXML
    private JFXRadioButton q51;

    @FXML
    private JFXRadioButton q50;

    @FXML
    private JFXRadioButton q20;

    @FXML
    private JFXButton sendButton;

    private int[] score = new int[5];
    private String comment;
    private Course course;
    private User student;

    public void sendFeedback(ActionEvent event) {
        Toggle ans = q1.getSelectedToggle();

        warn.setText("");
        do {
            if (ans == null) {
                warn.setText("Please answer all questions.");
                break;
            } else if (ans.equals(q10)) {
                score[0] = 0;
            } else if (ans.equals(q11)) {
                score[0] = 1;
            } else if (ans.equals(q12)) {
                score[0] = 2;
            } else if (ans.equals(q13)) {
                score[0] = 3;
            } else if (ans.equals(q14)) {
                score[0] = 4;
            } else {
                score[0] = 5;
            }
            ans = q2.getSelectedToggle();
            if (ans == null) {
                warn.setText("Please answer all questions.");
                break;
            } else if (ans.equals(q20)) {
                score[1] = 0;
            } else if (ans.equals(q21)) {
                score[1] = 1;
            } else if (ans.equals(q22)) {
                score[1] = 2;
            } else if (ans.equals(q23)) {
                score[1] = 3;
            } else if (ans.equals(q24)) {
                score[1] = 4;
            } else {
                score[1] = 5;
            }
            ans = q3.getSelectedToggle();
            if (ans == null) {
                warn.setText("Please answer all questions.");
                break;
            } else if (ans.equals(q30)) {
                score[2] = 0;
            } else if (ans.equals(q31)) {
                score[2] = 1;
            } else if (ans.equals(q32)) {
                score[2] = 2;
            } else if (ans.equals(q33)) {
                score[2] = 3;
            } else if (ans.equals(q34)) {
                score[2] = 4;
            } else {
                score[2] = 5;
            }
            ans = q4.getSelectedToggle();
            if (ans == null) {
                warn.setText("Please answer all questions.");
                break;
            } else if (ans.equals(q40)) {
                score[3] = 0;
            } else if (ans.equals(q41)) {
                score[3] = 1;
            } else if (ans.equals(q42)) {
                score[3] = 2;
            } else if (ans.equals(q43)) {
                score[3] = 3;
            } else if (ans.equals(q44)) {
                score[3] = 4;
            } else {
                score[3] = 5;
            }
            ans = q5.getSelectedToggle();
            if (ans == null) {
                warn.setText("Please answer all questions.");
                break;
            } else if (ans.equals(q50)) {
                score[4] = 0;
            } else if (ans.equals(q51)) {
                score[4] = 1;
            } else if (ans.equals(q52)) {
                score[4] = 2;
            } else if (ans.equals(q53)) {
                score[4] = 3;
            } else if (ans.equals(q54)) {
                score[4] = 4;
            } else {
                score[4] = 5;
            }
            comment = feedback.getText();
            DBConnector conn = new DBConnector();
            super.setPreparedCommand("INSERT INTO feedback (userid,courseid,section,q1,q2,q3,q4,q5,comment) VALUES (?,?,?,?,?,?,?,?,?)");
            super.addBindValue(student.getUserID());
            super.addBindValue(course.getCourseID());
            super.addBindValue(course.getSection());
            for(int n : score) super.addBindValue(n);
            super.addBindValue(comment);
            try {
                conn.excuteUpdate(this);
            } catch (SQLException e) {
                System.err.println(e.getMessage());
                break;
            }
            super.clearQuery();
            super.setPreparedCommand("UPDATE courseinfo SET sentfeedback=? WHERE courseid=? AND section=?");
            String temp = "";
            for(int id : course.getSentFeedback()) {
                temp += (id+",");
            }
            temp += student.getUserID()+"";
            super.addBindValue(temp);
            super.addBindValue(course.getCourseID());
            super.addBindValue(course.getSection());
            try {
                conn.excuteUpdate(this);
            } catch (SQLException e) {
                System.err.println(e.getMessage());
                break;
            }
            finally {
                conn.close();
                try {
                    Sender.getInstance().send(new StudentModel(student.getUserID()),"UPDATE STUDENT DATA");
                } catch (SQLException | ClassNotFoundException e) {
                    System.err.println(e.getMessage());
                }
                Sender.getInstance().send(conn, temp);
            }
            Stage feedbackStage = (Stage) sendButton.getScene().getWindow();
            feedbackStage.close();
        } while (false);
    }

    public void initialize() {
        warn.setText("Loading...");
        Sender.getInstance().addObserver(this);
    }
    
    @Override
    public void update(Observable subject, Object msg) {
        if (msg instanceof SendPackage) {
            SendPackage pack = (SendPackage) msg;
            if (pack.getMessage().equals("OPEN COURSE FEEDBACK")) {
                if(pack.getObject() instanceof FeedbackModel) {
                    course = ((FeedbackModel) pack.getObject()).getCourse();
                    student = ((FeedbackModel) pack.getObject()).getStudent();
                    sendButton.setDisable(false);
                    warn.setText("");
                }                
            }
        }
    }

}
