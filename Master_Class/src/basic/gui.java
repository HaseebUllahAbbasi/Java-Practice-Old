package basic;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gui
{
    private JButton button1;
    private JButton button2;
    private JPanel gui_panel;
    private JTextArea textArea1;


    public static void main(String[] args)
    {
        JFrame jFrame = new JFrame("App");
        jFrame.setContentPane(new gui().gui_panel);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }
}
