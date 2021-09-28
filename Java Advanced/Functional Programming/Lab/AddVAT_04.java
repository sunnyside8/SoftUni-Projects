import java.util.Arrays;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class AddVAT_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        UnaryOperator<Double> vatCalculator = val -> val*1.2;

        System.out.println("Prices with VAT:");

        Arrays.stream(scanner.nextLine().split(", "))
                .map(Double::parseDouble)
                .map(vatCalculator)
                .forEach(vatPrice -> System.out.printf("%.2f%n",vatPrice));

    }
}

