package SpeedRacing_03;

public class Car {
   private String name;
   private double fuel;
   private double consumption;
   private double distanceTraveled;

    public Car(String name, double fuel, double consumption) {
        this.name = name;
        this.fuel = fuel;
        this.consumption = consumption;
        this.distanceTraveled = 0;
    }

    public boolean drive(double kilometersToDrive){
        double fuelRequired = kilometersToDrive * consumption;
        if(fuelRequired > this.fuel){
            return false;
        } else{
            this.fuel -= fuelRequired;
            this.distanceTraveled += kilometersToDrive;
            return true;
        }
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %.0f",this.name,this.fuel,this.distanceTraveled);
    }
}
