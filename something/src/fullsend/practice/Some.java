package fullsend.practice;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.Random;


class UsersList
{

    private List<User> usersList;

    public UsersList()
    {
        this.usersList = new ArrayList<>();
    }

    public void showAllUsers(List<User> usersList)
    {
        for(User user: usersList)
        {
            System.out.println("Hi this is a user "+user);
        }
    }

    public String addUserToList(User user)
    {
        usersList.add(user);
        return "Hi I just added a user for you!";
    }

}

class User
{
    public static final Random random = new Random();

    private int id;
    private String name;
    private String city;
    private String country;

    public User(String name, String city, String country)
    {
        this.id = random.nextInt(1000);
        this.name = name;
        this.city =city;
        this.country = country;
    }

    @Override
    public String toString()
    {
        return "Hi my name is "+name+" and I am from "+city+","+country+" and I my id is "+country;
    }
}


public class Some
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Time to create some users now");
        System.out.println("Please provide us with the required details");
        System.out.println("Please enter name : ");
        String name = input.nextLine();
        
        input.close();
    }
}