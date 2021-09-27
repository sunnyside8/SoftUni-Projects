import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class SumBytes_02 {
    public static void main(String[] args) throws IOException {
        String pathString = "C:\\Users\\Sunny\\Downloads\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        byte[] allBytes = Files.readAllBytes(Path.of(pathString));
        long sum = 0;
        for (byte value : allBytes) {
            if(value != 10 && value != 13) {
                sum += value;
            }
        }
        System.out.println(sum);
    }
}
