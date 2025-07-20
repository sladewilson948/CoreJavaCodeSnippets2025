package anonymouseinnerclass;
import java.util.Random;
import java.util.Scanner;


class User
{
    private static int id;
    private static String name;
    private static String city;
    private static String country;
    Random rand = new Random();

    public User(String name, String city, String country)
    {
        this.id = rand.nextInt(1000);
        this.name = name;
        this.city = city;
        this.country = country;
    }

    public static String getSomeInfo()
    {
        return "Hi my name is "+name+ " and I am from "+ city +","+country + " it was nice meeting you all";
    }

    public void myMethod()
    {
        System.out.println("Hi there I hope you are doing good!!");
    }
}


public class Main {

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the program");
        System.out.println("Please provide the required details");
        System.out.println("Please enter your name : ");
        String name = input.nextLine();
        System.out.println("Please enter your city : ");
        String city = input.nextLine();
        System.out.println("Please enter your country : ");
        String country = input.nextLine();
        Random rand = new Random();
        User user1 = new User(name,city,country);

        User user2 = new User(name,city,country)
        {
            @Override
            public void myMethod()
            {
                System.out.println("Hi there I hope you are doing excellent!!");
            }

            /// we can add some extra methods if we want to

            @Override
            public String toString()
            {
                return "My name is "+name + " and I am from " + country;
            }

        };


        user1.myMethod();
        user2.myMethod();
        System.out.println(user2);
        input.close();
    }
}
