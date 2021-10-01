import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.Set;

public class Bouquets_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] tulipsStr = scanner.nextLine().split(",\\s+");
        String [] daffodilsStr = scanner.nextLine().split(",\\s+");
        ArrayDeque<Integer> tulips = new ArrayDeque<>();
        ArrayDeque<Integer> daffodils = new ArrayDeque<>();
        for (String s : tulipsStr) {
            tulips.push(Integer.parseInt(s));
        }
        for (String s : daffodilsStr) {
            daffodils.offer(Integer.parseInt(s));
        }
        int storage = 0;
        int bouquets = 0;
        while(!tulips.isEmpty() && !daffodils.isEmpty()){
            int currentTulips = tulips.pop();
            int currentDaffodils = daffodils.poll();
            if(currentDaffodils + currentTulips > 15){
                while(currentTulips + currentDaffodils > 15){
                    currentTulips-=2;
                }
            }
            if(currentDaffodils + currentTulips == 15){
                bouquets++;
            } else if(currentDaffodils + currentTulips < 15){
                storage += currentDaffodils + currentTulips;
            }
        }
        bouquets+=storage/15;
        if(bouquets >= 5){
            System.out.printf("You made it! You go to the competition with %d bouquets!",bouquets);
        } else{
            System.out.printf("You failed... You need more %d bouquets.",5-bouquets);
        }
    }
}
