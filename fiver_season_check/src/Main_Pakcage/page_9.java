package Main_Pakcage;

import javafx.event.ActionEvent;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class page_9
{
    public void print_screen(ActionEvent actionEvent) throws AWTException, IOException
    {
        Robot robot = new Robot();
        Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        BufferedImage capture = robot.createScreenCapture(screenRect);
        File outputfile = new File("saved.png");
        ImageIO.write(capture, "png", outputfile);


        PDDocument document = new PDDocument();
        PDPage blankPage = new PDPage();
        document.addPage(blankPage);
        document.save("C:/Users/PeaceSeeker/Documents/IdeaProjects/fiver_season_check/output.pdf");
        document.close();


        File file = new File("C:/Users/PeaceSeeker/Documents/IdeaProjects/fiver_season_check/output.pdf");
        PDDocument doc = PDDocument.load(file);

        //Retrieving the page
        PDPage page = doc.getPage(0);

        //Creating PDImageXObject object
        PDImageXObject pdImage = PDImageXObject.createFromFile("C:/Users/PeaceSeeker/Documents/IdeaProjects/fiver_season_check/saved.png",doc);

        //creating the PDPageContentStream object
        PDPageContentStream contents = new PDPageContentStream(doc, page);

        //Drawing the image in the PDF document
        contents.drawImage(pdImage, 0, 0);

        System.out.println("Image inserted");

        //Closing the PDPageContentStream object
        contents.close();

        //Saving the document
        doc.save("C:/Users/PeaceSeeker/Documents/IdeaProjects/fiver_season_check/output.pdf");

        //Closing the document
        doc.close();


    }
}
