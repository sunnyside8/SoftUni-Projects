package com.example.demo.model.binding;

import javax.validation.constraints.NotNull;

public class BattleBindingModel {

    @NotNull
    private String attacker;

    @NotNull
    private String defender;

    public String getAttacker() {
        return attacker;
    }

    public BattleBindingModel setAttacker(String attacker) {
        this.attacker = attacker;
        return this;
    }

    public String getDefender() {
        return defender;
    }

    public BattleBindingModel setDefender(String defender) {
        this.defender = defender;
        return this;
    }
}
