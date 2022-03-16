package com.example.springmappingobjectsex.models.entities;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "users")
public class User extends BaseEntity{

    @Column(unique = true)
    private String email;
    private String password;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "is_admin")
    private boolean isAdmin;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Game> games;

    public User() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public Set<Game> getGames() {
        return games;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }
}
