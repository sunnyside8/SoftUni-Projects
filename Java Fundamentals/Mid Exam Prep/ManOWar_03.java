import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ManOWar_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(">");
        List<Integer> pirateShip = Arrays.stream(input).map(e->Integer.parseInt(e)).collect(Collectors.toList());
        String[] inputTwo = scanner.nextLine().split(">");
        List<Integer> warship = Arrays.stream(inputTwo).map(e->Integer.parseInt(e)).collect(Collectors.toList());
        int maxCapacity = Integer.parseInt(scanner.nextLine());
        String commanded = scanner.nextLine();
        boolean warshipSinks = false;
        boolean pirateSinks = false;
        while (!commanded.equals("Retire")){
            String [] command = commanded.split("\\s+");
            switch (command [0]){
                case "Fire":
                    int index = Integer.parseInt(command[1]);
                    int damage = Integer.parseInt(command[2]);
                    if (isIndexValidWarship(index,warship.size())){
                        int givenHealth = warship.get(index);
                        givenHealth-=damage;
                        if (givenHealth <= 0){
                            System.out.println("You won! The enemy ship has sunken.");
                            return;
                        } else {
                            warship.set(index,givenHealth);
                        }
                    }
                    break;
                case "Defend":
                    int startIndex = Integer.parseInt(command[1]);
                    int endIndex = Integer.parseInt(command[2]);
                    int damageInflicted = Integer.parseInt(command[3]);
                    if (isIndexValiidPierate(startIndex,endIndex,pirateShip.size())){
                        for (int i = startIndex; i <= endIndex; i++) {
                            int givenSection = pirateShip.get(i);
                            givenSection-=damageInflicted;
                            if (givenSection <= 0){
                                System.out.println("You lost! The pirate ship has sunken.");
                                return;
                            } else {
                                pirateShip.set(i,givenSection);
                            }
                        }
                    }
                    break;
                case "Repair":
                    int indexToRepair = Integer.parseInt(command[1]);
                    int healthToAdd = Integer.parseInt(command[2]);
                    if (indexToRepair >= 0 && indexToRepair <pirateShip.size()){
                        int currentHealth = pirateShip.get(indexToRepair);
                        currentHealth += healthToAdd;
                        if (currentHealth > maxCapacity){
                            currentHealth = maxCapacity;
                        }
                        pirateShip.set(indexToRepair,currentHealth);
                    }
                    break;
                case"Status":
                    int count = 0;
                    for (int i = 0; i < pirateShip.size(); i++) {
                        int currentCapacity = pirateShip.get(i);
                        if (currentCapacity < maxCapacity*0.2){
                           count++;
                        }
                    }
                    System.out.printf("%d sections need repair.%n",count);
                    break;
            }
            commanded = scanner.nextLine();
        }
        int sumPirate = 0;
        int sumWarship = 0;
        for (int i = 0; i < pirateShip.size(); i++) {
            int num = pirateShip.get(i);
            sumPirate+=num;
        }
        for (int i = 0; i < warship.size(); i++) {
            int nume = warship.get(i);
            sumWarship+= nume;
        }
        System.out.println("Pirate ship status: " + sumPirate);
        System.out.println("Warship status: " + sumWarship);

    }

    private static boolean isIndexValiidPierate(int startIndex, int endIndex, int size) {
        if (startIndex >= 0 && startIndex < size -1 && endIndex > 1 && endIndex < size ){
            return true;
        }
        return false;
    }

    private static boolean isIndexValidWarship(int index, int size) {
        if (index >= 0 && size > index){
            return true;
        }
        return false;
    }
}
