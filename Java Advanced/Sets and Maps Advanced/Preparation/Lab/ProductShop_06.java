package Preparation;

import java.util.*;

public class ProductShop_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, List<Product>> supermarkets = new TreeMap<>();
        String line = scanner.nextLine();
        while (!line.equals("Revision")) {
            String[] tokens = line.split(",\\s+");
            String supermarket = tokens[0];
            String product = tokens[1];
            double price = Double.parseDouble(tokens[2]);
            supermarkets.putIfAbsent(supermarket, new ArrayList<>());
            Product productObject = new Product(product, price);
            supermarkets.get(supermarket).add(productObject);
            line = scanner.nextLine();
        }
        for (var entry : supermarkets.entrySet()) {
            System.out.println(entry.getKey() + "->");
            List<Product> list = entry.getValue();
            list.forEach(e-> System.out.printf("Product: %s, Price: %.1f%n",e.getName(),e.getPrice()));
        }
    }

    static class Product {
        private String name;
        private double price;

        public Product(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }
}
