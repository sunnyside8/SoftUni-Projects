package Preparation;
import java.util.Scanner;
import java.util.LinkedHashSet;


public class ParkingLot_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashSet<String> parkingLot = new LinkedHashSet<>();
        String input = scanner.nextLine();
        while(!input.equals("END")){
            String [] tokens = input.split(",\\s+");
            String car = tokens[1];
            if (tokens[0].equals("IN")){
                parkingLot.add(car);
            } else if (tokens[0].equals("OUT")){
                parkingLot.remove(car);
            }
            input = scanner.nextLine();
        }
        if (parkingLot.isEmpty()){
            System.out.println("Parking Lot is Empty");
        } else{
            System.out.println(String.join(System.lineSeparator(),parkingLot));
        }
    }
}
