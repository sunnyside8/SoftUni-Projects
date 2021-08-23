import java.util.Scanner;

public class TopNumber_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String number = String.valueOf(i);
            boolean isItDivisible = Divisible(number);
            boolean containsOdd = Contains(number);
            if (isItDivisible && containsOdd) {
                System.out.println(i);
            }
        }
    }

    private static boolean Contains(String number) {
        for (char digit : number.toCharArray()) {
            int current = Integer.parseInt(String.valueOf(digit));
            if (current % 2 == 1) {
                return true;
            }
        }
        return false;
    }

    private static boolean Divisible(String number) {
        int sum = 0;
        for (char digit : number.toCharArray()) {
            int current = Integer.parseInt(String.valueOf(digit));
            sum += current;
        }
        return sum % 8 == 0;
    }
}