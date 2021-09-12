package Preparation;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char [] symbols = scanner.nextLine().toCharArray();
        TreeMap<Character,Integer> occurrences = new TreeMap<>();
        for (char s : symbols) {
            occurrences.putIfAbsent(s,0);
            occurrences.put(s,occurrences.get(s) +1);
        }
        for (var entry : occurrences.entrySet()) {
            System.out.printf("%c: %d time/s%n",entry.getKey(),entry.getValue());
        }
    }
}
