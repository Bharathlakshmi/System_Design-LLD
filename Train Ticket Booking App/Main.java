import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args)
    {
        int ch;
        Scanner sc=new Scanner(System.in);
        boolean loop=true;
        while (loop)
        {
            System.out.println("1.Book  2.Cancel  3.Print_Booked   4.Print_Available  5.Exit");
            ch=sc.nextInt();
            switch (ch)
            {
                case 1:
                {
                    System.out.println("Enter Name : ");
                    String name=sc.next();
                    System.out.println("Enter age : ");
                    int age=sc.nextInt();
                    System.out.println("Enter Berth Preference : ");
                    String berthpref=sc.next();

                    Passenger p=new Passenger(name,age,berthpref);
                    TicketBooker b=new TicketBooker();
                    b.bookticket(p);
                    break;
                }
                case 2:
                {
                    System.out.println("Enter Passenger ID to cancel : ");
                    int id=sc.nextInt();

                    TicketBooker b=new TicketBooker();
                    b.cancelTicket(id);
                    break;
                }
                case 3:
                {
                    TicketBooker b=new TicketBooker();
                    b.printPassengers();
                    break;
                }
                case 4:
                {
                    TicketBooker b=new TicketBooker();
                    b.printAvailable();
                    break;
                }
                case 5:
                {
                    System.out.println("Program Exiting..");
                    loop=false;
                    break;
                }
                default:
                {
                    System.out.println("Enter Valid Choice");
                    break;
                }
            }
        }
    }
}