package bakery;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Bakery {
    public List<Employee> employees;
    public String name;
    public int capacity;

    public Bakery(String name, int capacity) {
        this.employees = new ArrayList<>();
        this.name = name;
        this.capacity = capacity;
    }

    public void add(Employee employee){
        if(employees.size() < capacity){
            employees.add(employee);
        }
    }
    public boolean remove(String name){
        int index = findIndex(name);
        if(index == -1){
            return false;
        } else{
            employees.remove(index);
            return true;
        }
    }
    public Employee getOldestEmployee(){
        return employees.stream()
                .max(Comparator.comparing(Employee::getAge))
                .orElse(null);
    }

    public Employee getEmployee(String name){
        for (Employee employee : employees) {
            if(employee.getName().equals(name)){
                return employee;
            }
        }
        return null;
    }

    public int getCount(){
        return employees.size();
    }
    public String report(){
        StringBuilder build = new StringBuilder("Employees working at Bakery " + this.name +  ":" + System.lineSeparator());
        for (Employee employee : employees) {
            build.append(employee + System.lineSeparator());
        }
        return build.toString().trim();
    }


    private int findIndex(String name) {
        int index = -1;
        for (int i = 0; i < employees.size(); i++) {
            if(employees.get(i).getName().equals(name)){
                index = i;
                break;
            }
        }
        return index;
    }

}
