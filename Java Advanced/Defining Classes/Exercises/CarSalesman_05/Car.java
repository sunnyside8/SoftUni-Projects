package CarSalesman_05;

import java.awt.*;

public class Car {
    private String model;
    private Engine engine;

    //op
    private int weight;
    private String color;

    public Car(String model, Engine engine, String color) {
        this(model,engine);
        this.color = color;
    }

    public Car(String model, Engine engine, int weight) {
        this(model,engine);
        this.weight = weight;
    }

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
        this.weight = 0;
        this.color = "n/a";
    }

    public Car(String model, Engine engine, int weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    @Override
    public String toString() {
        String printweight;
        if(weight == 0){
            printweight = "n/a";
        } else{
            printweight = weight + "";
        }
       StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.model).append(":").append("\n")
                .append(engine.toString()).append("\n")
                .append("Weight: " + printweight).append("\n")
                .append("Color: " + this.color);
        return stringBuilder.toString();
    }
}
