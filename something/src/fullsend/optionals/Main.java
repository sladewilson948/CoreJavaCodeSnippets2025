package fullsend.optionals;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;
import java.util.List;
import java.util.Random;

// in this java program we will see all about Java Optionals
// lets goo

class UsersList
{

    private List<User> usersList;

    public UsersList()
    {
        this.usersList = new ArrayList<>();
    }

    public void addUserToList(User user)
    {
        usersList.add(user);
        System.out.println("Added the user successfully");
    }


    public List<User> displayAllUsers()
    {
        return usersList;
    }

}

class User
{
    private int id;
    private String name;
    private String city;
    private int age;
    private String country;
    Random random = new Random();

    public User(String name, String city, int age, String country)
    {
        this.id = random.nextInt(10000);
        this.name = name;
        this.city = city;
        this.age = age;
        this.country = country;
    }

    @Override
    public String toString()
    {
        return "Id : " + id + "Hi my name is "+name+" and I am from "+city+", "+country+" and I am "+age+" years old.";
    }

    public int getUserId()
    {
        return id;
    }
}


public class Main {

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Let us now start our application");
        UsersList usersList = new UsersList();
        System.out.println("Time to create some users object");
        System.out.println("Please provide some details here");
        for(int i=0;i<5;i++)
        {
            System.out.println("Enter name : ");
            String name = input.nextLine();
            System.out.println("Enter age : ");
            int age = Integer.parseInt(input.nextLine());
            System.out.println("Enter city : ");
            String city = input.nextLine();
            System.out.println("Enter country : ");
            String country = input.nextLine();
            User user = new User(name,city,age,country);
            usersList.addUserToList(user);
        }
        System.out.println("Added all "+5+" users in the list");
        System.out.println("Here all the users "+ usersList.displayAllUsers());
        System.out.println("Enter the id you want to find : ");
        int id = Integer.parseInt(input.nextLine());
        Optional<User> optionalUser = getUserById(id,usersList.displayAllUsers());

        if(optionalUser.isPresent())
        {
            System.out.println(optionalUser.get());
            System.out.println(optionalUser.get().getUserId());
        }
        else{
            System.out.println("Did not find any user of the id "+id);
        }

        User user = optionalUser.orElse(new User("UNKNOWN","UNKNOWN",0,"UNKNOWN"));
        System.out.println(user);
        System.out.println(user.getUserId());
        input.close();
    }

    public static Optional<User> getUserById(int id, List<User> usersList)
    {
        for(User user: usersList)
        {
            if(user.getUserId()==id)
            {
                return Optional.of(user);
            }
        }
        // this means we are returning null
        return Optional.empty();
    }
}
