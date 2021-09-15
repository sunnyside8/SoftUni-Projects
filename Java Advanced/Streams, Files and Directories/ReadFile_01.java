import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class ReadFile_01 {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Sunny\\Downloads\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        FileInputStream inputStream = new FileInputStream(path);
        Scanner scanner = new Scanner(path);

       int nextByte = inputStream.read();
       while(nextByte != -1){
           System.out.print(Integer.toBinaryString(nextByte) + " ");
           nextByte = inputStream.read();
       }
    }
}
