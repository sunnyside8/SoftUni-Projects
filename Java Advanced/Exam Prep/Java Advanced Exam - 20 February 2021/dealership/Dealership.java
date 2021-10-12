package dealership;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    public List<Car> data;
    public String name;
    public int capacity;

    public Dealership(String name, int capacity) {
        this.data = new ArrayList<>();
        this.name = name;
        this.capacity = capacity;
    }

    public void add(Car car){
        if (data.size() < capacity){
            data.add(car);
        }
    }
    public boolean buy(String manufacturer, String model){
        int index = getIndex(manufacturer, model);
        if(index == -1){
            return false;
        } else{
            data.remove(index);
            return true;
        }
    }


    public Car getLatestCar(){
        return data.stream().max((e1,e2) -> e1.getYear()).orElse(null);
    }

    public Car getCar(String manufacturer, String model){
        int index = getIndex(manufacturer,model);
        if(index == -1){
            return null;
        } else{
            return data.get(index);
        }
    }
    public int getCount(){
        return data.size();
    }
    public String getStatistics(){
        StringBuilder build = new StringBuilder("The cars are in a car dealership " + this.name + ":"+System.lineSeparator());
        for (Car datum : data) {
            build.append(datum + System.lineSeparator());
        }
        return build.toString().trim();
    }

    private int getIndex(String manufacturer, String model){
        for (int i = 0; i < data.size(); i++) {
            if(data.get(i).getManufacturer().equals(manufacturer) && data.get(i).getModel().equals(model)){
                return  i;
            }
        }
        return -1 ;
    }

}
