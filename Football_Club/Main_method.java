package Football_Club;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Main_method {

    ArrayList<Footballer> footballers = new ArrayList<Footballer>();

    public void getAllPlayers() {
        footballers.forEach(Player -> Player.show());

    }

    public void getPlayers(String clubName) {
        for (Footballer player : footballers) {
            if (player.clubName.equals(clubName))
                player.show();
        }
        // this.footballers.forEach(Player -> {
        // if (Player.clubName.equals(clubName))
        // Player.show();
        // });
    }

    public String getString(String message) {
        return JOptionPane.showInputDialog(message);
    }

    public int getInt(String message) {
        return Integer.parseInt(JOptionPane.showInputDialog(message));
    }

    public void newPlayer() {

        NewPlayer Player = new NewPlayer(getString("Name"), getString("Surname"), getInt("Birth Year"),
                getString("Preferred Foot"));

        Player.setFootballClub(getString("Club Name"));
        Player.setPosition("Position");

        this.footballers.add(Player);

        JOptionPane.showMessageDialog(null, "Player Added");

    }

    public static void main(String[] args) {
        Main_method obj = new Main_method();

        obj.newPlayer();
        // obj.newPlayer();

        obj.getAllPlayers();
        System.out.println("***************");
        obj.getPlayers("Tommy");

    }

}
