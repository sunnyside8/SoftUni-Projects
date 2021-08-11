import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
       String regex = "([\\#\\|])(?<itemName>[A-Za-z ]+)\\1(?<date>[0-9]{2}\\/[0-9]{2}\\/[0-9]{2})\\1(?<calories>[0-9]+)\\1";
        Pattern pattern = Pattern.compile(regex);
        int calories = 0;
        List<String > products = new ArrayList<>();
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()){
            int caloriesProduct = Integer.parseInt(matcher.group("calories"));
            if (caloriesProduct > 0 && caloriesProduct <= 10000 ){
                StringBuilder string = new StringBuilder();
                String productName = matcher.group("itemName");
                String expirationDate = matcher.group("date");
                calories += caloriesProduct;
                string.append("Item: ");
                string.append(productName);
                string.append(", Best before: ");
                string.append(expirationDate);
                string.append(", Nutrition: ");
                string.append(caloriesProduct);
                products.add(string.toString());
            }
        }
        System.out.printf("You have food to last you for: %d days!%n",calories/2000);
        products.stream().forEach(e-> System.out.println(e));
    }
}
