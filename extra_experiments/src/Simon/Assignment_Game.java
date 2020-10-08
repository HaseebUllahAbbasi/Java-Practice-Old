package Simon;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.LinkedList;

public class Assignment_Game extends JApplet implements MouseListener, Runnable, ActionListener
{
    private static final long serialVersionUID = 1L;
    private boolean boolean_for_suspended = false;
    private int lives_in_numbers = 3;
    private int bestint = 0;
    private boolean correct = false;
    private int numcolors = 0;
    private int numcolors2 = 0;
    private final int RED = 1;
    private final int YELLOW = 2;
    private final int GREEN = 3;
    private final int BLUE = 4;
    private boolean boolean_color_mix = true;
    private LinkedList<Integer> list;
    private Thread th, th2;
    private Object object;
    private boolean isStandalone = false;
    private JPanel jPanel1 = new JPanel();
    private JPanel jPanel2 = new JPanel();
    private GridLayout gridLayout1 = new GridLayout();
    private JButton yellow_button = new JButton();
    private JButton green_button = new JButton();
    private JButton red_button = new JButton();
    private JButton blue_button = new JButton();
    private JButton start_button = new JButton();
   // private JButton about_button = new JButton();
    private JLabel label_right_wrong = new JLabel();
    private JLabel best = new JLabel();
    private JLabel score = new JLabel();
    private JLabel lives = new JLabel();
    private JPanel jPanel3 = new JPanel();
    private GridLayout gridLayout2 = new GridLayout();
    private JLabel life_1 = new JLabel();
    private JLabel life_2 = new JLabel();
    private JLabel life_3 = new JLabel();

    // Get a parameter value
    public String getParameter(String key, String def) {
        return isStandalone ? System.getProperty(key, def) : (getParameter(key) != null ? getParameter(key) : def);
    }

    // Construct the applet
    public Assignment_Game() {
    }

