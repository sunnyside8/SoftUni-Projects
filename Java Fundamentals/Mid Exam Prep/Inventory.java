import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Inventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<String> inventory = Arrays.stream(input.split(",\\s+")).collect(Collectors.toList());
        while (true) {
            String commanded = scanner.nextLine();
            if (commanded.equals("Craft!")) {
                break;
            }
            String[] command = commanded.split(" - ");
            switch (command[0]) {
                case "Collect":
                    String item = command[1];
                    if (!inventory.contains(item)) {
                        inventory.add(item);
                    }
                    break;
                case "Drop":
                    String itemToDrop = command[1];
                    if (inventory.contains(itemToDrop)) {
                        inventory.remove(itemToDrop);
                    }
                    break;
                case "Combine Items":
                    String newing = command[1];
                    String[] itemsToUpgrade = newing.split(":");
                    String oldItem = itemsToUpgrade[0];
                    String newItem = itemsToUpgrade[1];
                    int index = 0;
                    if (inventory.contains(oldItem)) {
                        for (int i = 0; i < inventory.size(); i++) {
                            if (inventory.get(i).equals(oldItem)) {
                                index = i;
                                break;
                            }
                        }
                        inventory.add(index + 1, newItem);
                    }

                    break;
                case "Renew":
                    String itemToRenew = command[1];
                    if (inventory.contains(itemToRenew)) {
                        inventory.remove(itemToRenew);
                        inventory.add(itemToRenew);
                    }
                    break;

            }
        }
        System.out.println(String.join(", ",inventory));
        }
    }

