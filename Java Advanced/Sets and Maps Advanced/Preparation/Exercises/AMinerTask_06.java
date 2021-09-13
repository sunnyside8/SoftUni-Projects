package Preparation;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String type = scanner.nextLine();
        Map<String,Integer> resources = new LinkedHashMap<>();
        while(!type.equals("stop")){
            int quality = Integer.parseInt(scanner.nextLine());
            resources.putIfAbsent(type,0);
            resources.put(type,resources.get(type) + quality);
            type = scanner.nextLine();
        }
        for (var entry : resources.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
