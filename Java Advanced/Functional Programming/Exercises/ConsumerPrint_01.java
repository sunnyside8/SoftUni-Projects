import java.util.Scanner;
import java.util.function.Consumer;

public class ConsumerPrint_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String [] names = input.split("\\s+");

//        Consumer<String> printName=name -> System.out.println(name);
//        for (String name : names) {
//            printName.accept(name);
//        }
        Consumer<String[]> printNames = array->{
            for (String name : array) {
                System.out.println(name);
            }
        };
        printNames.accept(names);
    }
}
