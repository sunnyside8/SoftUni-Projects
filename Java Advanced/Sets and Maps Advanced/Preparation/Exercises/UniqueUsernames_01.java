package Preparation;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class UniqueUsernames_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n =Integer.parseInt(scanner.nextLine());
        LinkedHashSet<String> usernames = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            usernames.add(line);
        }
        for (String username : usernames) {
            System.out.println(username);
        }
    }
}
