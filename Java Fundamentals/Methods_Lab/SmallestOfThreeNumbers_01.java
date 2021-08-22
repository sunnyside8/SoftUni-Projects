import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class SmallestOfThreeNumbers_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());
        int min = FindMin(a,b,c);
        System.out.println(min);
    }

    private static int FindMin(int a, int b, int c) {
        return Collections.min(Arrays.asList(a,b,c));
    }
}
