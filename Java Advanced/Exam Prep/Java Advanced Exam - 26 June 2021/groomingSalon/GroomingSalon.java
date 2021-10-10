package groomingSalon;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {
    private List<Pet> pets;
    private int capacity;

    public GroomingSalon(int capacity) {
        this.pets = new ArrayList<>();
        this.capacity = capacity;
    }

    public void add(Pet pet) {
        if (pets.size() < capacity) {
            pets.add(pet);
        }
    }

    public boolean remove(String name) {
        int index = findIndex(name);
        if(index != -1){
            pets.remove(index);
            return true;
        }
        return false;
    }
    public Pet getPet(String name, String owner){
        for (Pet pet : pets) {
            if(pet.getName().equals(name) && pet.getOwner().equals(owner)){
                return pet;
            }
        }
        return null;
    }
    public int getCount(){
        return pets.size();
    }

    public String getStatistics(){
        StringBuilder build = new StringBuilder(" The grooming salon has the following clients:" + System.lineSeparator());
        for (Pet pet : pets) {
            build.append(pet.getName() +" "+pet.getOwner() + System.lineSeparator() );
        }
        return build.toString().trim();
    }

    private int findIndex(String name) {
        for (int i = 0; i <pets.size(); i++) {
            if (pets.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;

    }
}
