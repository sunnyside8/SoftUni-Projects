import java.util.Scanner;

public class SoftUniReception_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstEmployee = Integer.parseInt(scanner.nextLine());
        int secondEmployee = Integer.parseInt(scanner.nextLine());
        int thirdEmployee = Integer.parseInt(scanner.nextLine());
        int allEmployees = firstEmployee + secondEmployee + thirdEmployee;
        int countHours = 0;
        int totalRequests = Integer.parseInt(scanner.nextLine());
        while (totalRequests > 0){
            totalRequests-= allEmployees;
            countHours++;
            if (countHours % 4 == 0){
                countHours++;
            }
        }
        System.out.printf("Time needed: %dh.",countHours);
    }
}
