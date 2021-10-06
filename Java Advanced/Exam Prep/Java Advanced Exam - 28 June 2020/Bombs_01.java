import java.util.*;

public class Bombs_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer,String> bombValues = createMap();
        Map<String,Integer> pouch = createPouch();
        String [] bombEffectString = scanner.nextLine().split(",\\s+");
        String [] bombCaringString = scanner.nextLine().split(",\\s+");
        ArrayDeque <Integer> bombEffect = new ArrayDeque<>();
        for (String s : bombEffectString) {
            bombEffect.offer(Integer.parseInt(s));
        }
        ArrayDeque <Integer> bombCaring = new ArrayDeque<>();
        for (String s : bombCaringString) {
            bombCaring.push(Integer.parseInt(s));
        }
        while(bombCaring.size() >= 1 && bombEffect.size() >= 1){
            int effect = bombEffect.peek();
            int caring = bombCaring.pop();
            int sum = effect + caring;
            if(bombValues.containsKey(sum)){
                String type = bombValues.get(sum);
                int current = pouch.get(type);
                pouch.put(type,current+1);
                bombEffect.poll();
            } else{
                caring-=5;
                bombCaring.push(caring);
            }
            if(isItFull(pouch)){
                break;
            }
        }

        if(isItFull(pouch)){
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

        if(bombEffect.isEmpty()){
            System.out.println("Bomb Effects: empty");
        } else{
            System.out.print("Bomb Effects: ");
            System.out.print(String.join(", ",String.valueOf(bombEffect).replaceAll("\\[","").replaceAll("\\]","")));
            System.out.println();
        }
        if(bombCaring.isEmpty()){
            System.out.println("Bomb Casings: empty");
        } else{
            System.out.print("Bomb Casings: ");
            System.out.print(String.join(", ",String.valueOf(bombCaring).replaceAll("\\[","").replaceAll("\\]","")));
            System.out.println();
        }
        for (Map.Entry<String, Integer> entry : pouch.entrySet()) {
            System.out.printf("%s: %d%n",entry.getKey(),entry.getValue());
        }
    }

    private static boolean isItFull(Map<String, Integer> pouch) {
        for (Integer value : pouch.values()) {
            if(value < 3){
                return false;
            }
        }
        return true;
    }

    private static Map<String, Integer> createPouch() {
        Map<String, Integer> pouch = new LinkedHashMap<>();
        pouch.put("Cherry Bombs",0);
        pouch.put("Datura Bombs",0);
        pouch.put("Smoke Decoy Bombs",0);
        return pouch;
    }

    private static Map<Integer, String> createMap() {
        Map<Integer, String> map = new HashMap<>();
        map.put(40,"Datura Bombs");
        map.put(60,"Cherry Bombs");
        map.put(120,"Smoke Decoy Bombs");
        return map;
    }
}
