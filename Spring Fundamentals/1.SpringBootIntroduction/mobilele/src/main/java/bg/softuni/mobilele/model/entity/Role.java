package bg.softuni.mobilele.model.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated
    @Column(nullable = false)
    private RoleEn name;

    @OneToMany(mappedBy = "role",cascade = CascadeType.ALL)
    private List<User> users;

    public RoleEn getName() {
        return name;
    }

    public void setName(RoleEn name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public Role setId(Long id) {
        this.id = id;
        return this;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}


