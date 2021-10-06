package RawData_04;

public class Engine {
    //{EngineSpeed} {EnginePower}
    private int speed;
    private int power;

    public Engine(int speed, int power) {
        this.speed = speed;
        this.power = power;
    }

    public int getPower() {
        return power;
    }
}
