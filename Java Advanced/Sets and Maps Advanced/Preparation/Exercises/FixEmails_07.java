package Preparation;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        LinkedHashMap <String,String> emails = new LinkedHashMap<>();
        while(!name.equals("stop")){
            String email = scanner.nextLine();
            String [] tokens = email.split("\\.");
            if (!verifyEmail(tokens[tokens.length-1])){
                emails.put(name,email);
            }
            name = scanner.nextLine();
        }
        for (var entry : emails.entrySet()) {
            System.out.printf("%s -> %s%n",entry.getKey(),entry.getValue());
        }
    }

    private static boolean verifyEmail(String token) {
        return token.equals("us") || token.equals("uk") || token.equals("com");
    }
}
