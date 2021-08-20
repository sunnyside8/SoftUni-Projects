import java.util.Scanner;

public class BlackFlag_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int days = Integer.parseInt(scanner.nextLine());
        double incomeDaily = Double.parseDouble(scanner.nextLine());
        double allPlunder = Double.parseDouble(scanner.nextLine());
        double totalPlunder = 0;
        for (int i = 1; i <= days; i++) {
            totalPlunder+=incomeDaily;
            if (i % 3 == 0){
                double more = incomeDaily * 0.5;
                totalPlunder+= more;
            }
            if ( i%5 == 0){
               totalPlunder = totalPlunder *0.7;
            }
        }
        if (totalPlunder >= allPlunder){
            System.out.printf("Ahoy! %.2f plunder gained.", totalPlunder);
        } else {
            double persentage = (totalPlunder/allPlunder) * 100;
            System.out.printf("Collected only %.2f%% of the plunder.",persentage);
        }
    }
}
