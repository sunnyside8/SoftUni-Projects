import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PrinterQueue_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> queue = new ArrayDeque<>();

        String task = scanner.nextLine();

        while (!task.equals("print")) {
            if (task.equals("cancel")) {
                if (queue.isEmpty()) {
                    System.out.println();
                } else {
                }

            } else{
                queue.offer(task);
            }

            task = scanner.nextLine();
        }
        queue.stream().map(String::valueOf)
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
