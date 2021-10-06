package CompanyRoster_02;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private List<Employee> employees;
    private String name;

    public Department(String name) {
        this.name = name;
        employees = new ArrayList<>();
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public double calculateAverageSalary(){
        return this.employees.stream().mapToDouble(Employee::getSalary).average().orElse(0.0);
    }

    public String getName() {
        return name;
    }
}
