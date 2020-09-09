package img;

import java.io.*;
public class Main
{
    public static void main(String[] args) throws FileNotFoundException {
        try{
            float parameter[] = {100,200};
            DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("ImageCode")));
            new SPIHT(parameter,4,4,dos).codeImage();
        }
        catch(IOException e){}
        catch(EndCoding g){}
    }
}
