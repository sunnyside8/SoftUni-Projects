package RecursionAndCombinatorialProblems_3;

import java.util.Scanner;

public class CombinationsWithoutRepetition_5 {
    public static int n;
    public static int[] arr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = Integer.parseInt(scanner.nextLine());
        int k = Integer.parseInt(scanner.nextLine());

        arr = new int[k];

        combine(0, 1);
    }

    private static void combine(int index, int start) {
        if (index == arr.length) {
            printArr();
        } else {
            for (int i = start; i <= n; i++) {
                arr[index] = i;
                combine(index+1,i+1);
            }
        }
    }

    private static void printArr() {
        for (int number : arr) {
            System.out.print(number + " ");
        }
        System.out.println();
    }
}

