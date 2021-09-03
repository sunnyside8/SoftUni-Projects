package Preparation;

import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinaryConverter_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int binary = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> decimal = new ArrayDeque<>();
        if (binary == 0) {
            System.out.println(0);
        } else {
            while (binary != 0) {
                int integer = binary % 2;
                decimal.push(integer);
                binary = binary / 2;
            }
        }

        while (!decimal.isEmpty()) {
            System.out.print(decimal.pop());
        }
    }
}
