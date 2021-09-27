import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CountCharacterTypes_04 {
    public static void main(String[] args) throws IOException {
        String pathString = "C:\\Users\\Sunny\\Downloads\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        List<String> allLines = Files.readAllLines(Path.of(pathString));

        int countVowels = 0;
        int countConsonants = 0;
        int countPunctuation = 0;

        for (String line : allLines) {
            for (int i = 0; i < line.length(); i++) {
                char currentSymbol = line.charAt(i);
                if(currentSymbol == ' '){
                    continue;
                }
                if (currentSymbol == 'a' || currentSymbol == 'e'
                        || currentSymbol == 'i' || currentSymbol == 'o'
                        || currentSymbol == 'u') {
                    countVowels++;
                } else if(currentSymbol =='!'||
                        currentSymbol == '.' ||
                        currentSymbol == '?' || currentSymbol == ','){
                    countPunctuation++;
                } else{
                    countConsonants++;
                }
            }
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
        writer.write("Vowels: " + countVowels+ "\n");
        writer.write("Consonants: " + countConsonants+ "\n");
        writer.write("Punctuation: " + countPunctuation+ "\n");

        writer.flush();
        writer.close();
    }
}
