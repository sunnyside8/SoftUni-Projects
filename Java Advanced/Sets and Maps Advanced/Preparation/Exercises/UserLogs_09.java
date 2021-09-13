package Preparation;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UserLogs_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        TreeMap<String, LinkedHashMap<String,Integer>> data = new TreeMap<>();
        while(!line.equals("end")){
            String[] tokens = line.split("\\s+");
            String user = getUser(tokens[2]);
            String IP = getIP(tokens[0]);
            data.putIfAbsent(user,new LinkedHashMap<>());
            LinkedHashMap<String,Integer> innerMap = data.get(user);
            innerMap.putIfAbsent(IP,0);
            int count = innerMap.get(IP)+1;
            innerMap.put(IP,count);
            data.put(user,innerMap);
            line = scanner.nextLine();
        }
        for (Map.Entry<String, LinkedHashMap<String, Integer>> entry : data.entrySet()) {
            LinkedHashMap<String,Integer> innerMap = entry.getValue();
            System.out.println(entry.getKey() + ":");
            int count  = 0 ;
            for (var subEntry : innerMap.entrySet()) {
                System.out.printf("%s => %d",subEntry.getKey(),subEntry.getValue());
                if (count++ != innerMap.size()-1){
                    System.out.print(", ");
                } else{
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }

    private static String getIP(String token) {
        return token.substring(3);
    }

    private static String getUser(String token) {
        return token.substring(5);
    }
}
