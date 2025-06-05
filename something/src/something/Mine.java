package something;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;



class UserList
{

    private List<User> users;

    public UserList()
    {
        // we will initialize and empty array when the userslist class object is called
        this.users = new ArrayList<>();
    }

    public void addUsersToList(User user)
    {
        users.add(user);
        System.out.println("Successfully added the user to the list!");
    }

    public void showAllUsers()
    {
        for(User user: users)
        {
            System.out.println(user);
        }
    }

}


class User
{
    private String name;
    private int age;
    private String city;
    private String country;



    public User(String name, int age, String city, String country)
    {
        this.name = name;
        this.age = age;
        this.city = city;
        this.country = country;
    }


    @Override
    public String toString()
    {
        return "Hi my name is '" + name + "' and I am '" + age + "' years old, I am from '" + city + "','" + country +"'";
    }



}



public class Mine
{

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Lets make some objects shall we");
        System.out.println("Please enter your name : ");
        String name = input.nextLine();
        System.out.println("Please enter your age : ");
        int age = Integer.parseInt(input.nextLine());
        System.out.println("Plesse enter you city name : ");
        String city = input.nextLine();
        System.out.println("Please enter your country name : ");
        String country = input.nextLine();
        User user = new User(name,age,city,country);
        UserList lists = new UserList();
        lists.addUsersToList(user);
        lists.showAllUsers();
        System.out.println("Program completed!!");
        input.close();
    }
}

