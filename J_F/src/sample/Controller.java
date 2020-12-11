package sample;


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;

public class Controller
{
    Thread thread = new Thread();
    @FXML
    ProgressBar progressBar;
    Thread taskThread = new Thread(new Runnable()
    {
        @Override
        public void run()
        {
            double progress = 0;
            for(int i=0; i<100; i++)
            {


                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                progress += 0.1;
                final double reportedProgress = progress;

                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        progressBar
                                .setProgress(reportedProgress);
                    }
                });
            }
        }
    });

    public void start_thread(ActionEvent actionEvent) throws InterruptedException
    {
        taskThread.run();
        /*
        thread.start();
        for(int i=1; i<=100; i++)
        {
            progressBar.setProgress((double)i/100);
            thread.sleep(10);

        }
        */


    }
}
