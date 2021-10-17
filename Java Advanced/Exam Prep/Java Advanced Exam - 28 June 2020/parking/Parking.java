package parking;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Parking {
    private List<Car> data;
    private String type;
    private int capacity;

    public Parking(String type, int capacity) {
        this.data = new ArrayList<>();
        this.type = type;
        this.capacity = capacity;
    }
    public void add(Car car){
        if(capacity > data.size()){
            this.data.add(car);
        }
    }

    public boolean remove(String manufacturer, String model){
        int index = findIndex(manufacturer,model);
        if(index != -1){
            data.remove(index);
            return true;
        }
        return false;
    }

    public Car getLatestCar(){
        return data.stream().max(Comparator.comparing(Car::getYear)).orElse(null);
    }

    public Car getCar(String manufacturer, String model){
        int index = findIndex(manufacturer,model);
        if(index == -1){
            return null;
        } else{
            return this.data.get(index);
        }
    }

    public int getCount(){
        return this.data.size();
    }

    public String getStatistics(){
        StringBuilder build = new StringBuilder("The cars are parked in "+ this.type +":" + System.lineSeparator());
        for (Car data : data) {
            build.append(data + System.lineSeparator());
        }
        return build.toString().trim();
    }

    private int findIndex(String manufacturer, String model) {
        for (int i = 0; i < data.size(); i++) {
            if(data.get(i).getModel().equals(model) && data.get(i).getManufacturer().equals(manufacturer)){
               return i;
            }
        }
        return -1;
    }
}
