package learnbeforeearn;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



class AmanUsersList
{

    private List<AmanUsers> amanusers;


    public AmanUsersList()
    {
        this.amanusers = new ArrayList<>();
    }


    public void addUserToList(AmanUsers amanu)
    {
        amanusers.add(amanu);
        System.out.println("Successfuly added the user to the list");
    }

    public void displayAllUsers()
    {
        for(AmanUsers u: amanusers)
        {
            System.out.println(u);
        }
    }
}


class AmanUsers
{

    private static String name;
    private static int age;
    private static String city;
    private static String country;


    public AmanUsers(String name, int age, String city, String country)
    {
        AmanUsers.name = name;
        AmanUsers.age = age;
        AmanUsers.city = city;
        AmanUsers.country = country;
    }

    public static String getMyInfo()
    {
        return "name : " + name + " age : " + age + " city : " + city + " country : " + country;
    }


    @Override
    public String toString()
    {
        return "Hi nice to meet you and here are my details " + getMyInfo();
    }
}


public class Aman {

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the program where we will create some users!!");
        System.out.println("Enter user name : ");
        String name = input.nextLine();
        System.out.println("Enter user age : ");
        int age = Integer.parseInt(input.nextLine());
        System.out.println("Enter city name : ");
        String city = input.nextLine();
        System.out.println("Enter country name : ");
        String country = input.nextLine();
        AmanUsers aman = new AmanUsers(name,age,city,country);
        System.out.println("Adding data to user list!");
        AmanUsersList lists = new AmanUsersList();
        lists.addUserToList(aman);
        lists.displayAllUsers();
        input.close();
    }
}
