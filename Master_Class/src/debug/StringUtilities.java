package debug;

public class StringUtilities
{
    private StringBuilder stringBuilder = new StringBuilder();
    private int char_Added = 0;
    public void add_characters(StringBuilder stringBuilder, char c)
    {
        stringBuilder.append(c);
        char_Added++;
    }

}
