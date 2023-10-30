package Football_Club;

import java.util.Calendar;

public class NewPlayer extends Footballer implements IFootballClub, IPosition {

    String preferredFoot;

    public NewPlayer(String name, String surname, int birthYear, String preferredFoot) {
        super(name, surname, birthYear);
        this.preferredFoot = preferredFoot;

    }

    @Override
    public void show() {
        System.out.println("Name: " + name);
        System.out.println("Surname: " + surname);
        System.out.println("Age: " + this.getAge());
        System.out.println("Preferred Foot: " + preferredFoot);

        this.getFootbackClub();
        this.getPosition();

    }

    @Override
    public int getAge() {

        return Calendar.getInstance().get(Calendar.YEAR) - this.BirthYear;
    }

    @Override
    public void setPosition(String position) {

        this.position = position;
    }

    @Override
    public void getPosition() {

        System.out.println("Position: " + position);
    }

    @Override
    public void setFootballClub(String clubName) {
        this.clubName = clubName;

    }

    @Override
    public void getFootbackClub() {
        System.out.println("Club Name: " + clubName);
    }

}