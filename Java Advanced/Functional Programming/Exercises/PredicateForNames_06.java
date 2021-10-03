import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateForNames_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Predicate<String> validLength = name->name.length() <= n;

        String [] names = scanner.nextLine().split("\\s+");
        Arrays.stream(names).filter(validLength).forEach(System.out::println);
    }
}
