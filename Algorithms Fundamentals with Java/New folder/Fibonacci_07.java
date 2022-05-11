package Recursion_01;

import java.util.Scanner;

public class Fibonacci_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        System.out.println(Fibonacci(n));

    }
    private static int Fibonacci(int n) {
        if(n <= 1){
            return 1;
        }
        return Fibonacci(n-1) + Fibonacci(n-2);
    }
}
