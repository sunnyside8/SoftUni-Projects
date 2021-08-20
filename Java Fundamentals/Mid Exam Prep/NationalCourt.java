import java.util.Scanner;

public class NationalCourt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int employeeOne = Integer.parseInt(scanner.nextLine());
        int employeeTwo = Integer.parseInt(scanner.nextLine());
        int employeeThree = Integer.parseInt(scanner.nextLine());
        int questions = Integer.parseInt(scanner.nextLine());
        int employeeAnswers = employeeOne + employeeTwo + employeeThree;
        int count = 0;
        while (questions > 0){
            questions-= employeeAnswers;
            count++;
            if (count % 4 == 0){
                count+= 1;
            }
        }
        System.out.printf("Time needed: %dh.",count);
    }
}
