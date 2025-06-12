package practicemakesperfect;
import java.util.Scanner;
import java.util.Random;


interface AllUserProperty
{
    void singMeASong();
}


abstract class AllUsers
{
    Random rand = new Random();
    private int id;
    private String name;
    private int age;
    private String city;
    private String country;

    public AllUsers(String name, int age, String city, String country)
    {
        this.id = rand.nextInt(1000);
        this.name = name;
        this.age = age;
        this.city = city;
        this.country = country;
    }

    public abstract String userSpecificDetails();

    public String getUserName()
    {
        return name;
    }
}


class Users extends AllUsers implements AllUserProperty
{
    private String dob;
    public Users(String name, int age, String city, String country, String dob) {
        super(name, age, city, country);
        this.dob = dob;
    }

    // since Users is extending the AllUsers class it has access ot the methods in int
    @Override
    public String userSpecificDetails() {
        return "Hi my name is" + getUserName()+" and my birthday is "+dob;
    }

    @Override
    public void singMeASong() {
        System.out.println("I am a user and here I am stadning in queeue singing a song for you!!");
    }
}

public class Broski {

    public static void main(String[] args)
    {


        // creatring a user
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your name : ");
        String name = input.nextLine();
        System.out.println("Please enter your age : ");
        int age = Integer.parseInt(input.nextLine());
        System.out.println("Please enter your city : ");
        String city = input.nextLine();
        System.out.println("Please enter your country : ");
        String country = input.nextLine();
        System.out.println("Please enter your dob : ");
        System.out.println("Enter dob : ");
        String dob = input.nextLine();
        Users users = new Users(name,age,city,country,dob);
        System.out.println(users.userSpecificDetails());
        users.singMeASong();

    }

}
