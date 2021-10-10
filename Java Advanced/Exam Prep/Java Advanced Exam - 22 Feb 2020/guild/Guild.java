package guild;

import java.util.ArrayList;
import java.util.List;

public class Guild {
    private List<Player> roster;
    private String name;
    private int capacity;

    public Guild(String name, int capacity) {
        this.roster = new ArrayList<>();
        this.name = name;
        this.capacity = capacity;

    }

    public void addPlayer(Player player) {
        if (this.roster.size() < this.capacity) {
            this.roster.add(player);
        }
    }

    public int count() {
        return this.roster.size();
    }

    public boolean removePlayer(String name) {
        int index = findPlayerIndex(name);
        if (index != -1) {
            roster.remove(index);
            return true;
        }
        return false;
    }

    public void promotePlayer(String name) {
        int index = findPlayerIndex(name);
        if(index != -1) {
            roster.get(index).setRank("Member");
        }
    }

    private int findPlayerIndex(String name) {
        for (int i = 0; i < roster.size(); i++) {
            if (roster.get(i).getName().equals(name)) {
                roster.get(i).setRank("Member");
                return i;
            }
        }
        return -1;
    }
    public void demotePlayer(String name) {
        int index = findPlayerIndex(name);
        if(index != -1) {
            roster.get(index).setRank("Trial");
        }
    }

    public Player[] kickPlayersByClass(String clazz){
       int count = 0;
        for (Player player : roster) {
            if(player.getClazz().equals(clazz)){
                count+=1;
            }
        }
        Player[] arr = new Player[count];
        int index = 0;
        for (Player player : roster) {
            if(player.getClazz().equals(clazz)){
                arr[index++] = player;
            }
        }
        for (Player player : arr) {
            roster.remove(player);
        }
        return arr;

    }
    public String report(){
        StringBuilder builder = new StringBuilder("Players in the guild: " + name + ":"
         + System.lineSeparator());
        for (Player player : roster) {
            builder.append(player.toString())
                    .append(System.lineSeparator());
        }

        return builder.toString().trim();
    }


}
