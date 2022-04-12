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
     * Complete the 'getFinalOrder' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY amount
     */

    public static List<Integer> getFinalOrder(int k, List<Integer> amount)
    {
        List array  = new ArrayList ();
        Queue queue = new ArrayDeque();
        int counter = 0 ;
        int total = 0;
        for(int number: amount)
        {
            queue.add(counter);
            counter++;
            total+=number;
        }
        counter = 0;
        while(queue.size()!=0)
        {
            if((total-amount.get(counter))<=k)
            {
                total = total-amount.get(counter);


                amount.remove(new Integer(counter));

                array.add(queue.peek());
            }
            else{
                total = total- k;
                counter = counter+1;
                 queue.remove(new Integer(counter) );
                queue.add(new Integer(counter) );
            }
        }

        return array;

    }

}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        int amountCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> amount = IntStream.range(0, amountCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.getFinalOrder(k, amount);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}