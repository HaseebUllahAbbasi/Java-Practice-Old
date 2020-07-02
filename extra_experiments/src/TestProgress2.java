import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import javax.swing.*;

@SuppressWarnings("serial")
public class TestProgress2 extends JPanel {
    private JProgressBar progressBar = new JProgressBar(0, 100);
    private Action startBackgroundTaskAction = new StartBackgroundTaskAction();

    public TestProgress2() {
        progressBar.setStringPainted(true);
        add(progressBar);
        add(new JButton(startBackgroundTaskAction));
    }

    public void setActionEnabled(boolean enabled) {
        startBackgroundTaskAction.setEnabled(enabled);
    }

    private class StartBackgroundTaskAction extends AbstractAction {
        public StartBackgroundTaskAction() {
            super("Start Background Task");
            putValue(MNEMONIC_KEY, KeyEvent.VK_S);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            progressBar.setString(null);
            progressBar.setValue(0);
            setActionEnabled(false);
            MyTask myTask = new MyTask();
            myTask.addPropertyChangeListener(new MyTaskListener());
            myTask.execute();
        }
    }

    private class MyTaskListener implements PropertyChangeListener {
        @Override
        public void propertyChange(PropertyChangeEvent pcEvt) {
            MyTask myTask = (MyTask) pcEvt.getSource();
            if ("progress".equals(pcEvt.getPropertyName())) {
                int progress = myTask.getProgress();
                progressBar.setValue(progress);
            }
            if (pcEvt.getNewValue() == SwingWorker.StateValue.DONE) {
                setActionEnabled(true);
                progressBar.setString("Done");
                try {
                    myTask.get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private class MyTask extends SwingWorker<Void, Void> {
        @Override
        protected Void doInBackground() throws Exception {
            Random random = new Random();
            int progress = 0;
            setProgress(0);
            while (progress < 100) {
                try {
                    Thread.sleep(random.nextInt(1000));
                } catch (InterruptedException ignore) {}
                progress += random.nextInt(10);
                setProgress(Math.min(progress, 100));
            }
            return null;
        }
    }

    private static void createAndShowGui() {
        TestProgress2 mainPanel = new TestProgress2();

        JFrame frame = new JFrame("TestProgress2");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }
}