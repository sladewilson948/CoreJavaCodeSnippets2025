package practicemakesperfect;
import java.util.Scanner;
import java.util.Random;


class NewUser
{

    private int id;
    private String name;
    private int age;
    private String city;
    private String country;
    Random random = new Random();


    public NewUser()
    {
        this("Aman Dubey",27,"Varanasi","India");
    }

    public NewUser(String name, int age, String city, String country)
    {
        this.id = random.nextInt(1000);
        this.name = name;
        this.age = age;
        this.city = city;
        this.country = country;
    }

    @Override
    public String toString()
    {
        return "Hi my name is "+name+ " I have an id of "+id +" I am from "+city+","+country + ". It was nice meeting you.";
    }
}

public class MyMain {


    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("We will create two objects");
        NewUser user1 = new NewUser();
        System.out.println("Enter name : ");
        String name = input.nextLine();
        System.out.println("Enter age : ");
        int age = Integer.parseInt(input.nextLine());
        System.out.println("Enter city : ");
        String city = input.nextLine();
        System.out.println("Enter country name : ");
        String country = input.nextLine();
        NewUser user2 = new NewUser(name,age,city,country);

        System.out.println("Details of the objects");
        System.out.println(user1);
        System.out.println(user2);
        input.close();
    }
}
