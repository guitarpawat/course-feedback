package coursefeedback.gui;

import com.jfoenix.controls.JFXButton;
import java.util.Observable;
import java.util.Observer; 
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;


/**
 * Controller for Result of Feedback with user interface.
 * 
 * @author Noppawan Kulchol
 * @author Pawat Nakpiphatkul
 *
 */
public class ResultController implements Observer {

    @FXML
    private Label nameTeacher;

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

    /**
     * @see java.util.Observer#update(Observable, Object)
     */
    @Override
    public void update(Observable subject, Object msg) {
    }

}
