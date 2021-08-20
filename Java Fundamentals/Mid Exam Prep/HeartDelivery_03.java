import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HeartDelivery_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("@");
        List<Integer> houses = Arrays.stream(input).map(e -> Integer.parseInt(e)).collect(Collectors.toList());
        System.out.println();
        int cupidPosition = 0;
        while (true) {
            String commanded = scanner.nextLine();
            if (commanded.equals("Love!")) {
                break;
            }
            String[] command = commanded.split("\\s+");
            cupidPosition = Integer.parseInt(command[1]) + cupidPosition;
            if (cupidPosition >= houses.size()) {
                cupidPosition = 0;
            }
            int currentHouse = houses.get(cupidPosition);
            if (currentHouse == 0) {
                System.out.printf("Place %d already had Valentine's day.%n", cupidPosition);
            } else {
                currentHouse -= 2;
                if (currentHouse == 0) {
                    System.out.printf("Place %d has Valentine's day.%n", cupidPosition );
                }
                houses.set(cupidPosition, currentHouse);
            }

        }
        System.out.printf("Cupid's last position was %d.%n", cupidPosition);
        int count = 0;
        for (int i = 0; i < houses.size(); i++) {
           if (houses.get(i) != 0){
               count++;
           }
        }
        if (count == 0){
            System.out.println("Mission was successful.");
        } else {
            System.out.printf("Cupid has failed %d places.", count);
        }
    }
}
