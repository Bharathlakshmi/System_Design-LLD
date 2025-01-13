import java.util.ArrayList;
import java.util.Scanner;

public class Invoice {

    ArrayList<Integer>pid;
    ArrayList<Integer>q;
    //double perprice;
    double discprice;
    double total=0;


    public void invoiceGeneration(ArrayList<Stock> stocks)
    {
        pid=new ArrayList<Integer>();
        q=new ArrayList<Integer>();

        Scanner sc=new Scanner(System.in);
        System.out.println("Sales Data-Enter number of products sold: ");
        int n=sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter Product ID : ");
            pid.add(sc.nextInt());
            System.out.println("Enter Quantity : ");
            q.add(sc.nextInt());
        }

        System.out.println("Invoice Generated : ");
        System.out.println("SNo" + " Product" + " " + "Price Quantity Discount(%) Discount_Price");
        int c=1;
        for (int i = 0; i < n; i++)
        {
            for (Stock z : stocks) {
                if (z.productID == pid.get(i)) {

                    if(z.discountpercent>0.0)
                      discprice = z.discountprice*(q.get(i));
                    else
                        discprice = z.price*(q.get(i));

                    System.out.println(q.get(i));
                    System.out.println(c++ + ". " + z.name + "  ;   " + z.price + "  ;   " + q + "  ;   " +
                            z.discountpercent + "  ;   " + discprice);
                    total += discprice;
                    System.out.println("Total Price : "+total);
                    break;
                }
            }
        }

    }

}
