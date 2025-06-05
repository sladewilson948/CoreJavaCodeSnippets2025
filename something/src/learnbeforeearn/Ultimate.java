package learnbeforeearn;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



class UserList
{


    private List<User> users;

    public UserList()
    {
        this.users = new ArrayList<>();
    }

    public void addUserToList(User user)
    {
        users.add(user);
        System.out.println("Successfuly added the user to the list!!");
    }

    public void displayAllUsers()
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
        return "Hi my name is '" + name + "' and I am '" + age + "' years old!!";
    }
}

public class Ultimate {

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to my program lets try to make some object shall we");
        System.out.println("Please enter your name : ");
        String name = input.nextLine();
        System.out.println("Please enter your age : ");
        int age = Integer.parseInt(input.nextLine());
        System.out.println("Please enter your city name : ");
        String city = input.nextLine();
        System.out.println("Please enter your country name : ");
        String country = input.nextLine();
        /// let us make user object
        User user = new User(name,age,city,country);
        UserList lists = new UserList();
        lists.addUserToList(user);
        lists.displayAllUsers();



        input.close();
    }
}
