package Basic_exam.task_1;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'minTime' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY files
     *  2. INTEGER numCores
     *  3. INTEGER limit
     */

    public static long minTime(List<Integer> files, int numCores, int limit)
    {
        int count = 0;
        long sum = 0;
        for(int number : files)
        {
            if(number%numCores==0)
            {
                if(count<limit)
                    sum+=(number/numCores);
            }
            else
                sum+=number;
        }
        return sum;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int filesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> files = IntStream.range(0, filesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int numCores = Integer.parseInt(bufferedReader.readLine().trim());

        int limit = Integer.parseInt(bufferedReader.readLine().trim());

        long result = Result.minTime(files, numCores, limit);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
