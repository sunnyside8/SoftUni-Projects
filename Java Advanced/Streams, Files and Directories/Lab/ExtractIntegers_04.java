import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class ExtractIntegers_04 {
    public static void main(String[] args) throws IOException {
        String path = "input.txt";

        FileReader reader = new FileReader(path);
        PrintStream printStream = new PrintStream("printIntegers.txt");

        Scanner scanner = new Scanner(reader);

        while (scanner.hasNext()){
            if(scanner.hasNextInt()) {
                printStream.println(scanner.nextInt());
            }
            scanner.next();
        }
    }
}
