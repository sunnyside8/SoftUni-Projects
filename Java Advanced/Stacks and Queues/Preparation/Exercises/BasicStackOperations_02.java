package Preparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicStackOperations_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputNSX = scanner.nextLine();
        int[] numbs = Arrays.stream(inputNSX.split(" ")).mapToInt(Integer::parseInt).toArray();
        String [] input = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> numbers = new ArrayDeque<>();
        for (int i = 0; i < numbs[0]; i++) {
            numbers.push(Integer.parseInt(input[i]));
        }
        for (int i = 0; i < numbs[1]; i++) {
            numbers.pop();
        }
        if (numbers.contains(numbs[2])){
            System.out.println("true");
        } else if (numbers.isEmpty()){
            System.out.println("0");
        }else {
            int min = Integer.MAX_VALUE;
            for (int n:numbers) {
                if (n < min){
                    min = n;
                }
            }
            System.out.println(min);
        }

    }
}
