import java.util.ArrayDeque;
import java.util.Scanner;

public class FlowerWreats_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] liliesString = scanner.nextLine().split(",\\s+");
        String [] rosesString = scanner.nextLine().split(",\\s+");
        ArrayDeque<Integer> lilies = new ArrayDeque<>();
        for (String s : liliesString) {
            lilies.push(Integer.parseInt(s));
        }
        ArrayDeque<Integer> roses = new ArrayDeque<>();
        for (String s : rosesString) {
            roses.offer(Integer.parseInt(s));
        }
        int storage = 0;
        int wreaths = 0;
        while(roses.size()>=1 && lilies.size()>=1){
            int lilie = lilies.pop();
            int rose = roses.poll();
            if(rose + lilie > 15){
                while(rose + lilie > 15){
                    lilie-=2;
                }
            }
           if(rose + lilie == 15){
               wreaths +=1;
           } else if (rose + lilie < 15){
               storage+=rose + lilie;
           }
        }
        wreaths+= storage/15;
        if(wreaths >= 5){
            System.out.printf("You made it, you are going to the competition with %d wreaths!",wreaths);
        } else {
            System.out.printf("You didn't make it, you need %d wreaths more!",5-wreaths);
        }
    }
}
