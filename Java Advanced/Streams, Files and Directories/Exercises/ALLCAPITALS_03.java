import javax.imageio.IIOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;

public class ALLCAPITALS_03 {
    public static void main(String[] args) throws IOException {
        String pathString = "C:\\Users\\Sunny\\Downloads\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
        Files.readAllLines(Path.of(pathString)).forEach(
                line->{
                    try {
                        writer.write(line.toUpperCase(Locale.ROOT));
                        writer.newLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        );
        writer.close();
    }
}
