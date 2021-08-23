import java.util.Locale;
import java.util.Scanner;

public class PasswordValidator_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        boolean first = Length(input);
        boolean second = Consists(input);
        boolean third = twoDigits(input);
        if (first){
            System.out.println("Password must be between 6 and 10 characters");
        }
        if (second){
            System.out.println("Password must consist only of letters and digits");
        }
        if (third){
            System.out.println("Password must have at least 2 digits");
        }

        if (!first&&!second&&!third){
            System.out.println("Password is valid");
        }
    }

    private static boolean twoDigits(String input) {
        int count = 0;
        for (char symbol : input.toCharArray()) {
            if (Character.isDigit(symbol)) {
                count++;
            }
        }
        if (count < 2) {
            return true;
        }
        return false;
    }

    private static boolean Consists(String input) {
        for (char sym : input.toCharArray()) {
            if (!Character.isLetterOrDigit(sym)) {
                return true;
            }
        }
        return false;
    }

    private static boolean Length (String input){
        if (!(input.length() >= 6 && input.length() <= 10)) {
            return true;
        }
        return false;
    }
}