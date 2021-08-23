
import java.util.Scanner;

public class FactorialDivision_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double first = Double.parseDouble(scanner.nextLine());
        double second = Double.parseDouble(scanner.nextLine());
        first = CalculateFactorial(first);
        second = CalculateFactorial(second);
        System.out.printf("%.2f",first/second);

    }

    private static double CalculateFactorial(double n) {
        double num = 1;
        for (int i = 2; i <= n; i++) {
            num = i*num;
        }
        return num;
    }
}