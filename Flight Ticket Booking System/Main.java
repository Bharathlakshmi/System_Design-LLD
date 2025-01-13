//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int ch;
        int pID = 1;
        ArrayList<Flight> flights = new ArrayList<Flight>();
        for (int i = 0; i < 2; i++) {
            flights.add(new Flight());
        }

        do {
            System.out.println(" 1.Book 2.Cancel 3.PrintDetails 4.Exit ");
            System.out.println("Enter the Choice : ");
            Scanner sc = new Scanner(System.in);
            ch = sc.nextInt();


            switch (ch) {
                case 1: {
                    System.out.println("Enter Flight ID (1/2) : ");
                    int fid = sc.nextInt();
                    if (fid > flights.size()) {
                        System.out.println("Warning : Invalid Flight ID");
                        break;
                    }
                    Flight currentflight = null;
                    for (Flight f : flights) {
                        if (f.flightID == fid) {
                            currentflight = f;
                            f.flightSummary();
                            break;
                        }
                    }
                    System.out.println("Enter Name : ");
                    String name = sc.next();
                    System.out.println("Enter No. of Tickets : ");
                    int t = sc.nextInt();

                    currentflight.addPassengerDetails(name,t,pID);
                    currentflight.flightSummary();
                  //  currentflight.printDetails();

                    pID += 1;
                    break;
                }
                case 2:
                {
                    System.out.println("Enter Flight ID : ");
                    int fid=sc.nextInt();
                    if(fid > flights.size()) {
                        System.out.println("Warning : Invalid Flight ID ");
                        break;
                    }
                    System.out.println("Enter Passenger ID : ");
                    int pid=sc.nextInt();

                    Flight currentflight=null;
                    for(Flight f : flights)
                    {
                        if (f.flightID == fid) {
                            currentflight = f;
                            break;
                        }
                    }

                    currentflight.cancelTicket(pid);
                    break;
                }
                case 3:
                {
                    for(Flight f : flights)
                    {
                        if(f.passengerName.size() == 0)
                        {
                            System.out.println("---------------------------------------");
                            System.out.println("No Passenger Details for - Flight "+ f.flightID);
                            System.out.println("---------------------------------------");
                        }
                        else
                            f.printDetails();
                    }
                    break;
                }
                case 4:
                    System.out.println("Program Exiting");
                    break;
                default:
                    System.out.println("Warning : Enter a Valid Choice");
            }
        } while (ch != 4);

    }
}
