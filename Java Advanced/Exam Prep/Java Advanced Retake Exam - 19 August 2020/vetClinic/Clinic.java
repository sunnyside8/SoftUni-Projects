package vetClinic;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Clinic {
    private List<Pet> data;
    private int capacity;

    public Clinic( int capacity) {
        this.data = new ArrayList<>();
        this.capacity = capacity;
    }

    public void add(Pet pet){
        if(capacity > data.size()){
            data.add(pet);
        }
    }
    public boolean remove(String name){
        int index = -1;
        for (int i = 0; i < this.data.size(); i++) {
            if(data.get(i).getName().equals(name)){
                index =i;
            }
        }
        if(index != -1){
            this.data.remove(index);
            return true;
        } else{
            return false;
        }
    }

    public Pet getPet(String name, String owner){
        for (Pet pet : data) {
            if(pet.getName().equals(name) && pet.getOwner().equals(owner)){
                return pet;
            }
        }
        return null;
    }
    public Pet getOldestPet(){
        return this.data.stream()
                .max(Comparator.comparing(Pet::getAge))
                .orElse(null);
    }

    public int getCount(){
        return this.data.size();
    }

    public String getStatistics(){
        StringBuilder build = new StringBuilder("The clinic has the following patients:" + System.lineSeparator());
        for (Pet pet : data) {
            build.append(pet.getName() + " " + pet.getOwner() + System.lineSeparator());
        }
        return build.toString().trim();
    }

}
