package Preparation;

import java.awt.image.TileObserver;
import java.util.*;

public class LegendaryFarming_12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String,Integer> fms = new TreeMap<>();
        fms.put("fragments",0);
        fms.put("shards",0);
        fms.put("motes",0);
        Map<String,Integer> junk = new TreeMap<>();
        String obtainedType = "";
        boolean obtained = false;
        while(true){
            String[] tokens = scanner.nextLine().split("\\s+");
            for (int i = 0; i < tokens.length; i += 2) {
                String type = tokens[i+1].toLowerCase();
                int quantity = Integer.parseInt(tokens[i]);
                if (chekType(type)){
                    int total = fms.get(type) + quantity;
                    if(total >= 250){
                        obtainedType = type;
                        obtained = true;
                        total -= 250;
                    }
                    fms.put(type,total);
                } else{
                    junk.putIfAbsent(type,0);
                    junk.put(type,junk.get(type) + quantity);
                }
                if(obtained){
                    break;
                }
            }
            if(obtained){
                break;
            }
        }
        printObtained(obtainedType);
        fms.entrySet().stream()
                .sorted((e1,e2) -> Integer.compare(e2.getValue(),e1.getValue()))
                .forEach(entry->{
                    System.out.printf("%s: %d%n",entry.getKey(),entry.getValue());
                });
        for (var entry : junk.entrySet()) {
            System.out.printf("%s: %d%n",entry.getKey(),entry.getValue());
        }

    }

    private static void printObtained(String obtainedType) {
        if(obtainedType.equals("shards")){
            System.out.println("Shadowmourne obtained!");
        } else if (obtainedType.equals("fragments")){
            System.out.println("Valanyr obtained!");
        } else if (obtainedType.equals("motes")){
            System.out.println("Dragonwrath obtained!");
        }
    }

    private static boolean chekType(String type) {
        return type.equals("fragments") || type.equals("shards") || type.equals("motes");
    }
}
