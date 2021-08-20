import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShoppingList_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<String> list = Arrays.stream(input.split("!")).collect(Collectors.toList());
        while (true){
            String commanding = scanner.nextLine();
            if (commanding.equals("Go Shopping!")){
                break;
            }
            String[] command = commanding.split("\\s+");
            switch (command[0]){
                case"Urgent":
                    String item = command[1];
                    if (!list.contains(item)){
                        list.add(0,item);
                    }
                    break;
                case "Unnecessary":
                    String itemToRemove = command[1];
                    if (list.contains(itemToRemove)){
                        list.remove(itemToRemove);
                    }
                    break;
                case "Correct":
                    String oldItem = command[1];
                    String newItem = command[2];
                    int index = 0;
                    if (list.contains(oldItem)){
                        for (int i = 0; i < list.size(); i++) {
                            if (list.get(i).equals(oldItem)){
                                index = i;
                                break;
                            }
                        }
                        list.set(index,newItem);
                    }
                    break;
                case "Rearrange":
                String toMove = command[1];
                if (list.contains(toMove)){
                    list.remove(toMove);
                    list.add(toMove);
                }
                    break;

            }
        }
        System.out.println(String.join(", ", list));
    }
}
