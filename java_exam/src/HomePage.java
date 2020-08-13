import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Window.Type;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class HomePage {

    private JFrame frame;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    HomePage window = new HomePage();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public HomePage() {
        initialize();
    }

    public void initialize()
    {
        frame = new JFrame();
        frame.setBackground(new Color(223, 152, 136));
        frame.setType(Type.POPUP);
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
        btn.addActionListener((e)
                -> {
            try {
                Connection con = DriverManager.getConnection("jdbc:ucanaccess://Courses.accdb");
                String sql = "Select * from course";
                PreparedStatement ps = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

                ResultSet rs = ps.executeQuery();

                rs.moveToInsertRow();
                rs.updateString("id", id.getText());
                rs.updateString("name", title.getText());
                rs.updateString("discription", text.getName());
                JOptionPane.showMessageDialog(null, "Thanks..");
                rs.insertRow();
                con.close();
                ps.close();
                HomePage h = new HomePage();
                frame.dispose();
            } catch (Exception d) {
                JOptionPane.showMessageDialog(null, d);
            }
        });

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