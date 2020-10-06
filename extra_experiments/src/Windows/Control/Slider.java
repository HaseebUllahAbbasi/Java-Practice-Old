package Windows.Control;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;

import java.util.Hashtable;

public class Slider
{
    /**
     * Launch the application.
     */

    public static void main(String[] args) {
        // Create and set up a frame window
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("JSlider setting examples");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
        Rectangle rect = defaultScreen.getDefaultConfiguration().getBounds();
        int x = (int) rect.getMaxX() - frame.getWidth();
        int y = (int) rect.getMaxY() - frame.getHeight();;


        // Set the panel to add buttons
        JPanel panel = new JPanel();

        // Different settings on the sliders
        JSlider slider = new JSlider();
        // JSlider slider = new JSlider(JSlider.VERTICAL);
        // JSlider slider = new JSlider(-100, 100, 50);
        // JSlider slider = new JSlider(JSlider.VERTICAL, -100, 100, 50);

        // Set the slider with the DefaultBoundedRangeModel
        //DefaultBoundedRangeModel model = new DefaultBoundedRangeModel(20, 0, 1, 100);
        //JSlider slider = new JSlider(model);

        // Set major or minor ticks for the slider
        slider.setMajorTickSpacing(25);
        slider.setMinorTickSpacing(10);
        slider.setPaintTicks(true);

        // Set the labels to be painted on the slider
        slider.setPaintLabels(true);

        // Add positions label in the slider
        Hashtable position = new Hashtable<Integer, JLabel>();
        position.put(0, new JLabel("0"));
        position.put(25, new JLabel("25"));
        position.put(50, new JLabel("50"));
        position.put(75, new JLabel("75"));
        position.put(100, new JLabel("100"));

        // Set the label to be drawn
        slider.setLabelTable(position);


        slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                int level = ((JSlider)e.getSource()).getValue();


                try {

                    BrightnessManager.setBrightness(level);

                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }

            }
        });

        // Add the slider to the panel
        panel.add(slider);



        // Set the window to be visible as the default to be false
        frame.add(panel);
        frame.pack();

        Dimension d = panel.getSize();
        frame.setLocation(x-d.width-20, y-d.height-80);

        frame.setVisible(true);
    }

}
