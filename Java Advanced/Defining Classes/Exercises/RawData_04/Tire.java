package RawData_04;

public class Tire {
 //{Tire1Pressure} {Tire1Age}
    private double pressure;
    private int age;

    public Tire(double pressure, int age) {
        this.pressure = pressure;
        this.age = age;
    }

    public double getPressure() {
        return pressure;
    }
}
