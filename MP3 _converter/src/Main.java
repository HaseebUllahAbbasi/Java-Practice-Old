import it.sauronsoftware.jave.EncoderException;
import javax.swing.*;
import java.io.File;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Main
{
    public static void main(String[] args) throws EncoderException {
        App app = new App();
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Video mp4 files", "mp4");
        fileChooser.addChoosableFileFilter(filter);
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION)
        {
            File file = new File(fileChooser.getSelectedFile().getPath());
            try
            {
                app.Convert_To_Audio(file);
            }
            catch (Exception e)
            {
                System.out.println("Error Occured");
            }
        }
    }
}
