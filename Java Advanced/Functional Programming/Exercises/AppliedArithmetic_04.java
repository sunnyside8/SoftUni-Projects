import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class AppliedArithmetic_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int [] numbers = Arrays.stream(input.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Function<int[],int[]> add = array ->Arrays.stream(array)
                .map(number->number+=1).toArray();
        Function<int[],int[]> multiply = array->Arrays.stream(array)
                .map(digit -> digit*2).toArray();
        Function<int [],int[]> subtract = array->Arrays.stream(array)
                .map(number->number-1).toArray();
        Consumer<int []> print = array->Arrays.stream(array)
                .forEach(number-> System.out.print(number + " "));

        String command = scanner.nextLine();
        while(!command.equals("end")){
            switch(command){
                case"add":
                    numbers = add.apply(numbers);
                    break;
                case"multiply":
                    numbers= multiply.apply(numbers);
                    break;
                case"subtract":
                    numbers = subtract.apply(numbers);
                    break;
                case"print":
                    print.accept(numbers);
                    System.out.println();
                    break;
            }
            command = scanner.nextLine();
        };
    }
}
