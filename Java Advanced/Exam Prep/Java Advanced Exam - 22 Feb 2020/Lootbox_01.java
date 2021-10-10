import java.util.ArrayDeque;
import java.util.Scanner;

public class Lootbox_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] boxFirst = scanner.nextLine().split("\\s+");
        String [] boxTwoSt = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> boxOne = new ArrayDeque<>();
        for (String s : boxFirst) {
            boxOne.offer(Integer.parseInt(s));
        }
        ArrayDeque<Integer> boxTwo = new ArrayDeque<>();
        for (String s : boxTwoSt) {
            boxTwo.push(Integer.parseInt(s));
        }
        int sumAwards = 0;
        while(boxOne.size()>=1 && boxTwo.size()>= 1){
            int first = boxOne.peek();
            int second = boxTwo.pop();
            int sum = first + second;
            if(sum % 2 ==0){
                sumAwards+=sum;
                boxOne.poll();
            } else{
                boxOne.offer(second);
            }
        }
        if(boxOne.isEmpty()){
            System.out.println("First lootbox is empty");
        } else{
            System.out.println("Second lootbox is empty");
        }
        if(sumAwards >= 100){
            System.out.printf("Your loot was epic! Value: %d",sumAwards);
        } else{
            System.out.printf("Your loot was poor... Value: %d",sumAwards);
        }
    }
}
