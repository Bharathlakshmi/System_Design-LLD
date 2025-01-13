import java.util.ArrayList;
import java.util.List;

public class Taxi
{
    static int taxicount=0;

    int id;
    char currentSpot;
    int freetime;
    int totalearnings;
    List<String> trips;

    public Taxi()
    {
        currentSpot='A';
        freetime=6;
        totalearnings=0;
        trips=new ArrayList<String>();
        taxicount=taxicount+1;
        id=taxicount;
    }

    public void setDetails(char currentSpot,int freetime,int totalearnings,String tripdetail)
    {
        this.currentSpot=currentSpot;
        this.freetime=freetime;
        this.totalearnings=totalearnings;
        trips.add(tripdetail);
    }

    public void printDetails()
    {
        System.out.println("TaxiID   BookingID   CustomerID    From   To   PickupTime   DropTime    Amount");
        for(String t : trips)
        {
            System.out.println(" "+id+"          "+t);
        }
        System.out.println("----------------------------------------------------------------------------------");
    }

    public void print()
    {
        System.out.println("TaxiID - "+this.id+"; TotalEarning - "+this.totalearnings+"; CurrentSpot - "+this.currentSpot+"; FreeTime - "+this.freetime);
    }
}
