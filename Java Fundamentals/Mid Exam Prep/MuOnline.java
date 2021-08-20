import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MuOnline {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int health = 100;
        int bitcoin = 0;
        int countRooms =0;
        boolean died = false;
        String input = scanner.nextLine();
        List<String> rooms = Arrays.stream(input.split("\\|")).collect(Collectors.toList());
        for (int i = 0; i < rooms.size(); i++) {
            String [] command = rooms.get(i).split(" ");
            countRooms++;
            switch (command[0]){
                case "potion":
                    int healing = Integer.parseInt(command[1]);
                    if (healing + health >= 100){
                        int nowHealing = 100 - health;
                        System.out.printf("You healed for %d hp.%n",nowHealing);
                        health = 100;
                    } else {
                        health+= healing;
                        System.out.printf("You healed for %d hp.%n", healing);
                    }
                    System.out.printf("Current health: %d hp.%n",health);

                    break;
                case "chest":
                    int bitcoinNum = Integer.parseInt(command[1]);
                    bitcoin+=bitcoinNum;
                    System.out.printf("You found %d bitcoins.%n", bitcoinNum);
                    break;
                default:
                    String monster = command[0];
                    int power = Integer.parseInt(command[1]);
                    health = health - power;
                    if (health <= 0){
                        System.out.printf("You died! Killed by %s.%nBest room: %d%n",monster,countRooms);
                        died = true;
                        break;
                    } else {
                        System.out.printf("You slayed %s.%n", monster);
                    }
                    break;
            }
            if (died){
                break;
            }
            if (died){
                break;
            }
        }
        if (health > 0){
            System.out.printf("You've made it!%nBitcoins: %d%nHealth: %d%n", bitcoin, health);
        }
    }
}
