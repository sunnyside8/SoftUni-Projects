package Preparation;

import java.util.*;

public class BasicStackOperations_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int x = scanner.nextInt();
        ArrayDeque<Integer> numbers = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            numbers.push(scanner.nextInt());
        }
        for (int i = 0; i < s; i++) {
            numbers.pop();
        }
        if (numbers.contains(x)){
            System.out.println("true");
        } else if (numbers.isEmpty()){
            System.out.println("0");
        }else {
            System.out.println(Collections.min(numbers));
        }

    }
}
