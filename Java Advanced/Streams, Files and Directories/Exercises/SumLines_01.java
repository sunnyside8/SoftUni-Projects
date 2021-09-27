import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class SumLines_01 {
    public static void main(String[] args)  {
        String pathString = "C:\\Users\\Sunny\\Downloads\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        Path path = Path.of(pathString);
        List<String> allLines = null;
        try {
            allLines = Files.readAllLines(path);
        } catch (IOException e) {
            System.out.println("Error while reading file");
        }

        for (String line : allLines) {
            int sum = 0;
            for (int i = 0; i < line.length(); i++) {
                char currentSymbol = line.charAt(i);
                sum += currentSymbol;
            }
            System.out.println(sum);
        }



//        allLines.stream().map(String::toCharArray)
//                .forEach(
//                        charArray ->{
//                            int sum=0;
//                            for (char c : charArray) {
//                                sum+=c;
//                            }
//                            System.out.println(sum);
//                        }
//                );
    }
}
