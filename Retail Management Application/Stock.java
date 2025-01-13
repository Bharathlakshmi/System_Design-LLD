import java.util.Scanner;

public class Stock
{
    static int sno=1;

    int stockno;
    int productID;
    String name;
    String catagory;
    int quantity;
    double price;

    double discountpercent;
    double discountprice;

    Stock()
    {
        stockno=sno;
        sno += 1;
    }

    public void addnew()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Product ID : ");
        productID=sc.nextInt();
        System.out.println("Enter Product Name : ");
        name=sc.next();
        System.out.println("Enter Catagory : ");
        catagory=sc.next();
        System.out.println("Enter Quantity : ");
        quantity=sc.nextInt();
        System.out.println("Enter Price : ");
        price=sc.nextDouble();

        System.out.println("Stock Created Successfully ");
    }

    public void viewStock()
    {
        System.out.println("Product ID:"+productID+" ,Name: "+name+" ,Catagory:"+catagory+" ,Quantity:"+quantity+", Price:"+price);
    }

    public void updateStock()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter new Quantity(kg) : ");
        quantity=sc.nextInt();
        System.out.println("Enter new Price : ");
        price=sc.nextDouble();

        System.out.println("Quantity and Price updated Successfully");
    }

    public void createDiscount()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Discount Percentage : ");
        discountpercent=sc.nextDouble();

        System.out.println("Discount Created Successfully");
        viewStock();
        System.out.println("Discount % : "+discountpercent);
    }

    public void applyDiscount()
    {
        discountprice=(discountpercent/100)*price;
        discountprice=price-discountprice;
        System.out.print(" Discount Price: "+discountprice);
    }
}
