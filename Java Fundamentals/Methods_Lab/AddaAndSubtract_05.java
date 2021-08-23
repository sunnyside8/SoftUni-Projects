import java.util.Scanner;

public class AddaAndSubtract_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());
        int sum = Sum(a,b);
        sum = Subtract(sum,c);
        System.out.println(sum);
    }

    private static int Subtract(int sum, int c) {
        return sum - c;
    }

    private static int Sum(int a, int b) {
        return  a+b;
    }
}
