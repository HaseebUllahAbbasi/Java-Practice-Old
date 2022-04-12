import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main
{
    public static void main(String[] args) {
        List<Integer> number = Arrays.asList(2, 1, 10, 20, 22, 3, 4, 5);

        List<Integer> square = number.stream().map((x) -> {
            return x * x;
        }).collect(Collectors.toList());
        List<Integer> even = number.stream().filter((x) -> x % 2 == 0).collect(Collectors.toList());

        System.out.println(Arrays.toString(even.toArray()));

        List<String> names =
                Arrays.asList("Reflection", "Collection", "Election", "Stream");
        List<String> show =
                names.stream().sorted().collect(Collectors.toList());
        System.out.println(show);

        Set<Integer> squareSet =
                number.stream().map(x -> x * x).collect(Collectors.toSet());
        System.out.println(squareSet);


        number.stream().map(x -> x * x).forEach(y -> System.out.println(y));
        List<Integer> collect = number.stream().sorted(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2)
                    return 1;
                else if (o2 > o1)
                    return -1;
                else
                    return 0;
            }
        }).collect(Collectors.toList());
        System.out.println(collect);

    }


}
