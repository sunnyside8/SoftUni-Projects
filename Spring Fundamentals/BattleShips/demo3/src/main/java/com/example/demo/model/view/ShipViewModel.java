package com.example.demo.model.view;

public class ShipViewModel {

    private String name;
    private Long health;
    private Long power;

    public ShipViewModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getHealth() {
        return health;
    }

    public void setHealth(Long health) {
        this.health = health;
    }

    public Long getPower() {
        return power;
    }

    public void setPower(Long power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
