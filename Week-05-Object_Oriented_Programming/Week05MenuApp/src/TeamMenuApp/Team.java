package TeamMenuApp;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private List<Player> players = new ArrayList<Player>();
    private String name;

    public Team(String name) {
        this.name = name;
    }

    public void describe() {
        System.out.println("Team Name: " + name);
        for (Player player : players) {
            player.describe();
        }
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void removePlayer(String playerName) {
        for (Player player : players) {
            if (player.getName().equals(playerName)) {
                players.remove(player);
            }
        }
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}