    // Initialize the applet
    public void init() {
        try {
            Component_Init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    String name;
    // Component initialization
    private void Component_Init() throws Exception
    {
        name=JOptionPane.showInputDialog(getAppletInfo(),"Enter Your Name");

        red_button.addActionListener(this);
        yellow_button.addActionListener(this);
        green_button.addActionListener(this);
        blue_button.addActionListener(this);
       // about_button.addActionListener(this);
        start_button.addActionListener(this);

        this.setSize(new Dimension(405, 325));

        jPanel1.setBackground(Color.white);
        jPanel1.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        jPanel1.setOpaque(true);
        jPanel1.setLayout(null);
        jPanel2.setBackground(Color.white);
        jPanel2.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        jPanel2.setDebugGraphicsOptions(0);
        jPanel2.setMaximumSize(new Dimension(32767, 32767));
        jPanel2.setBounds(new Rectangle(124, 77, 161, 132));
        jPanel2.setLayout(gridLayout1);
        gridLayout1.setColumns(2);
        gridLayout1.setHgap(1);
        gridLayout1.setRows(2);
        gridLayout1.setVgap(1);
        red_button.setBackground(new Color(255, 245, 245));
        red_button.setFont(new java.awt.Font("Dialog", 0, 16));
        red_button.setForeground(new Color(203, 0, 0));
        red_button.setFocusPainted(false);
        red_button.setHorizontalTextPosition(SwingConstants.CENTER);
        red_button.setSelected(false);
        red_button.addMouseListener(this);
        yellow_button.setBackground(new Color(255, 255, 245));
        yellow_button.setFont(new java.awt.Font("Dialog", 0, 16));
        yellow_button.setForeground(new Color(203, 203, 0));
        yellow_button.setFocusPainted(false);
        yellow_button.setHorizontalTextPosition(SwingConstants.CENTER);
        yellow_button.setSelected(false);
        yellow_button.addMouseListener(this);
        blue_button.setBackground(new Color(245, 245, 255));
        blue_button.setFont(new java.awt.Font("Dialog", 0, 16));
        blue_button.setForeground(new Color(0, 0, 203));
        blue_button.setFocusPainted(false);
        blue_button.setHorizontalTextPosition(SwingConstants.CENTER);
        blue_button.setSelected(false);
        blue_button.addMouseListener(this);
        green_button.setBackground(new Color(245, 255, 245));
        green_button.setFont(new java.awt.Font("Dialog", 0, 16));
        green_button.setForeground(new Color(0, 203, 0));
        green_button.setFocusPainted(false);
        green_button.setHorizontalTextPosition(SwingConstants.CENTER);
        green_button.setSelected(false);
        green_button.addMouseListener(this);
        start_button.setBounds(new Rectangle(15, 231, 154, 51));
        start_button.setFont(new java.awt.Font("Dialog", 1, 12));
        start_button.setText("START Game");

        /*
        about_button.setBounds(new Rectangle(326, 238, 60, 39));
        about_button.setFont(new java.awt.Font("Dialog", 1, 12));
        about_button.setText("?");
         */

        label_right_wrong.setFont(new java.awt.Font("Dialog", 1, 20));
        label_right_wrong.setHorizontalAlignment(SwingConstants.CENTER);
        label_right_wrong.setText("");
        label_right_wrong.setBounds(new Rectangle(165, 222, 150, 50));
        best.setFont(new java.awt.Font("Dialog", 1, 12));
        best.setRequestFocusEnabled(true);
        best.setHorizontalAlignment(SwingConstants.LEFT);
        best.setText("BEST:   0");
        best.setBounds(new Rectangle(300, 21, 100, 33));
        score.setBounds(new Rectangle(14, 20, 82, 33));
        score.setText("SCORE\t:   0");
        score.setHorizontalAlignment(SwingConstants.LEFT);
        score.setFont(new java.awt.Font("Dialog", 1, 12));
        score.setRequestFocusEnabled(true);
        lives.setRequestFocusEnabled(true);
        lives.setFont(new java.awt.Font("Dialog", 1, 12));
        lives.setHorizontalAlignment(SwingConstants.LEFT);
        lives.setText("LIVES:");
        lives.setBounds(new Rectangle(148, 20, 45, 33));
        jPanel3.setBackground(Color.white);
        jPanel3.setBounds(new Rectangle(197, 31, 40, 11));
        jPanel3.setLayout(gridLayout2);
        gridLayout2.setColumns(3);
        gridLayout2.setHgap(2);
        gridLayout2.setVgap(2);
        life_1.setBackground(Color.GREEN);
        life_1.setBorder(BorderFactory.createLineBorder(Color.black));
        life_1.setOpaque(true);
        life_1.setRequestFocusEnabled(true);
        life_1.setText("");
        life_2.setBackground(Color.GREEN);
        life_2.setBorder(BorderFactory.createLineBorder(Color.black));
        life_2.setOpaque(true);
        life_2.setRequestFocusEnabled(true);
        life_2.setText("");
        life_3.setBackground(Color.GREEN);
        life_3.setBorder(BorderFactory.createLineBorder(Color.black));
        life_3.setOpaque(true);
        life_3.setRequestFocusEnabled(true);
        life_3.setText("");
        this.getContentPane().add(jPanel1, BorderLayout.CENTER);
        jPanel2.add(red_button, null);
        jPanel2.add(yellow_button, null);
        jPanel2.add(green_button, null);
        jPanel2.add(blue_button, null);
        jPanel1.add(lives, null);
        jPanel1.add(jPanel3, null);
       // jPanel1.add(about_button, null);
        jPanel1.add(best, null);
        jPanel1.add(score, null);
        jPanel1.add(label_right_wrong, null);
        jPanel1.add(start_button, null);
        jPanel1.add(jPanel2, null);
        jPanel3.add(life_1, null);
        jPanel3.add(life_2, null);
        jPanel3.add(life_3, null);
    }

    // Start the applet
    public void start() {
        if (th == null)
            th = new Thread(this);
        th.start();
    }

    // Stop the applet
    public void stop() {
    }

    // Destroy the applet
    public void destroy() {
    }

    // Get Applet information
    public String getAppletInfo() {
        return "Applet Information";
    }

    // Get parameter info
    public String[][] getParameterInfo() {
        return null;
    }

    // Main method
    public static void main(String[] args) {
        Assignment_Game applet = new Assignment_Game();
        applet.isStandalone = true;
        JFrame frame = new JFrame();
        // EXIT_ON_CLOSE == 3
        frame.setDefaultCloseOperation(3);
        frame.setTitle("Simon");
        frame.getContentPane().add(applet, BorderLayout.CENTER);
        applet.init();
        applet.start();
        frame.setSize(405, 325);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation((d.width - frame.getSize().width) / 2, (d.height - frame.getSize().height) / 2);
        frame.setVisible(true);
    }



    public void mouseExited(MouseEvent e)
    {
        object = e.getSource();

        if (object == red_button)
            red_button.setBorder(BorderFactory.createLineBorder(Color.black));
        else if (object == yellow_button)
            yellow_button.setBorder(BorderFactory.createLineBorder(Color.black));
        else if (object == green_button)
            green_button.setBorder(BorderFactory.createLineBorder(Color.black));
        else if (object == blue_button)
            blue_button.setBorder(BorderFactory.createLineBorder(Color.black));
    }

    public void mouseEntered(MouseEvent e)
    {
        object = e.getSource();
        if (object == red_button)
            red_button.setBorder(BorderFactory.createLineBorder(Color.red, 2));
        else if (object == yellow_button)
            yellow_button.setBorder(BorderFactory.createLineBorder(Color.yellow, 2));
        else if (object == green_button)
            green_button.setBorder(BorderFactory.createLineBorder(Color.green, 2));
        else if (object == blue_button)
            blue_button.setBorder(BorderFactory.createLineBorder(Color.blue, 2));
    }
    public void mouseClicked(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}


    public void run() {
        if (Thread.currentThread() == th) {
            int randomcolor;
            int time = 90;

            while (boolean_color_mix) {
                switch ((int) (Math.random() * 4 + 1)) {
                    case 1:
                    case 4:
                        for (int i = 0; i < 40 && boolean_color_mix; i++) {
                            randomcolor = (int) (Math.random() * 4 + 1);

                            if (randomcolor == 1)
                                changeColors(red_button, Color.red, new Color(255, 245, 245), time);
                            else if (randomcolor == 2)
                                changeColors(yellow_button, Color.yellow, new Color(255, 255, 245), time);
                            else if (randomcolor == 3)
                                changeColors(green_button, Color.green, new Color(245, 255, 245), time);
                            else if (randomcolor == 4)
                                changeColors(blue_button, Color.blue, new Color(245, 245, 255), time);
                        }
                        break;
                    case 2:
                        for (int i = 0; i < 30 && boolean_color_mix; i++) {
                            changeColors(red_button, Color.red, new Color(255, 245, 245), time);
                            changeColors(yellow_button, Color.yellow, new Color(255, 255, 245), time);
                            changeColors(blue_button, Color.blue, new Color(245, 245, 255), time);
                            changeColors(green_button, Color.green, new Color(245, 255, 245), time);
                        }
                        break;
                    case 3:
                        for (int i = 0; i < 30 && boolean_color_mix; i++) {
                            changeColors(red_button, Color.red, new Color(255, 245, 245), time);
                            changeColors(green_button, Color.green, new Color(245, 255, 245), time);
                            changeColors(blue_button, Color.blue, new Color(245, 245, 255), time);
                            changeColors(yellow_button, Color.yellow, new Color(255, 255, 245), time);
                        }
                        break;
                }
            }
        } else if (Thread.currentThread() == th2) {
            int temps = 500;
            int randomcolor;

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            while (!boolean_color_mix) {
                randomcolor = (int) (Math.random() * 4 + 1);
                list.add((randomcolor));
                numcolors++;

                correct = false;

                while (!correct && !boolean_color_mix) {
                    for (int i = 0; i < numcolors; i++) {
                        switch (((Integer) list.get(i)).intValue()) {
                            case RED:
                                changeColors(red_button, Color.red, new Color(255, 245, 245), temps);
                                break;
                            case YELLOW:
                                changeColors(yellow_button, Color.yellow, new Color(255, 255, 245), temps);
                                break;
                            case GREEN:
                                changeColors(green_button, Color.green, new Color(245, 255, 245), temps);
                                break;
                            case BLUE:
                                changeColors(blue_button, Color.blue, new Color(245, 245, 255), temps);
                                break;
                        }
                        try {
                            Thread.sleep(300);
                        } catch (InterruptedException e) {
                        }
                    }
                    boolean_for_suspended = true;
                    if (boolean_color_mix)
                        break;
                    label_right_wrong.setText("Guess !");
                    th2.suspend();
                    boolean_for_suspended = false;
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                    }
                    label_right_wrong.setText("");
                    try {
                        th2.sleep(500);
                    } catch (InterruptedException e) {
                    }
                }
            }
        }
    }

    void changeColors(JButton b, Color c1, Color c2, int time) {
        b.setBackground(c1);
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
        }
        b.setBackground(c2);
    }

