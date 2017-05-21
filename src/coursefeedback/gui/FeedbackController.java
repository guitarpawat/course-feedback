package coursefeedback.gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;

public class FeedbackController {
    
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
        } while (false);
    }

}
