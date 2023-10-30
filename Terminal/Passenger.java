public class Passenger {
    int Passengersid;
    String Name, Surname;

    Tickets t1;

    public Passenger(int Passengersid, String Name, String Surname) {
        this.Passengersid = Passengersid;
        this.Name = Name;
        this.Surname = Surname;
    }

    public void setTicket(Tickets t1) {
        this.t1 = t1;
    }

}
