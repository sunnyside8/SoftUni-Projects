import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ArrayModifier_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        List<Integer> integers = Arrays.stream(input).map(e->Integer.parseInt(e)).collect(Collectors.toList());
        String commanded = scanner.nextLine();
        while (!commanded.equals("end")){
            String[] command = commanded.split("\\s+");
            switch (command[0]){
                case "swap":
                    int indexOne = Integer.parseInt(command[1]);
                    int indexTwo = Integer.parseInt(command[2]);
                    int swapOne = integers.get(indexOne);
                    int swapTwo = integers.get(indexTwo);
                    integers.set(indexOne,swapTwo);
                    integers.set(indexTwo,swapOne);

                    break;
                case"multiply":
                    int oneIndex = Integer.parseInt(command[1]);
                    int twoIndex = Integer.parseInt(command[2]);
                    int firstNum = integers.get(oneIndex);
                    int secondNum = integers.get(twoIndex);
                    int multiply = firstNum * secondNum;
                    integers.set(oneIndex,multiply);
                    break;
                case "decrease":
                    for (int i = 0; i < integers.size(); i++) {
                        int number = integers.get(i) - 1;
                        integers.set(i,number);
                    }
                    break;
            }
            commanded = scanner.nextLine();
        }
        System.out.println(integers.toString().replace("[","")
                .replace("]",""));
    }
}
