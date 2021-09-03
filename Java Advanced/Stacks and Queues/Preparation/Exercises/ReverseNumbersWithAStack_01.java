package Preparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class ReverseNumbersWithAStack_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> numbers = new ArrayDeque<>();
        String input = scanner.nextLine();
        int[] numbs = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i:numbs) {
            numbers.push(i);
        }
        while(!numbers.isEmpty()){
            System.out.print(numbers.pop() + " ");
        }

    }
}
