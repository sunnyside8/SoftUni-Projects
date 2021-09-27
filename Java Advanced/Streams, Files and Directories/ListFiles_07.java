import java.io.File;
import java.util.Scanner;

public class ListFiles_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        File file = new File("C:\\Users\\Sunny\\Downloads\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");
       File[] files = file.listFiles();
        for (File f : files) {
            if(!f.isDirectory()){
                System.out.printf("%s: [%d]%n",f.getName(),f.length());
            }
        }
        
    }
}
