import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User
{
     static List<String> adminsName=new ArrayList<>();
     static List<String> adminsPwd=new ArrayList<>();

     Map<String,String> admins=new HashMap<>();

     static List<String> cashiersName=new ArrayList<>();
     static List<String> cashiersPwd=new ArrayList<>();

     Map<String,String> cashiers=new HashMap<>();

     public void addAdmin(String uname,String pwd)
     {
         if (admins.containsKey(uname)) {
             System.out.println("Username already exists");
             return;
         }
         admins.put(uname,pwd);
         System.out.println("Login Created successfully");
     }
     public boolean checkAdmin(String uname,String pwd)
     {
         if (admins.containsKey(uname))
         {
             String pwdcheck=admins.get(uname);
             if (pwd.equals(pwdcheck))
                 return true;
             else
             {
                 System.out.println("Password did not match!");
                 return false;}
         }
         else
         {
             System.out.println("Username does not exist");
             return false;
         }
     }
}
