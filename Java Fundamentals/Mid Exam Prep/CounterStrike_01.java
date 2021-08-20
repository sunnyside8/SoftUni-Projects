import java.util.Scanner;

public class CounterStrike_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int energy = Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();
        int wonBattles = 0;
        boolean gamaLost = true;
        while(!command.equals("End of battle")){
            int distance = Integer.parseInt(command);
            energy = energy - distance;
            if (energy <0){
                System.out.printf("Not enough energy! Game ends with %d won battles and %d energy", wonBattles,energy + distance);
                gamaLost = false;
                break;
            } else {
                wonBattles++;
            }
            if (wonBattles % 3 == 0){
                energy+= wonBattles;
            }

            command = scanner.nextLine();
        }
        if (gamaLost){
            System.out.printf("Won battles: %d. Energy left: %d",wonBattles,energy);
        }
    }
}
