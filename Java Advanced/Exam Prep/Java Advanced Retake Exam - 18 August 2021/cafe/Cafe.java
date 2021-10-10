package cafe;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Cafe {
    private List<Employee> employees;
    private String name;
    private int capacity;

    public Cafe(String name, int capacity) {
        this.employees = new ArrayList<>();
        this.name = name;
        this.capacity = capacity;
    }

    public void addEmployee(Employee employee) {
        if (employees.size() < capacity) {
            employees.add(employee);
        }
    }

    public boolean removeEmployee(String name) {
        int index = findIndex(name);
        if (index != -1) {
            employees.remove(index);
            return true;
        }
        return false;
    }

    public Employee getOldestEmployee(){
        Employee employee = this.employees
                .stream()
                .max(Comparator.comparing(Employee::getAge))
                .orElse(null);
        return employee;
    }

    public Employee getEmployee(String name){
        int index = findIndex(name);
        Employee employee = employees.get(index);
        return employee;
    }

    public int getCount(){
        return employees.size();
    }

    public String report(){
        StringBuilder build = new StringBuilder("Employees working at Cafe "+ this.name + ":" + System.lineSeparator());
        for (Employee employee : employees) {
            build.append(employee + System.lineSeparator());
        }
        return build.toString().trim();
    }
    private int findIndex(String name) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }
}
