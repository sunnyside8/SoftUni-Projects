import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class CountUppercaseWords_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] strings = scanner.nextLine().split("\\s+");

        Predicate<String> predicate = str-> Character.isUpperCase(str.charAt(0));

        List<String> upperCase = Arrays.stream(strings)
                .filter(predicate)
                .collect(Collectors.toList());
        System.out.println(upperCase.size());
        System.out.println(String.join(System.lineSeparator(),upperCase));
    }
}
