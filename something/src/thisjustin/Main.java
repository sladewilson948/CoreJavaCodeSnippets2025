package thisjustin;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;
import java.util.List;
import java.util.Random;


class UserList
{

    private List<User> userList;

    public UserList()
    {
        this.userList = new ArrayList<>();
    }

    public List<User> getUserList()
    {
        return userList;
    }

    public void addUserToList(User user)
    {
        userList.add(user);
        System.out.println("Successfully added the user to the list");
    }

    public void displayAllUsers()
    {
        System.out.println("Here is a list of all users");
        for(User user: userList)
        {
            System.out.println(user);
        }
    }

}

class User
{
    private int id;
    private String name;
    private int age;
    private String city;
    private String country;
    Random random = new Random();


    public User(String name, int age, String city, String country)
    {
        this.id = random.nextInt(1000);
        this.name = name;
        this.age = age;
        this.city = city;
        this.country = country;
    }


    public int getUserId()
    {
        return this.id;
    }

    @Override
    public String toString()
    {
        return "Hi my name is "+ name+" and I am "+age+" years old. I am from "+city+", "+country+", and my id is "+id;
    }

}

public class Main
{

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("We will take a look at the java Optional class here");
        System.out.println("Let us first make some users for our class");
        System.out.println("Please enter name : ");
        String name = input.nextLine();
        System.out.println("Please enter age : ");
        int age = Integer.parseInt(input.nextLine());
        System.out.println("Please enter city : ");
        String city = input.nextLine();
        System.out.println("Please enter country : ");
        String country = input.nextLine();

        // creating a user list
        UserList userList = new UserList();
        User user1 = new User(name,age,city,country);
        User user2 = new User("Archita Dubey",22,"Mumbai","India");
        userList.addUserToList(user1);
        userList.addUserToList(user2);
        userList.displayAllUsers();

        System.out.println("<---------------->");
        System.out.println("Enter the id you want to search : ");
        int id = Integer.parseInt(input.nextLine());
        Optional<User> optionalUser = getUserById(id,userList.getUserList());

        // way 1
        if(optionalUser.isPresent())
        {
            System.out.println(optionalUser.get());
            System.out.println(optionalUser.get().getUserId());
        }
        else{
            System.out.println("No user could be found with the id "+id);
        }
        // way 2
        User user = optionalUser.orElse(new User("Unknown",0,"Unknown","Unknown"));
        System.out.println(user);
        System.out.println(user.getUserId());
    }


    public static Optional<User> getUserById(int id, List<User> usersList)
    {
        // we will return an optional
        for(User user: usersList)
        {
            if(user.getUserId()==id)
            {
                return Optional.of(user);
            }
        }

        return Optional.empty();
    }
}