    public void actionPerformed(ActionEvent e)
    {
        object = e.getSource();
        //if (object == about_button)
          //  LeaderBoard();
        if (object == start_button)
        {
            if (boolean_color_mix)
            {
                boolean_color_mix = !boolean_color_mix;
                list = new LinkedList<Integer>();
                label_right_wrong.setText("");
                start_button.setText("STOP");
                numcolors2 = 0;
                red_button.setBackground(new Color(255, 245, 245));
                yellow_button.setBackground(new Color(255, 255, 245));
                green_button.setBackground(new Color(245, 255, 245));
                blue_button.setBackground(new Color(245, 245, 255));
                th2 = new Thread(this);
                th2.start();
            }
            else
            {
                parameters();
            }
        }

        else if ((object == red_button || object == yellow_button || object == green_button || object == blue_button) && !boolean_color_mix && boolean_for_suspended) {
            label_right_wrong.setText("");
            int i = ((Integer) (list.get(numcolors2))).intValue();

            if ((i == RED && object == red_button) || (i == YELLOW && object == yellow_button) || (i == GREEN && object == green_button)
                    || (i == BLUE && object == blue_button)) {
                numcolors2++;
                if (numcolors2 == numcolors) {
                    label_right_wrong.setText("OK !");
                    score.setText("SCORE\t:   " + numcolors);
                    correct = true;
                    numcolors2 = 0;
                    th2.resume();
                }
            } else {
                if (lives_in_numbers == 3)
                    life_3.setBackground(Color.white);
                else if (lives_in_numbers == 2)
                    life_2.setBackground(Color.white);
                else if (lives_in_numbers == 1)
                    life_1.setBackground(Color.white);
                else
                    parameters();
                if (!boolean_color_mix) {
                    numcolors2 = 0;
                    lives_in_numbers--;
                    label_right_wrong.setText("ooooh !");
                    correct = false;
                    th2.resume();
                }
            }
        }
    }

    void parameters()
    {
        boolean_color_mix = !boolean_color_mix;
        boolean_for_suspended = false;
        label_right_wrong.setText("ENDING");
        lives_in_numbers = 3;
        life_1.setBackground(Color.GREEN);
        life_2.setBackground(Color.GREEN);
        life_3.setBackground(Color.GREEN);
        score.setText("SCORE\t:   0");
        start_button.setText("STARTING !");
        th = new Thread(this);
        if (bestint < numcolors) {
            best.setText("BEST:  " + Integer.toString(numcolors - 1));
            bestint = numcolors;
        }
        numcolors = 0;
        numcolors2 = 0;
        th.start();
    }

    void LeaderBoard() {


        /*
        JOptionPane.showMessageDialog(this,
                "Please Follow the Steps to Score More",
                "About...", JOptionPane.PLAIN_MESSAGE);
        */
    }

}