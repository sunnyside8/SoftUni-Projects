import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShootForTheWin_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        List<Integer> targets = Arrays.stream(input).map(e->Integer.parseInt(e)).collect(Collectors.toList());
        int countShotTarget = 0;
        while(true){
            String command = scanner.nextLine();
            if (command.equals("End")){
                break;
            }
            int shot = Integer.parseInt(command);
            if (shot >= targets.size()){
                continue;
            }
            if (targets.get(shot) == -1){
                continue;
            }
            int targetValue = targets.get(shot);
            for (int i = 0; i < targets.size(); i++) {
                int num = targets.get(i);
                if (num > targetValue && num != -1){
                    num -= targetValue;
                    targets.set(i,num);
                } else if (num <= targetValue && num != -1) {
                    num += targetValue;
                    targets.set(i,num);
                }
            }
            targets.set(shot, -1);
            countShotTarget++;

        }
        System.out.printf("Shot targets: %d -> ",countShotTarget);
        for (int index = 0; index < targets.size(); index++) {
            System.out.print(targets.get(index) + " ");
        }
    }
}
