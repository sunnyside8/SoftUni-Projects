import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CustomMinFunction_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Integer>numbers = Arrays.stream(input.split("\\s+"))
                .map(Integer::parseInt).toList();

//        Function<int[],String> getMinNUmber = array->
//                String.valueOf(Arrays.stream(array).min().orElse(0));
//        System.out.println(getMinNUmber.apply(numbers));
        Consumer<List<Integer>> printMin = list-> System.out.println(Collections.min(list));
        printMin.accept(numbers);
    }
}
