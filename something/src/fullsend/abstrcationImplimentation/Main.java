package fullsend.abstrcationImplimentation;
import java.util.Scanner;
import java.util.Random;


interface AllUserProperty
{

    void singMeASong();
}

abstract class AllUsers
{
    Random random = new Random();
    private int id;
    private String name;
    private String city;
    private String country;


    public AllUsers(String name, String city, String country)
    {
        this.id = random.nextInt(1000);
        this.name = name;
        this.city = city;
        this.country = country;
    }

    public abstract String getUserSpecificDetails();

    public String getUserName()
    {
        return name;
    }
}

class User extends AllUsers implements AllUserProperty
{

    private String dob;

    public User(String name, String city, String country, String dob)
    {
        super(name,city,country);
        this.dob = dob;
    }

    @Override
    public void singMeASong() {
        System.out.println("I am singing a a song for you!!");
    }

    @Override
    public String getUserSpecificDetails() {
        return "Hi my name is "+getUserName()+" and my dob is "+dob;
    }
}


public class Main {

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Let us make a user object now");
        System.out.println("Please provide the required details");
        System.out.println("Please enter name : ");
        String name = input.nextLine();
        System.out.println("Please enter city name : ");
        String city = input.nextLine();
        System.out.println("Please enter country name : ");
        String country = input.nextLine();
        System.out.println("Please enter dob name : ");
        String dob = input.nextLine();


        System.out.println("Time to create the user object");
        User user = new User(name,city,country,dob);
        System.out.println(user.getUserSpecificDetails());
        user.singMeASong();
        input.close();
    }

}
