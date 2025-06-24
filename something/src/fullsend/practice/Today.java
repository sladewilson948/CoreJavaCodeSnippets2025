package fullsend.practice;

import java.util.*;


class UsersLists
{

    private List<Users> usersList;


    public UsersLists()
    {
        this.usersList = new ArrayList<>();
    }

    public void addUserToList(List<Users> allUsersList)
    {
        for(Users users : allUsersList)
        {
            usersList.add(users);
        }
        System.out.println("Added all users to list!");
    }

    public void showAllUsers()
    {
        for(Users users: usersList)
        {
            System.out.println(users);
        }
    }

}

class Users
{

    private static final Random random = new Random();
    private int id;
    private String name;
    private String city;
    private String country;

    public Users(String name, String city, String country)
    {
        this.id = random.nextInt(10000);
        this.name = name;
        this.city = city;
        this.country = country;
    }

    @Override
    public String toString()
    {
        return "Hi my name is "+name+" and I am from "+city+", "+country + " my id is "+id;
    }

    public int getId()
    {
        return id;
    }
}

public class Today {

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        List<Users> usersDetails = new ArrayList<>(Arrays.asList(
                new Users("Aman Dubey","Bangalore","India"),
                new Users("Archita Dubey","Mumbai","India"),
                new Users("Mukesh Dubey","Varanasi","India"),
                new Users("Sharda Dubey","Balia","India"),
                new Users("Charlie Dubey","Varanasi","India")
        ));

        UsersLists usersList = new UsersLists();
        usersList.addUserToList(usersDetails);
        usersList.showAllUsers();
        input.close();
    }

    public static Optional<Users> findUserById(int id, List<Users> usersDetails)
    {
        for(Users user: usersDetails)
        {
            if(user.getId()==id)
            {
                return Optional.of(user);
            }
        }

        return Optional.empty();
    }
}
