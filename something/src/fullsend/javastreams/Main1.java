package fullsend.javastreams;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.Random;

class MyUsersList
{

    private List<MyUser> usersList;

    public MyUsersList()
    {
        this.usersList = new ArrayList<>();
    }

    public void addUserToList(MyUser user)
    {
        this.usersList.add(user);
        System.out.println("Added successfully user to list");
    }

    public void showAllUsers()
    {
        for(MyUser user: this.usersList)
        {
            System.out.println(user);
        }
    }

    public void showAllUsersList()
    {
        System.out.println(usersList);
    }
}

class MyUser
{

    private int id;
    private String name;
    private String city;
    private String country;
    private int age;
    private static final Random random = new Random();


    public MyUser(String name, String city, String country, int age)
    {
        this.id = random.nextInt();
        this.name = name;
        this.city = city;
        this.country = country;
        this.age = age;
    }


    @Override
    public String toString()
    {
        return "Hi my name is "+ name+" and I am from "+city;
    }


}



public class Main1 {


    public static void main(String[]  args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Hi there lets go cray");
        System.out.println("Please enter the below details");
        System.out.println("Please enter name here : ");
        String name = input.nextLine();
        System.out.println("Please enter city : ");
        String city = input.nextLine();
        System.out.println("Please enter country : ");
        String country = input.nextLine();
        System.out.println("Enter age here : ");
        int age = Integer.parseInt(input.nextLine());
        MyUser user1 = new MyUser(name,city,country,age);
        MyUsersList usersList = new MyUsersList();
        usersList.addUserToList(user1);
        usersList.showAllUsers();
        usersList.showAllUsersList();

        input.close();
    }
}
