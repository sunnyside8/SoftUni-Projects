package com.example.football.models.dto.XMLDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "players")
@XmlAccessorType(XmlAccessType.FIELD)
public class PlayerSeedRootDto {

    @XmlElement(name = "player")
    private List<PlayerSeedDto> players;

    public List<PlayerSeedDto> getPlayers() {
        return players;
    }

    public void setPlayers(List<PlayerSeedDto> players) {
        this.players = players;
    }
}
