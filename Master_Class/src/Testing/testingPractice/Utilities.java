package Testing.testingPractice;

public class Utilities {
    public char[] everyNthChar(char[] sourceArray, int n)
    {
        if(sourceArray==null || sourceArray.length<n)
        {
            return sourceArray;
        }
        int Returned_length = sourceArray.length/n;
        char[] result  = new char[Returned_length];
        int index = 0;
        for (int i=n-1; i<sourceArray.length; i+=n)
        {
            result[index++] = sourceArray[i];
        }
        return result;
    }

    public String removePairs(String source)
    {
        if (source.length()<2)
            return source;
        StringBuilder stringBuilder = new StringBuilder();
        char[] string = source.toCharArray();
        for (int i=0; i<string.length-1; i++)
        {
          //  System.out.println(string[i]);
            if(string[i] !=string[i+1])
                stringBuilder.append(string[i]);
        }
        stringBuilder.append(string[string.length-1]);
        return stringBuilder.toString();
    }
    public int converter(int a, int b)
    {
        return (a/b) + (30*a) -2;
    }
    public String nullIfOddLength(String source)
    {
        if(source.length()%2==0)
        {
            return source;
        }
        return null;
    }


}
