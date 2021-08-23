import java.util.Scanner;

public class PalindromeIntegers_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        while (!command.equals("END")) {
            String reversed = ReverseInteger(command);
            if (command.equals(reversed)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
            command = scanner.nextLine();
        }

    }


    private static String ReverseInteger(String integer) {
        StringBuilder rev = new StringBuilder(integer);
        rev.reverse();
        return rev.toString();
    }
}