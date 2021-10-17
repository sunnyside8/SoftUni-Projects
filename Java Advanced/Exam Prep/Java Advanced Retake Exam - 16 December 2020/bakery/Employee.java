package bakery;

public class Employee {
    public String name;
    public int age;
    public String country;

    public Employee(String name, int age, String country) {
        this.name = name;
        this.age = age;
        this.country = country;
    }

    @Override
    public String toString() {
        return String.format("Employee: %s, %d (%s)",this.name,this.age,this.country);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCountry() {
        return country;
    }
}
