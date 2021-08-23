import java.util.Scanner;

public class CharactersInRange_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int start = scanner.nextLine().charAt(0);
        int finish  = scanner.nextLine().charAt(0);
        PrintingInBetween(Math.min(start,finish),Math.max(start,finish));

    }

    private static void PrintingInBetween(int start, int finish) {
        for (int i = start +1; i < finish; i++) {
            System.out.print((char)i + " ");
        }
    }
}