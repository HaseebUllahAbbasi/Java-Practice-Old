package Basic_exam.task_2;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'maxCost' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY cost
     *  2. STRING_ARRAY labels
     *  3. INTEGER dailyCount
     */

    public static int maxCost(List<Integer> cost, List<String> labels, int dailyCount)
    {
        int count;
        int max =0 ;
        int sum=0;
        for(int i=0; i<cost.size(); i++)
        {
            count  = 0;
            if(count<dailyCount)
            {
                if(labels.get(i).equals("legal"))
                    count++;
                sum+=cost.get(i);
                System.out.println("count :"+count+"    "+"sum " +sum);
            }
            if(count==dailyCount)
            {
                if(max<sum)
                    max = sum;
                sum = 0;
                count = 0;
            }
        }
        System.out.println(max);
        return max;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int costCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> cost = IntStream.range(0, costCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int labelsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> labels = IntStream.range(0, labelsCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        int dailyCount = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.maxCost(cost, labels, dailyCount);


        bufferedReader.close();
    }
}
