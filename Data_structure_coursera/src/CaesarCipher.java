public class CaesarCipher
{
    String encrypt(String input,int key)
    {
        StringBuilder encrypted = new StringBuilder(input.toUpperCase());
        String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shifted = alpha.substring(key)+alpha.substring(0,key);

        for (int i=0; i<encrypted.length(); i++)
        {
            char currChar = encrypted.charAt(i);
            int idx = alpha.indexOf(currChar);

            if(idx!=-1)
            {
                char newChar = shifted.charAt(idx);
                encrypted.setCharAt(i,newChar);
            }
        }
        return encrypted.toString();
    }
    String encrypt(String input,int key1,int key2)
    {
        StringBuilder encrypted = new StringBuilder(input.toUpperCase());
        String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String shifted_1 = alpha.substring(key1)+alpha.substring(0,key1);
        String shifted_2 = alpha.substring(key2)+alpha.substring(0,key2);

        for (int i=0; i<encrypted.length(); i++)
        {
            char currChar = encrypted.charAt(i);
            int idx = alpha.indexOf(currChar);

            if(idx!=-1)
            {
                if(i%2==0)
                {
                    char newChar = shifted_1.charAt(idx);
                    encrypted.setCharAt(i,newChar);
                }
                else
                    {
                    char newChar = shifted_2.charAt(idx);
                    encrypted.setCharAt(i,newChar);
                }
            }
        }
        return encrypted.toString();
    }

    public static void main(String[] args) {
        System.out.println(new CaesarCipher().encrypt("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!" ,8,21));
    }
}

