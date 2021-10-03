import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindtheSmallestElement_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Consumer<List<Integer>> printIndexOfMinEl = lis ->{
            int min = Collections.min(lis);
            System.out.println(lis.lastIndexOf(min));
        };

        //2
//        Function<List<Integer>,Integer> getIndexOfMIn = list->
//                list.lastIndexOf(Collections.min(list));
//        System.out.println(getIndexOfMIn.apply(numbers));

        printIndexOfMinEl.accept(numbers);
    }
}
