package lambda;

import javax.swing.*;


public class Button_Listener
{
    public static void main(String[] args)
    {
        JFrame frame=new JFrame("ActionListener java8");

        JButton b=new JButton("Click Here");
        b.setBounds(50,100,80,50);

        b.addActionListener(e -> System.out.println("Hello World!"));
        frame.add(b);

        frame.setSize(200,200);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
