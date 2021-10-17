package rabbits;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Cage {
    private String name;
    private int capacity;
    private List<Rabbit> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Rabbit rabbit){
        if(capacity > data.size()){
            data.add(rabbit);
        }
    }
    public boolean removeRabbit(String name){
        int index = findIndex(name);
        if(index != -1){
            data.remove(index);
            System.out.println(true);
            return true;
        }
        System.out.println(false);
        return false;
    }

    public void removeSpecies(String species){
        List<Rabbit> toRemove = new ArrayList<>();
        for (Rabbit rabbit : toRemove) {
            if(rabbit.getSpecies().equals(species)){
                toRemove.add(rabbit);
            }
        }
        this.data.removeAll(toRemove);
    }

    public Rabbit sellRabbit(String name){
        int index = findIndex(name);
        data.get(index).setAvailable(false);
        return data.get(index);
    }

    public List<Rabbit> sellRabbitBySpecies(String species){
        List<Rabbit> toSell = new ArrayList<>();
        for (Rabbit rabbit : data) {
            if(rabbit.getSpecies().equals(species)){
                rabbit.setAvailable(false);
                toSell.add(rabbit);
            }
        }
        return toSell;
    }

    public int count(){
        return data.size();
    }

    public String report(){
        StringBuilder build = new StringBuilder("Rabbits available at " + name + ":" + System.lineSeparator());
        for (Rabbit rabbit : data) {
            if(rabbit.isAvailable()) {
                build.append(rabbit + System.lineSeparator());
            }
        }
        return build.toString().trim();
    }

    private int findIndex(String name) {
        for (int i = 0; i < data.size(); i++) {
            if(data.get(i).getName().equals(name)){
                return i;
            }
        }
        return -1;
    }
}
