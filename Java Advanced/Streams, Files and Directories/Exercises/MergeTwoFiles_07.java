import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MergeTwoFiles_07 {
    public static void main(String[] args) throws IOException {
        Path pathFileOne = Path.of("C:\\Users\\Sunny\\Downloads\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt");
        List<String> allLinesFirstFile = Files.readAllLines(pathFileOne);
        Path pathFileTwo = Path.of("C:\\Users\\Sunny\\Downloads\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt");
        List<String> allLinesSecondFile = Files.readAllLines(pathFileTwo);
        PrintWriter writer = new PrintWriter("outputMerge.txt");
        allLinesFirstFile.forEach(line->writer.println(line));
        allLinesSecondFile.forEach(line->writer.println(line));

        writer.close();
    }
}
