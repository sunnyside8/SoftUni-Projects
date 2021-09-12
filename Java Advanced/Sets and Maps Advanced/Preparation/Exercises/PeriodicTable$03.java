package Preparation;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class PeriodicTable$03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        TreeSet <String> compounds = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split("\\s+");
            compounds.addAll(Arrays.asList(line));
        }
        for (String compound : compounds) {
            System.out.print(compound + " ");
        }
    }
}
