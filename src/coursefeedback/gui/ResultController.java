package coursefeedback.gui;

import com.jfoenix.controls.JFXButton;
import coursefeedback.data.ResultModel;
import java.sql.SQLException;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;


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
    private ScrollPane scrolllBar;

    @FXML
    private JFXButton preComment;

    @FXML
    private JFXButton nextComment;

    private ResultModel model;
    private double[] averageScores;
    private List<String> comments;
    private int commentCursor = 0;

    public void initialize() {
        scrolllBar.setContent(comment);
        Sender.getInstance().addObserver(this);
        scrolllBar.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
        comment.setWrapText(true);
        scrolllBar.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
    }

    /**
     * @see java.util.Observer#update(Observable, Object)
     */
    @Override
    public void update(Observable subject, Object msg) {
        if (msg != null) {
            if (msg instanceof SendPackage) {
                SendPackage pack = (SendPackage) msg;
                if (pack.getMessage().equals("GET COURSE RESULT")) {
                    model = (ResultModel) pack.getObject();
                    try {
                        averageScores = model.getAvgScore();
                        if (averageScores[0] != 0) {
                            score1.setText(String.format("%1.2f", averageScores[0]));
                        }
                        if (averageScores[1] != 0) {
                            score2.setText(String.format("%1.2f", averageScores[1]));
                        }
                        if (averageScores[2] != 0) {
                            score3.setText(String.format("%1.2f", averageScores[2]));
                        }
                        if (averageScores[3] != 0) {
                            score4.setText(String.format("%1.2f", averageScores[3]));
                        }
                        if (averageScores[4] != 0) {
                            score5.setText(String.format("%1.2f", averageScores[4]));
                        }
                        comments = model.getComments();
                        firstComment();
                    } catch (SQLException e) {
                        System.err.println(e.getMessage());
                    }
                }
            }
        }
    }

    @FXML
    void backComment(ActionEvent event) {
        if (commentCursor > 0) {
            commentCursor--;
            setCommentText();
        }
    }

    @FXML
    void nextComment(ActionEvent event) {
        if (commentCursor < comments.size() - 1) {
            commentCursor++;
            setCommentText();
        }
    }

    private void firstComment() {
        if (comments.size() != 0) {
            setCommentText();
        }
    }

    private void setCommentText() {
        comment.setText(comments.get(commentCursor));
    }
}
