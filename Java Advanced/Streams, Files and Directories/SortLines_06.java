import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class SortLines_06 {
    public static void main(String[] args)throws IOException {
        FileInputStream inputStream=  new FileInputStream("input.txt");

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(inputStream));
       String line =  reader.readLine();

        List<String> lines = new ArrayList<>();
        while(line != null){
            lines.add(line);
            line = reader.readLine();
        }
        Collections.sort(lines);

        Files.write(Path.of("sorted-line-out.txt"), lines);

    }
}
