import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void bookTaxi(int customerID,char pickupPoint,char dropPoint,int pickupTime,List<Taxi> freeTaxis)
    {
        int min=999;
        int distanceBtwPickupAndDrop=0;
        int earning=0;
        int nextFreeTime=0;
        char nextSpot='Z';
        Taxi bookedTaxi=null;
        String tripDetail="";

        for(Taxi tt:freeTaxis)
        {
            int distanceBtwCurrentAndPickup = Math.abs((tt.currentSpot-'0') - (pickupPoint-'0'))*15;
            if(distanceBtwCurrentAndPickup < min)
            {
                distanceBtwPickupAndDrop=Math.abs((dropPoint-'0')-(pickupPoint-'0'))*15;

                earning=(distanceBtwPickupAndDrop-5)*10 + 100;

                int dropTime=pickupTime + distanceBtwPickupAndDrop/15;

                nextFreeTime=dropTime;
                nextSpot=dropPoint;

                bookedTaxi=tt;

                tripDetail=customerID + "            " + customerID + "          " + pickupPoint +  "      " + dropPoint + "       " + pickupTime + "          " +dropTime + "           " + earning;

                min=distanceBtwCurrentAndPickup;
            }
        }
        bookedTaxi.setDetails(nextSpot,nextFreeTime, bookedTaxi.totalearnings+earning,tripDetail);
        System.out.println("Taxi "+bookedTaxi.id+" Booked.Yay!");
    }

    public static List<Taxi> getFreeTaxis(List<Taxi> taxis,char pickupPoint,int pickupTime)
    {
        List<Taxi> freeTaxis=new ArrayList<Taxi>();
        for(Taxi tt:taxis)
        {
            if(tt.freetime <= pickupTime && (Math.abs((tt.currentSpot-'0')-(pickupPoint-'0'))<=pickupTime- tt.freetime))
            {
                freeTaxis.add(tt);
            }
        }
        return freeTaxis;
    }


    public static void main(String[] args)
    {
        int n=4;
        int customerID=1;
        List<Taxi> taxis=new ArrayList<Taxi>();
        for (int i = 1; i <= n; i++)
        {
            Taxi tt=new Taxi();
            taxis.add(tt);
        }

        Scanner sc=new Scanner(System.in);
        while(true)
        {
            System.out.println("1.Book_Taxi   2.Print_Details   3.Exit \n Enter Choice : ");
            int ch= sc.nextInt();

            switch (ch)
            {
                case 1:
                {
                    System.out.println("Enter Pick Up Point : ");
                    char pickupPoint=sc.next().charAt(0);
                    System.out.println("Enter Drop Point : ");
                    char dropPoint=sc.next().charAt(0);
                    System.out.println("Enter Pick Up Time : ");
                    int pickupTime=sc.nextInt();

                   /* if(pickupPoint<'A' || pickupPoint>'E' || dropPoint>'A'|| dropPoint<'E')
                    {
                        System.out.println("Valid PickUp and Drop Pints are: A,B,C,D and E");
                        return;
                    }

                    */

                    List<Taxi> freeTaxis=getFreeTaxis(taxis,pickupPoint,pickupTime);

                    if(freeTaxis.size() == 0)
                    {
                        System.out.println("No Taxis are Available at the specified Time");
                        return;
                    }

                    Collections.sort(freeTaxis,(a,b)->a.totalearnings-b.totalearnings);

                    bookTaxi(customerID,pickupPoint,dropPoint,pickupTime,freeTaxis);
                    customerID++;

                    break;
                }
                case 2:
                {
                    for(Taxi tt : taxis)
                        tt.printDetails();
                    for (Taxi tt : taxis)
                        tt.print();
                    break;
                }
                case 3:
                {
                    System.out.println("Program Exit");
                    return;
                }
                default:
                {
                    System.out.println("Enter Valid Choice ");
                    break;
                }
            }
        }
    }
}