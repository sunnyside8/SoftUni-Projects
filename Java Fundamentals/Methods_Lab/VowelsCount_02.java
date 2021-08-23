import java.util.Scanner;

public class VowelsCount_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        input = input.toLowerCase();
        countVowels(input);
    }

    private static void countVowels(String input) {
        int c = 0;
        for (char letter:input.toCharArray()) {
            if (letter == 'a'||letter=='e'||letter == 'o'|| letter == 'u'
                    || letter == 'i'){
                c++;
            }
        }
        System.out.println(c);
    }
}