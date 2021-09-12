package Preparation;

import java.util.HashMap;
import java.util.Scanner;

public class Phonebook_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap <String,String> phonebook = new HashMap<>();
        String line = scanner.nextLine();
        while(!line.equals("search")){
            String [] tokens = line.split("-");
            phonebook.put(tokens[0],tokens[1]);
            line = scanner.nextLine();
        }
        line = scanner.nextLine();
        while(!line.equals("stop")){
            if (phonebook.containsKey(line)){
                System.out.printf("%s -> %s%n",line,phonebook.get(line));
            } else{
                System.out.printf("Contact %s does not exist.%n",line);
            }
            line = scanner.nextLine();
        }

    }
}
