package CombinatorialProblems_02;

import java.util.Scanner;

public class CombinationsWithRepetition_06 {
    public static String[] elements;
    public static String[] variations;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        elements = scanner.nextLine().split(" ");
        variations = new String[Integer.parseInt(scanner.nextLine())];

        combinations(0, 0);
    }

    private static void combinations(int index, int start) {
        if(index == variations.length){
            print(variations);
        } else{
            for (int i = start; i < elements.length; i++) {
                variations[index] = elements[i];
                combinations(index+1,i);
            }
        }
    }
    private static void print(String[] elements) {
        System.out.println(String.join(" ", elements));
    }
}
