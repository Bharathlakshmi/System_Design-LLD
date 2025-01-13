public class Passenger {
    static int id=1;

    String name;
    int age;
    int passengerID;
    String berthPreference;
    String allotedBerth;
    int seatnumber;

    public Passenger(String name,int age,String berthpref)
    {
        this.name=name;
        this.age=age;
        this.berthPreference=berthpref;

        passengerID = id++;
        allotedBerth="";
        seatnumber=-1;
    }
}
