package Ships;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Random;

public class Main
{
    public static void main(String[] args)
    {
        for(int i=0; i<8; i++)
        {
            for(int j=0; j<8; j++)
            {
                //System.out.print(""+i+":"+j+"\t\t");
                System.out.println((new Random()).nextInt(7)%5);
                //System.out.println("button_"+i+"_"+j+" = button_structure_1["+i+"]["+j+"].button;");
                //System.out.println("button_structure_1["+i+"]["+j+"].set_button(button_"+i+"_"+j+");");
            }
            System.out.println();
        }

    }
}
