package Preparation;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       String input = scanner.nextLine();
        ArrayDeque <Character> openBrackets = new ArrayDeque<>();
        boolean areBalanced = false;
        for (int i = 0; i < input.length(); i++) {
            char currentBracket = input.charAt(i);
            if (currentBracket == '(' || currentBracket == '{'||
                currentBracket == '['){
                openBrackets.push(currentBracket);
            } else {
                if(openBrackets.isEmpty()){
                    areBalanced = false;
                    break;
                }
                char lastOpenBracket = openBrackets.pop();
                if (lastOpenBracket == '(' && currentBracket == ')'){
                    areBalanced = true;
                } else if (lastOpenBracket == '{' && currentBracket == '}'){
                    areBalanced = true;
                }  else if (lastOpenBracket == '[' && currentBracket == ']'){
                    areBalanced = true;
                } else{
                    areBalanced = false;
                    break;
                }
            }
        }
        if (areBalanced){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}

