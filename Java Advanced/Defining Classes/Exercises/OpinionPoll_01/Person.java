package OpinionPoll_01;

public class Person {
    private String name;
    private int age;


    public Person(String name,int age){
        this.name = name;
        this.age = age;

    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
    @Override
    public String toString(){
        return String.format("%s - %d%n",this.name,this.age);
    }
}
