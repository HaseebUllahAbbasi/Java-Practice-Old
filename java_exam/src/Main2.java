import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Main2 {

    private JFrame frame;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Main2 window = new Main2();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Main2() {
        initialize();
    }

    public void initialize() {
        frame = new JFrame();
        frame.setBackground(new Color(223, 152, 136));
        frame.setBounds(50, 20, 1500, 400);
        frame.setTitle("Course Catalog");
        JPanel addNewCourse = new JPanel();
        addNewCourse.setLayout(new FlowLayout());
        JLabel label1 = new JLabel("Course Title");
        JTextField title = new JTextField(30);
        JLabel label2 = new JLabel("Course ID");
        JTextField id = new JTextField(30);
        JLabel label3 = new JLabel("Course Discription");
        JTextArea text = new JTextArea(10, 20);
        JButton btn = new JButton("add course");

        addNewCourse.add(label1);
        addNewCourse.add(title);
        addNewCourse.add(label2);
        addNewCourse.add(id);
        addNewCourse.add(label3);
        addNewCourse.add(text);
        addNewCourse.add(btn);

        JPanel searchCourse = new JPanel();
        JLabel enter = new JLabel("Enter Course ID");
        JTextField id2 = new JTextField(30);
        JButton search = new JButton("search course");

        searchCourse.add(enter);
        searchCourse.add(id2);
        searchCourse.add(search);

        JPanel listAllcourses = new JPanel();
        JLabel courses = new JLabel("All Courses");
        JTable table = new JTable(5, 10);
        listAllcourses.add(courses);
        listAllcourses.add(table);

        frame.setLayout(new FlowLayout());

        frame.add(addNewCourse);
        frame.add(searchCourse);
        frame.add(listAllcourses);
    }

}