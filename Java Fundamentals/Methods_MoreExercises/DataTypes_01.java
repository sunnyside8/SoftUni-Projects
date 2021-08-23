import java.util.Scanner;

public class DataTypes_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String type = scanner.nextLine();
        String input = scanner.nextLine();
        switch (type){
            case "int":
                intOperations(input);
                break;
            case "real":
                doubleOperations(input);
                break;
            case "string":
                stringOperations(input);
                break;
        }
    }

    private static void stringOperations(String input) {
        System.out.printf("$%s$", input);
    }

    private static void doubleOperations(String input) {
        double number = Double.parseDouble(input);
        number*=1.5;
        System.out.printf("%.2f", number);
    }

    private static void intOperations(String input) {
        int number = Integer.parseInt(input);
        number *= 2;
        input = String.valueOf(number);
        System.out.println(input);
    }
}
