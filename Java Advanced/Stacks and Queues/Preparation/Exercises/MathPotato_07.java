package Preparation;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MathPotato_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] children = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> queue = new ArrayDeque<>();
        for (String child : children)
            queue.offer(child);
        int cycle = 0;
        while (queue.size() > 1) {
            cycle++;
            for (int i = 1; i < n; i++)
                queue.offer(queue.poll());
            if (!isPrime(cycle)) {
                System.out.println("Removed " + queue.poll());
            } else {
                System.out.println("Prime " + queue.peek());
            }
        }
        System.out.println("Last is " + queue.poll());
    }

    private static boolean isPrime(int cycle) {
        if (cycle <= 1)
            return false;
        for (int i = 2; i < cycle; i++)
            if (cycle % i == 0)
                return false;

        return true;
    }
}

