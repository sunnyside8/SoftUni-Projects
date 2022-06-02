package com.example.pathfind.model.entity;

import com.example.pathfind.model.entity.enums.RolesNameEnum;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity{

    @Enumerated(EnumType.STRING)
    private RolesNameEnum role;

    public Role() {
    }

    public RolesNameEnum getRole() {
        return role;
    }

    public void setRole(RolesNameEnum role) {
        this.role = role;
    }
}
