package CarSalesman_05;

public class Engine {
    private String model;
        private int power;

        private int displacement;
        private String efficiency;

    public Engine(String model, int power) {
        this.model = model;
        this.power = power;
        this.displacement = 0;
        this.efficiency = "n/a";
    }

    public Engine(String model, int power, int displacement) {
        this(model,power);
        this.displacement = displacement;
    }

    public Engine(String model, int power, String efficiency) {
        this(model,power);
        this.efficiency = efficiency;
    }

    public Engine(String model, int power, int displacement, String efficiency) {
        this(model,power);
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    @Override
    public String toString() {
       StringBuilder stringBuilder = new StringBuilder();
        String printDisplacement;
        if(this.displacement == 0){
            printDisplacement = "n/a";
        } else{
            printDisplacement = this.displacement + "";
        }
        stringBuilder.append(model).append(":").append("\n")
                .append("Power: ").append(power).append("\n")
                .append("Displacement: " + printDisplacement).append("\n")
                .append("Efficiency: " + efficiency) ;
        return stringBuilder.toString();
    }
}
