import java.util.Scanner;

public class MiddleCharacters_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int middleIndex = input.length()/2;
        if (input.length()% 2 == 1){
            printMiddleOne(input,middleIndex);
        } else {
            printMiddleTwo(input,middleIndex);
        }
    }

    private static void printMiddleTwo(String input, int middleIndex) {
        System.out.println(input.substring(middleIndex-1,middleIndex+1));
    }

    private static void printMiddleOne(String input,int middle) {
        System.out.println(input.charAt(middle));
    }
}
