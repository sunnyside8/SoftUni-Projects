import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class LineNumbers_05 {
    public static void main(String[] args) throws IOException {
        String pathString = "C:\\Users\\Sunny\\Downloads\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";
        PrintWriter writer = new PrintWriter("outputLine.txt");
        BufferedReader bf = new BufferedReader(new FileReader(pathString));
        int count = 1;
        String line = bf.readLine();
        while(line != null){
            writer.println(count++ + ". " + line);

        }
    }
}
