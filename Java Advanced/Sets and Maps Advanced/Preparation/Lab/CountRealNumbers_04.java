package Preparation;

import java.util.*;

public class CountRealNumbers_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] line = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();
        LinkedHashMap<Double,Integer> count = new LinkedHashMap<>();
        for (Double s : line) {
            count.putIfAbsent(s,0);
            count.put(s,count.get(s) +1);
        }
        for (Map.Entry<Double, Integer> entry : count.entrySet()) {
            System.out.printf("%.1f -> %d%n",entry.getKey(),entry.getValue());
        }
    }
}
