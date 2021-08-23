import java.util.Scanner;

public class CenterPoint_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstOne = Integer.parseInt(scanner.nextLine());
        int firstTwo = Integer.parseInt(scanner.nextLine());
        int secondOne = Integer.parseInt(scanner.nextLine());
        int secondTwo = Integer.parseInt(scanner.nextLine());
        int firstSum = Abs(firstOne,firstTwo);
        int secondSum = Abs(secondOne,secondTwo);
        if (firstSum > secondSum){
            System.out.printf("(%d, %d)",secondOne,secondTwo);
        } else {
            System.out.printf("(%d, %d)",firstOne,firstTwo);
        }
    }

    private static int Abs(int firstOne, int firstTwo) {
       return Math.abs(firstOne + firstTwo);
    }
}
