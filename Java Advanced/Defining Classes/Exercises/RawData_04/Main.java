package RawData_04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String [] info = scanner.nextLine().split("\\s+");
            //ChevroletAstro 200 180 1000 fragile 1.3 1 1.5 2 1.4 2 1.7 4
            String model = info[0];
            int engineSpeed = Integer.parseInt(info[1]);
            int enginePower = Integer.parseInt(info[2]);
            int cargoWeight = Integer.parseInt(info[3]);
            String cargoType = info[4];
            double oneTirePressure = Double.parseDouble(info[5]);
            int oneTireAge = Integer.parseInt(info[6]);
            double twoTirePressure = Double.parseDouble(info[7]);
            int twoTireAge = Integer.parseInt(info[8]);
            double threeTirePressure = Double.parseDouble(info[9]);
            int threeTireAge = Integer.parseInt(info[10]);
            double fourTirePressure = Double.parseDouble(info[11]);
            int fourTireAge = Integer.parseInt(info[12]);

            Tire tireOne = new Tire(oneTirePressure,oneTireAge);
            Tire tireTwo = new Tire(twoTirePressure,twoTireAge);
            Tire tireThree = new Tire(threeTirePressure,threeTireAge);
            Tire tireFour = new Tire(fourTirePressure,fourTireAge);
               List<Tire> tires = new ArrayList<>();
            tires.add(tireOne);
            tires.add(tireTwo);
            tires.add(tireThree);
            tires.add(tireFour);

            Engine engine = new Engine(engineSpeed,enginePower);
            Cargo cargo = new Cargo(cargoWeight,cargoType);
            Car car = new Car(model,engine,cargo,tires);
            cars.add(car);
        }
        String command = scanner.nextLine();
        if (command.equals("fragile")){
            for (Car car : cars) {
                String cargo = car.getCargo().getType();
                if(cargo.equals("fragile")){
                    if(areInForm(car.getTires())){
                        System.out.println(car.getModel());
                    }
                }
            }
        } else if (command.equals("flamable")){
            for (Car car : cars) {
                String cargo = car.getCargo().getType();
                if(cargo.equals("flamable")){
                    if(car.getEngine().getPower() > 250){
                        System.out.println(car.getModel());
                    }
                }
            }
        }
    }

    private static boolean areInForm(List<Tire> tires) {
        for (Tire tire : tires) {
            if(tire.getPressure() < 1){
                return true;
            }
        }
        return false;
    }
}
