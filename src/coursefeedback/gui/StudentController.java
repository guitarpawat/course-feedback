package coursefeedback.gui;

import coursefeedback.data.Course;
import coursefeedback.data.StudentModel;
import coursefeedback.data.User;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class StudentController implements Observer {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label id1;

    @FXML
    private Label course1;

    @FXML
    private Label feedback1;

    @FXML
    private Label welcomeStudent;

    @FXML
    private Label nameStudent;

    private Course[] courses;
    private StudentModel model;

    @FXML
    public void initialize() {
        nameStudent.setText("Loading...");
        Sender.getInstance().addObserver(this);
    }

    @Override
    public void update(Observable subject, Object msg) {
        if (subject instanceof Sender) {
            if (msg instanceof StudentModel) {
                model = (StudentModel) msg;
                courses = model.getCourses();
                id1.setText(courses[0].getCourseID());
                course1.setText(courses[0].getCourseName());
                nameStudent.setText(model.getStudent().getFirstName() + " " + model.getStudent().getLastName());
            }
        }
    }

}
