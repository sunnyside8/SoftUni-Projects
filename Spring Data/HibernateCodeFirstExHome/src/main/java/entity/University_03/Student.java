package entity.University_03;

import entity.University_03.Course;
import entity.User;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "students")
public class Student extends User {

    private Float avgGrade;
    private Integer attendance;
    private Set<Course> courses;


    public Student() {
    }

    @Column(name = "avg_grade")
    public Float getAvgGrade() {
        return avgGrade;
    }

    public void setAvgGrade(Float avgGrade) {
        this.avgGrade = avgGrade;
    }

    @Column
    public Integer getAttendance() {
        return attendance;
    }

    public void setAttendance(Integer attendance) {
        this.attendance = attendance;
    }

    @ManyToMany(mappedBy = "students")
    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }


}
