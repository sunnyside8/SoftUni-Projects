package SpeedRacing_03;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String,Car> cars = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String [] input = scanner.nextLine().split("\\s+");
            String model = input[0];
            double fuel = Double.parseDouble(input[1]);
            double consumption = Double.parseDouble(input[2]);
            Car car = new Car(model,fuel,consumption);
            cars.put(model,car);
        }
        String command = scanner.nextLine();
        while(!command.equals("End")){
            String [] driveCommand = command.split("\\s+");
            String carModel = driveCommand[1];
            double kilometersToDrive = Double.parseDouble(driveCommand[2]);
            Car car = cars.get(carModel);
           if(!car.drive(kilometersToDrive)){
               System.out.println("Insufficient fuel for the drive");
           }
            command = scanner.nextLine();
        }
        cars.entrySet().stream()
                .forEach(e-> System.out.println(e.getValue()));
    }
}
