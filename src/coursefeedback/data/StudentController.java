package coursefeedback.data;

import coursefeedback.gui.Feedback;
import coursefeedback.gui.Student;
import java.awt.event.WindowEvent;

/**
 *
 * @author Pawat Nakpiphatkul
 */
public class StudentController {
    
    private Student view;
    private StudentModel model;
    
    public StudentController(Student view,StudentModel model) {
        this.model = model;
        this.view = view;
    }
    
    public void setCourses() {
        //TODO
    }
    
    public void click(Course course) {
        new Feedback(model.getStudent(),course);
        view.dispatchEvent(new WindowEvent(view, WindowEvent.WINDOW_CLOSING));
    }
}
