package entity.Doctor_04;

import entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table
public class Medicament extends BaseEntity {

    private String name;
     private Set<Patient> patients;

    public Medicament() {
    }

    public Medicament(String name) {
        this.name = name;
    }

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "medicaments")
    public Set<Patient> getPatients() {
        return patients;
    }

    public void setPatients(Set<Patient> patients) {
        this.patients = patients;
    }

    @Override
    public String toString() {
        return "Medicaments{" +
                "name='" + name + '\'' +
                '}';
    }
}
