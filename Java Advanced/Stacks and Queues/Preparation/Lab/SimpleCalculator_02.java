package Preparation;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleCalculator_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] expression = scanner.nextLine().split("\\s+");

        ArrayDeque<String> stack = new ArrayDeque<>();
        for (int i =  expression.length -1; i >= 0; i--) {
            stack.push(expression[i]);
        }
        while(stack.size() > 1){
            int first = Integer.parseInt(stack.pop());
            String operator = stack.pop();
            int second = Integer.parseInt(stack.pop());
            int result = operator.equals("+")
                    ?first + second
                    : first - second;
            stack.push(String.valueOf(result));
        }
        System.out.println(stack.peek());
    }
}
