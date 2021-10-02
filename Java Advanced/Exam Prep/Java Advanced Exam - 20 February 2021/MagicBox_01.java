import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class MagicBox_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] boxOne = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int [] boxTwo = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        ArrayDeque<Integer> firstBox = new ArrayDeque<>();
        for (Integer box : boxOne) {
            firstBox.offer(box);
        }
        ArrayDeque<Integer> secondBox = new ArrayDeque<>();
        for (Integer box : boxTwo) {
            secondBox.push(box);
        }
        int prey = 0;
        while(firstBox.size()>= 1  &&  secondBox.size()>=1){
            int firstValue = firstBox.peek();
            int secondValue = secondBox.pop();
            int sum = firstValue + secondValue;
            if(sum %2 == 0){
                prey += sum;
                firstBox.poll();
            } else{
                firstBox.addLast(secondValue);
            }
        }
        String output = "";
        if(firstBox.size() == 0){
           output = "First magic box is empty.";
        } else{
           output = "Second magic box is empty.";
        }
        System.out.println(output);
        if(prey > 90){
            System.out.printf("Wow, your prey was epic! Value: %d",prey);
        } else{
            System.out.printf("Poor prey... Value: %d",prey);
        }

    }
}
