package qudoos_2;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI implements ActionListener {		//public class that implements actionlistener, which are just actions that are performed when buttons are pressed for example
	
	JLabel label;		//define new global JLabel
	JFrame frame;		//define new global JFrame
	JPanel panel;		//define new global JPanel

	public GUI() {
	JFrame frame = new JFrame();		//new 'window' basically 
	JPanel panel = new JPanel (new GridBagLayout());		//panel that you can add stuff into e.g. like buttons and labels
	JTextField LoginText = new JTextField (20); //adds a text field for login 
	JTextField SignUpText = new JTextField(20);
	
	}



public void actionPerformed(ActionEvent e) {
}
}




