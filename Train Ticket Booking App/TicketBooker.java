import java.util.*;

public class TicketBooker
{
    static int availableUpperBerths=1;
    static int availableMiddleBerths=1;
    static int availableLowerBerths=1;
    static int availableRacBerths=1;
    static int availableWaitingList=1;

    static Queue<Integer> waitingList=new LinkedList<>();
    static  Queue<Integer> racList=new LinkedList<>();
    static  List<Integer> bookedList=new ArrayList<>();

    static  List<Integer> lowerBerthPositions=new ArrayList<>(Arrays.asList(1));
    static  List<Integer> middleBerthPositions=new ArrayList<>(Arrays.asList(1));
    static List<Integer> upperBerthPositions=new ArrayList<>(Arrays.asList(1));
    static  List<Integer> racBerthPositions=new ArrayList<>(Arrays.asList(1));
    static  List<Integer> waitingListPositions=new ArrayList<>(Arrays.asList(1));

    static Map<Integer, Passenger> passengers=new HashMap<>();

    public void bookticket(Passenger p)
    {
        if(availableWaitingList == 0) {
            System.out.println("No Tickets Available");
            return;
        }

        if( (p.berthPreference.equals("L") && availableLowerBerths>0) ||
                (p.berthPreference.equals("M") && availableMiddleBerths>0) ||
                (p.berthPreference.equals("U") && availableUpperBerths>0) )
        {
            System.out.println("Preferred Berth Availabe ");

            if (p.berthPreference.equals("L"))
            {
                book(p,lowerBerthPositions.get(0),"L");
                lowerBerthPositions.remove(0);
                availableLowerBerths--;

                System.out.println("Lower Berth Alloted");
            }
            if (p.berthPreference.equals("M"))
            {
                book(p,middleBerthPositions.get(0),"M");
                middleBerthPositions.remove(0);
                availableMiddleBerths--;

                System.out.println("Middle Berth Alloted");
            }
            if (p.berthPreference.equals("U"))
            {
                book(p,upperBerthPositions.get(0),"U");
                upperBerthPositions.remove(0);
                availableUpperBerths--;

                System.out.println("Upper Berth Alloted");
            }
        }
        else if (availableLowerBerths>0)
        {
            book(p,lowerBerthPositions.get(0),"L");
            lowerBerthPositions.remove(0);
            availableLowerBerths--;

            System.out.println("Lower Berth Alloted");
        }
        else if (availableMiddleBerths>0)
        {
            book(p,middleBerthPositions.get(0),"M");
            middleBerthPositions.remove(0);
            availableMiddleBerths--;

            System.out.println("Middle Berth Alloted");
        }
        else if (availableUpperBerths>0)
        {
            book(p,upperBerthPositions.get(0),"U");
            upperBerthPositions.remove(0);
            availableUpperBerths--;

            System.out.println("Upper Berth Alloted");
        }
        else if (availableRacBerths>0)
        {
            System.out.println("RAC Available");
            addToRAC(p,racBerthPositions.get(0),"RAC");
        }
        else if (availableWaitingList>0)
        {
            System.out.println("Added to Waiting List");
            addToWaitingList(p,waitingListPositions.get(0),"WL");
        }
    }

    public void book(Passenger p,int seatnumber,String allotedberth)
    {
        p.seatnumber=seatnumber;
        p.allotedBerth=allotedberth;

        passengers.put(p.passengerID,p);
        bookedList.add(p.passengerID);

        System.out.println("......................Ticket BOOKED Successfully");
    }

    public void addToRAC(Passenger p,int seatnumber,String racBerth)
    {
        p.seatnumber=seatnumber;
        p.allotedBerth=racBerth;

        passengers.put(p.passengerID,p);
        racList.add(p.passengerID);

        System.out.println("......................Ticket added to RAC List");

        racBerthPositions.remove(0);
        availableRacBerths--;
    }

    public void addToWaitingList(Passenger p,int waitnumber,String waitinfo)
    {
        p.seatnumber=waitnumber;
        p.allotedBerth=waitinfo;

        passengers.put(p.passengerID,p);
        waitingList.add(p.passengerID);

        System.out.println("......................Ticket added to WAITING LIST");

        waitingListPositions.remove(0);
        availableWaitingList--;
    }

    public void cancelTicket(int pid)
    {
        if(! passengers.containsKey(pid))
        {
            System.out.println("Passenger ID unavailable");
            return;
        }

        Passenger p=passengers.get(pid);
        passengers.remove(Integer.valueOf(pid));
        bookedList.remove(Integer.valueOf(pid));

        int bookedposition=p.seatnumber;

        if (p.allotedBerth.equals("L"))
        {
            lowerBerthPositions.add(bookedposition);     //p.seatno or bookedposition
            availableLowerBerths++;
        }
        if (p.allotedBerth.equals("M"))
        {
            middleBerthPositions.add(bookedposition);
            availableMiddleBerths++;
        }
        if (p.allotedBerth.equals("U"))
        {
            upperBerthPositions.add(bookedposition);
            availableUpperBerths++;
        }

        System.out.println("............Ticket Cancelled Successfully");

        if (racList.size() > 0)
        {
            Passenger passengerfromRAC = passengers.get(racList.poll());

            int racPosition=passengerfromRAC.seatnumber;
            racBerthPositions.add(racPosition);

            racList.remove(Integer.valueOf(passengerfromRAC.passengerID));
            availableRacBerths++;

            if(waitingList.size() > 0)
            {
                Passenger passengerfromWL = passengers.get(waitingList.poll());

                int wlPosition = passengerfromWL.seatnumber;
                waitingListPositions.add(wlPosition);

                waitingList.remove(Integer.valueOf(passengerfromWL.passengerID));
                availableWaitingList++;
                availableRacBerths--;

                passengerfromWL.seatnumber= racBerthPositions.get(0); // or passengerfromRAC.seatnumber
                passengerfromWL.allotedBerth="RAC";

                racBerthPositions.remove(0);
                racList.add(passengerfromWL.passengerID);
            }

            bookticket(passengerfromRAC);
        }
    }

    public void printAvailable()
    {
        System.out.println("Available Upper Berths       : "+ availableUpperBerths);
        System.out.println("Available Middle Berths      : "+ availableMiddleBerths);
        System.out.println("Available Lower Berths       : "+ availableLowerBerths);
        System.out.println("Available RAC Tickets        : "+ availableRacBerths);
        System.out.println("Available Waiting List seats : "+ availableWaitingList);
        System.out.println("-----------------------------------------------");
    }

    public void printPassengers()
    {
        if (passengers.size() == 0)
        {
            System.out.println("No Passenger Details Available");
            return;
        }
        for (Passenger p : passengers.values())
        {
            System.out.println("Passenger ID : "+p.passengerID);
            System.out.println("Name         : "+p.name);
            System.out.println("Age          : "+p.age);
            System.out.println("Status       : "+p.seatnumber+p.allotedBerth);
            System.out.println("------------------------------------------------");
        }
        /*
        for(int i : bookedList)
        {
            Passenger p=passengers.get(i);
            System.out.println("Passenger ID : "+p.passengerID);
            System.out.println("Name : "+p.name);
            System.out.println("Age          : "+p.age);
            System.out.println("Status       : "+p.seatnumber+p.allotedBerth);
            System.out.println("------------------------------------------------");
        }*/
    }
}
