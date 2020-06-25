import java.awt.*;
import javax.swing.*;
public class panel {
    panel()
    {
        JFrame frame= new JFrame("Panel");
        JPanel panel=new JPanel();
        panel.setBounds(40,80,200,200);
        panel.setBackground(Color.CYAN);
        JButton button_a=new JButton("Button A");
        button_a.setBounds(20,100,40,40);
        button_a.setBackground(Color.red);
        JButton button_b=new JButton("Button B");
        button_b.setBounds(800,100,40,40);
        button_b.setBackground(Color.PINK);
        panel.add(button_a); panel.add(button_b);
        frame.add(panel);
        frame.setSize(400,400);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    public static void main(String args[])
    {
        new panel();
    }
}