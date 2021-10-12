package university;

import java.util.ArrayList;
import java.util.List;

public class University {
    public int capacity;
    public List<Student> students;

    public University(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getStudents() {
        return students;
    }

    public int getStudentCount(){
        return students.size();
    }
     public String registerStudent(Student student){
        if(students.contains(student)){
            return "Student is already in the university";
        } else if (capacity <= students.size()){
            return "No seats in the university";
        } else {
            students.add(student);
            return String.format("Added student %s %s",student.getFirstName(),student.getLastName());
        }
     }
     public String dismissStudent(Student student){
        if(students.contains(student)){
            students.remove(student);
            return String.format("Removed student %s %s",student.getFirstName(),student.getLastName());
        }
        return "Student not found";
     }

     public Student getStudent(String firstName, String lastName){
         for (Student student : students) {
             if(student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)){
                 return student;
             }
         }
         return null;
     }
     public String getStatistics(){
        StringBuilder build = new StringBuilder();
         for (Student student : students) {
             build.append("==Student: First Name = " + student.getFirstName() + ", Last Name = " + student.getLastName()
             + ", Best Subject = " + student.getBestSubject() + System.lineSeparator());
         }
         return build.toString().trim();
     }
}
