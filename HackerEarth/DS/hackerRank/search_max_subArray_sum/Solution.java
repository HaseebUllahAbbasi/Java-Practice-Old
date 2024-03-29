package hackerRank.search_max_subArray_sum;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution
{

    // Complete the maximumSum function below.
    static long maximumSum(long[] a, long m)
    {
        long sum = 0;
        for(int i=0; i<a.length; i++)
        {
            long array[] = new long[i+1];
            for(int j=0; j<i+1; j++)
            {
                array[j] = a[i];
            }
            long num =  return_sum(array)%m;
            if(num>sum)
                sum= num;
        }
        return sum;
    }

    private static long return_sum(long[] array)
    {
        long sum = 0;
        for (long num : array)
        {
            sum+=num;
        }
        return sum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nm[0]);

            long m = Long.parseLong(nm[1]);

            long[] a = new long[n];

            String[] aItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                long aItem = Long.parseLong(aItems[i]);
                a[i] = aItem;
            }

            long result = maximumSum(a, m);
            System.out.print(result);
          //  bufferedWriter.write(String.valueOf(result));
            //bufferedWriter.newLine();
        }

        //bufferedWriter.close();

        scanner.close();
    }
}
