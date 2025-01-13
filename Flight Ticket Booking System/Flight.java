import java.util.ArrayList;
import java.util.Arrays;

public class Flight {
    static int id=0;

    int seatno=1;

    int flightID;
    int price;
    int tickets;

    ArrayList<String>passengerName;
    ArrayList<Integer>passengerID;
    ArrayList<Integer>ticketsperpassenger;
    ArrayList<Integer>passengerCost;
    ArrayList<ArrayList<Integer>> seatnos;

    //constructor
    public Flight()
    {
        tickets=50;
        price=5000;
        id=id+1;
        flightID=id;
        seatno=1;

        passengerName=new ArrayList<String>();
        ticketsperpassenger=new ArrayList<Integer>();
        passengerID=new ArrayList<Integer>();
        passengerCost=new ArrayList<Integer>();
        seatnos=new ArrayList<ArrayList<Integer>>();
    }

    public void addPassengerDetails(String name,int nooftickets,int pid)
    {
        if(nooftickets>tickets)
        {
            System.out.println("Only "+ tickets +" tickets available for this Flight");
           // nooftickets=tickets;
            return;
        }
        passengerName.add(name);
        passengerID.add(pid);

        tickets-=nooftickets;
        ticketsperpassenger.add(nooftickets);

        ArrayList<Integer>seats = new ArrayList<Integer>();
        //int temp=seatno+nooftickets;
        for (int i=seatno ; i < (seatno+nooftickets); i++) {
            seats.add(i);
        }
        seatnos.add(seats);

       // int num=passengerName.indexOf(name);
       // for(int i=0; i<nooftickets ;i++)
        //  seatnos.get(num).addAll(Arrays.asList(seatno));
        seatno=seatno+nooftickets;
        passengerCost.add(nooftickets*price);
        price = (200 * nooftickets) + price;
        System.out.println(nooftickets + " Tickets Booked Successfully");
    }

    public void cancelTicket(int pid)
    {
       int indextoremove = passengerID.indexOf(pid);
       if(indextoremove < 0)
       {
           System.out.println("Passenger ID not found!");
           return;
       }
       int ticketstocancel=ticketsperpassenger.get(indextoremove);
       tickets += ticketstocancel;
       price = price - (200 * ticketstocancel);

       System.out.println("Refund Amount : "+ passengerCost.get(indextoremove));
        passengerName.remove(indextoremove);
        passengerID.remove(indextoremove);
        passengerCost.remove(indextoremove);
        ticketsperpassenger.remove(indextoremove);
        seatnos.remove(indextoremove);

        System.out.println("Tickets Cancelled Successfully");
    }

    public void flightSummary()
    {
        if(tickets<=0)
        {
            System.out.println("Flight ID : "+flightID+" || Remaining Tickets: 0");
            return;
        }
        else
        {
            System.out.println("Flight ID : "+flightID+"|| Remaining Tickets: "+tickets+"||Ticket Price : "+price);
        }
    }

    public void printDetails()
    {
        System.out.println("---------------------------------------");
        System.out.println("Flight ID : "+flightID+"-->");
        for (int i = 0; i < passengerName.size(); i++)
        {
            System.out.println("---------------------------------------");
            System.out.println("Name : " + passengerName.get(i));
            System.out.println("Passenger ID : " + passengerID.get(i));
            System.out.println("Number of Tickets Booked : " + ticketsperpassenger.get(i));
            System.out.println("Total cost : " + passengerCost.get(i));
            System.out.println("Seat Numbers : " + seatnos.get(i));
        }

    }
}
