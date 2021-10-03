import java.util.*;

public class Cooking_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] stringLiquids = scanner.nextLine().split("\\s+");
        String [] stringIngredient = scanner.nextLine().split("\\s+");
        Map<Integer,String> bakedGoods = createMap();
        ArrayDeque<Integer> liquids = new ArrayDeque<>();
        for (String s : stringLiquids) {
            liquids.offer(Integer.parseInt(s));
        }
        ArrayDeque<Integer> ingredients = new ArrayDeque<>();
        for (String s : stringIngredient) {
            ingredients.push(Integer.parseInt(s));
        }
        Map<String,Integer> baked = bakedMap();
        while(liquids.size() >= 1 && ingredients.size() >= 1){
            int liquid = liquids.poll();
            int ingredient = ingredients.pop();
            int sum = liquid + ingredient;
            if(bakedGoods.containsKey(sum)){
                int current = baked.get(bakedGoods.get(sum));
                baked.put(bakedGoods.get(sum), current+1);
            } else{
                ingredient+=3;
                ingredients.push(ingredient);
            }
        }
        boolean isEverythingBaked = isEverything(baked);
        if(isEverythingBaked){
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else{
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }

        if(liquids.isEmpty()){
            System.out.println("Liquids left: none");
        } else{
            System.out.print("Liquids left: ");
            System.out.print(String.join(", ",String.valueOf(liquids).replaceAll("\\[","").replaceAll("\\]","")));
            System.out.println();
        }
        if(ingredients.isEmpty()){
            System.out.println("Ingredients left: none");
        } else{
            System.out.print("Ingredients left: ");
            System.out.print(String.join(", ",String.valueOf(ingredients).replaceAll("\\[","").replaceAll("\\]","")));
            System.out.println();
        }
        for (Map.Entry<String, Integer> entry : baked.entrySet()) {
            System.out.printf("%s: %d%n",entry.getKey(),entry.getValue());
        }
    }

    private static boolean isEverything(Map<String, Integer> baked) {
        for (Integer value : baked.values()) {
            if(value == 0){
                return false;
            }
        }
        return true;
    }

    private static Map<String, Integer> bakedMap() {
        Map<String, Integer> baked = new LinkedHashMap<>();
        baked.put("Bread",0);
        baked.put("Cake",0);
        baked.put("Fruit Pie",0);
        baked.put("Pastry",0);
        return baked;
    }

    private static Map<Integer, String> createMap() {
        Map<Integer, String> map = new HashMap<>();
        map.put(25,"Bread");
        map.put(50,"Cake");
        map.put(75,"Pastry");
        map.put(100,"Fruit Pie");
        return map;
    }
}
