package Football_Club;

public abstract class Footballer {

    String name;
    String surname;
    String clubName;
    String position;
    int BirthYear;

    public Footballer(String name, String surname, int birthYear) {
        this.name = name;
        this.surname = surname;
        BirthYear = birthYear;
    }

    // public void showInfo() {
    // System.out.println("Name: " + name);
    // System.out.println("Surname: " + surname);
    // System.out.println("Club Name: " + clubName);
    // System.out.println("Position: " + position);
    // System.out.println("Birth Year: " + BirthYear);
    // }

    public abstract void show();

    public abstract int getAge();

}
