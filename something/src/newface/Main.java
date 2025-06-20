package newface;
import java.util.*;


class UsersList
{
    private List<User> userList;

    public UsersList()
    {
        this.userList = new ArrayList<>();
    }

    public void addUserToList(User user)
    {
        userList.add(user);
        System.out.println("Successfully added the user to the list");
    }

    public List<User> getAllUsers()
    {
        return userList;
    }
}

class User{

    private int id;
    private String name;
    private String city;
    private String contact;
    Random random = new Random();

    public User()
    {
        this("Aman Dubey", "Bangalore", "9123589087");
    }

    public User(String name, String city, String contact)
    {
        this.id = random.nextInt(1000);
        this.name = name;
        this.city = city;
        this.contact = contact;
    }

    public int getUserId()
    {
        return id;
    }

    @Override
    public String toString()
    {
        return "Hi my name is "+ name + ". My id is "+id+". I am from "+city+" and you can call me on "+contact;
    }
}


public class Main {

    public static void main(String[] args)
    {
        UsersList lists = new UsersList();
        Scanner input = new Scanner(System.in);
        System.out.println("In this program we will see how we can make use of the java optional return type");
        System.out.println("Now we can actually start creating the users for our program");
        System.out.println("Please provide the required details");
        for(int i=0;i<5;i++)
        {
            System.out.println("Please enter name : ");
            String name = input.nextLine();
            System.out.println("Please enter city : ");
            String city = input.nextLine();
            System.out.println("Please enter contact : ");
            String contact = input.nextLine();
            System.out.println("Creating someUser");
            User user = new User(name,city,contact);
            lists.addUserToList(user);
        }

        System.out.println("Time to search for a someUser");
        System.out.println("Here is a list of all users" + lists.getAllUsers());
        System.out.println("Enter the someUser you want to seartch the id");
        int id = Integer.parseInt(input.nextLine());

        Optional<User> someUser = getUserById(id,lists.getAllUsers());

        // now this someUser is an optinal so we need to handle it accordingly meaning it can be null
        if(someUser.isPresent())
        {
            System.out.println("Required someUser " + someUser.get());
            System.out.println("User id : "+ someUser.get().getUserId());
        }
        else{
            System.out.println("The someUser could not be found for the given id "+ id);
        }

        User user = someUser.orElse(new User());
        System.out.println(user);
        System.out.println(user.getUserId());

        // there is another way to handle this


        input.close();
    }

    public static Optional<User> getUserById(int idToFind, List<User> listofUsers)
    {
        for(User user: listofUsers)
        {
            if(user.getUserId()==idToFind)
            {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }
}
