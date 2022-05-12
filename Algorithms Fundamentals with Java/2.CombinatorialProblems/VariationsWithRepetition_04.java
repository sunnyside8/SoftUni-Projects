package CombinatorialProblems_02;

import java.util.Scanner;

public class VariationsWithRepetition_04 {
    public static String[] elements;
    public static String[] variations;
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        elements = scanner.nextLine().split(" ");
        variations = new String[Integer.parseInt(scanner.nextLine())];

        variationsWithRep(0);
    }

    private static void variationsWithRep(int index) {
        if(index == variations.length){
            print(variations);
        } else{
            for (int i = 0; i < elements.length; i++) {
                variations[index] = elements[i];
                variationsWithRep(index+1);
            }
        }
    }



    private static void print(String[] elements) {
        System.out.println(String.join(" ", elements));
    }
}
