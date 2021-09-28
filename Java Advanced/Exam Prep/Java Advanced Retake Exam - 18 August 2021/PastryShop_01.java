import java.util.*;

public class PastryShop_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] liquidsArray = scanner.nextLine().split("\\s+");
        String[] ingredientsArray = scanner.nextLine().split("\\s+");
        Map<Integer, String> food = getFood();
        ArrayDeque<Integer> liquids = new ArrayDeque<>();
        for (String s : liquidsArray) {
            liquids.offer(Integer.parseInt(s));
        }
        ArrayDeque<Integer> ingredients = new ArrayDeque<>();
        for (String s : ingredientsArray) {
            ingredients.push(Integer.parseInt(s));
        }
        Map<String, Integer> baked = getBaked();
        boolean add3 = false;
        while (!liquids.isEmpty() && !ingredients.isEmpty()) {
            int liquid = liquids.poll();
            int ingredient = ingredients.poll();
            int sum = liquid + ingredient;
            if (food.containsKey(sum)) {
                String bakedFood = food.get(sum);
                baked.put(bakedFood, baked.get(bakedFood) + 1);
            } else {
                ingredient += 3;
                ingredients.push(ingredient);
            }
        }
        if(doWeHaveAtLeastOne(baked)){
            System.out.println("Great! You succeeded in cooking all the food!");
        } else{
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }
        if (liquids.isEmpty()){
            System.out.println("Liquids left: none");
        } else{
            System.out.print("Liquids left: ");
            printLI(liquids);
        }
        if(ingredients.isEmpty()){
            System.out.println("Ingredients left: none");
        } else{
            System.out.print("Ingredients left: ");
            printLI(ingredients);
        }
        baked.entrySet().stream()
                .forEach(e-> System.out.printf("%s: %d%n",e.getKey(),e.getValue()));
    }

    private static boolean doWeHaveAtLeastOne(Map<String, Integer> baked) {
        for (Integer value : baked.values()) {
            if(value == 0){
                return false;
            }
        }
        return true;
    }

    private static void printLI(ArrayDeque<Integer> liquids) {
        System.out.print(String.join(", ",liquids.toString()).replaceAll("\\[","").replaceAll("\\]",""));
        System.out.println();

    }

    private static LinkedHashMap<String, Integer> getBaked() {
        LinkedHashMap<String, Integer> cooked = new LinkedHashMap<>();
        cooked.put("Biscuit", 0);
        cooked.put("Cake", 0);
        cooked.put("Pie", 0);
        cooked.put("Pastry", 0);
        return cooked;
    }

    private static HashMap<Integer, String> getFood() {
        HashMap<Integer, String> food = new HashMap<>();
        food.put(25, "Biscuit");
        food.put(50, "Cake");
        food.put(75, "Pastry");
        food.put(100, "Pie");
        return food;
    }
}
