package debug;

public class Main
{
    public static void main(String[] args)
    {
        StringUtilities stringUtilities = new StringUtilities();
        StringBuilder stringBuilder = new StringBuilder();
        while (stringBuilder.length()<10)
        {
            stringUtilities.add_characters(stringBuilder,'a');
        }


    }
}
