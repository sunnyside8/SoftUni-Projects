package softuni.exam.models.entity;

import softuni.exam.models.enums.Rating;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
@Table(name = "sellers")
public class Seller extends BaseEntity{

    @Column(name = "first_name")
    @Size(min = 2,max = 19)
    private String firstName;

    @Column(name = "last_name")
    @Size(min = 2,max = 19)
    private String lastName;

    @Email
    @Column(unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    private Rating rating;

    @Column(nullable = false)
    private String town;


    public Seller() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }
}
