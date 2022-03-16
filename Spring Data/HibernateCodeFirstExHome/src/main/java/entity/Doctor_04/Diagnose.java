package entity.Doctor_04;

import entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table
public class Diagnose extends BaseEntity {

    private String name;
    private String comment;
    private Set<Patient> patients;

    public Diagnose() {
    }

    public Diagnose(String name) {
        this.name = name;
    }

    public Diagnose(String name, String comment) {
        this.name = name;
        this.comment = comment;
    }

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(columnDefinition = "TEXT")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @ManyToMany(mappedBy = "diagnoses")
    public Set<Patient> getPatients() {
        return patients;
    }

    public void setPatients(Set<Patient> patients) {
        this.patients = patients;
    }

    @Override
    public String toString() {
        return "Diagnose{" +
                "name='" + name + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
