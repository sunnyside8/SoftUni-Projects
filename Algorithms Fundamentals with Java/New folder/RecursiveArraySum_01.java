package Recursion_01;

import java.util.Arrays;
import java.util.Scanner;

public class RecursiveArraySum_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] array = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        System.out.println(sum(array,array.length-1));
    }

    private static int sum(int[] array, int i) {
        if(i == 0){
            return array[0];
        }

       return array[i] + sum(array,i-1);
    }

}