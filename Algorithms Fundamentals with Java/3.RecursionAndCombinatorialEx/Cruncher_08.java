package Rec_03;

import java.util.*;
import java.util.stream.Collectors;

public class Cruncher_08 {

    public static List<String> words;
    public static List<String> combined = new ArrayList<>();
    public static String target;

    public static Set<String> out = new TreeSet<>();

    public static Map<Integer, List<String>> table = new HashMap<>();
    public static Map<String, Integer> occurrences = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        words = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        target = scanner.nextLine();

        words.removeIf(next -> !target.contains(next));

        for (String substring : words) {
            occurrences.putIfAbsent(substring,0);
            occurrences.put(substring,(occurrences.get(substring) + 1));
            int index = target.indexOf(substring);

            while (index != -1) {
                table.putIfAbsent(index, new ArrayList<>());
                table.get(index).add(substring);
                index = target.indexOf(substring,index+1);
            }
        }


        permute(0);

        for (String s : out) {
            System.out.println(s);
        }

    }

    private static void permute(int index) {
        if (index == target.length()) {
            print();
        } else if(table.containsKey(index)){
            List<String> strings = table.get(index);
            for (String str : strings) {
                if(occurrences.get(str ) > 0) {
                    occurrences.put(str,occurrences.get(str) -1);
                    combined.add(str);
                    permute(index + str.length());
                    combined.remove(combined.size() - 1);
                    occurrences.put(str,occurrences.get(str) +1);
                }
            }
        }
    }


    private static void print() {
        String actual = String.join("", combined);
        if (actual.contains(target)) {
           out.add(String.join(" ", combined));
        }
    }
}
