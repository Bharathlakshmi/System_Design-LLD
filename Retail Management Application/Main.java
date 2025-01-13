import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args)
    {
        int ch1,ch2;
        int b=1;
        int id;
        int stocknum=1;

        ArrayList<Stock> stocks=new ArrayList<Stock>();
        ////stocks.add(new Stock());

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter User(admin=1/cashier=2) : ");
        int user=sc.nextInt();
        if(user==1)
        {
            System.out.println("1.Login  2.Register : ");
            int lr= sc.nextInt();
            if (lr==1)
            {
                System.out.println("User Name : ");
                String uname=sc.next();
                System.out.println("Password : ");
                String pwd=sc.next();

                User u=new User();
                boolean boole=u.checkAdmin(uname,pwd);
                if (boole==false)
                    System.exit(0);

            }
            else if (lr==2)
            {
                System.out.println("Enter User Name : ");
                String uname=sc.next();
                System.out.println("Create Password : ");
                String pwd=sc.next();

                User u=new User();
                u.addAdmin(uname,pwd);

                System.out.println("Enter Login credentials to continue ");
                System.out.println("User Name : ");
                String uname1=sc.next();
                System.out.println("Password : ");
                String pwd1=sc.next();


                boolean boole=u.checkAdmin(uname1,pwd1);
                if (boole==false)
                    System.exit(0);
            }
            else {
                System.out.println("Invalid Choice");
                System.exit(0);
            }


            do{
                System.out.println("\n1.Stock 2.Discount 3.Sale 4.Report 5.Customer 6.Supplier : ");
                ch1=sc.nextInt();
                switch (ch1) {
                    case 1:
                    {
                        System.out.println("1.Add 2.Update 3.View : ");
                        ch2=sc.nextInt();
                            if(ch2==1)
                            {
                                Stock sto =new Stock();
                                sto.addnew();
                                stocks.add(sto);
                            }
                            else if (ch2==2) {
                                System.out.println("Enter Product ID : ");
                                id = sc.nextInt();
                                /// ///////////////////////////////////
                                //if(id>stocks.size())
                                  //  System.out.println("invalid Product id");

                                for (Stock s : stocks) {
                                    if (s.productID == id) {
                                        s.updateStock();
                                        break;
                                    }
                                }

                            }
                            else if(ch2==3){
                                System.out.println("Displaying Stock Information : ");

                                for (Stock s : stocks) {
                                    if(stocks.isEmpty())
                                        System.out.println("No Stocks to Display");

                                    s.viewStock();
                                    break;
                                }
                            }
                            else
                                System.out.println("Invalid choice");

                        break;
                    }
                    case 2:{
                        System.out.println("Enter Product ID to Create Discount : ");
                        id= sc.nextInt();
                        /// ////////////////
                        for(Stock s : stocks)
                        {
                            if(s.productID==id)
                            {
                                s.createDiscount();
                                s.applyDiscount();
                                break;
                            }
                        }
                        break;
                    }
                    case 3:{
                        Invoice i=new Invoice();
                        i.invoiceGeneration(stocks);
                        break;
                    }
                }
            }while(ch1<=7);
        }
        else if(user==2)
        {
            do {
                System.out.println("1.View Stock  2.Sale : ");
                ch1 = sc.nextInt();
                switch (ch1) {
                    case 1: {
                        for (Stock s : stocks) {
                            System.out.println("Displaying Stock Information : ");
                            s.viewStock();
                            break;
                        }
                        break;
                    }
                    case 2: {
                        Invoice i=new Invoice();
                        i.invoiceGeneration(stocks);
                        break;
                    }
                    default:
                        break;
                }
            }while (ch1>=3);
        }
        else
        {
            System.out.println("Warning : Enter valid User to login");
        }
    }
}