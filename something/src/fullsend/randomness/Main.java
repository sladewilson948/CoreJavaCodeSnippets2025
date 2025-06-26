package fullsend.randomness;

import java.util.*;

class AllUsersList
{

    private List<Users> usersList;

    public AllUsersList()
    {
        this.usersList = new ArrayList<>();
    }

    public void addUsersToList(List<Users> providedList)
    {
        for(Users users: providedList)
        {
            usersList.add(users);
        }
        System.out.println("Added all the users to the list!");
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

    private final UUID id;
    private String name;
    private String city;
    private int age;
    private String country;

    public Users(String name, String city, int age, String country)
    {
        this.id = UUID.randomUUID();
        this.name = name;
        this.city = city;
        this.age = age;
        this.country = country;
    }

    @Override
    public String toString()
    {
        return "Users("+id+", "+name+", "+age+", "+city+", "+country+")";
    }

}

public class Main {


    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Today we will be seeing how good UUIDS are");
        AllUsersList allUsersList = new AllUsersList();
        List<Users> providedList = new ArrayList<>(Arrays.asList(
                new Users("Aman Dubey","Bangalore",27,"India"),
                new Users("Archita Dubey","Mumbai",22,"India"),
                new Users("Mukesh Dubey","Varanasi",30,"India"),
                new Users("Sharda Dubey","Balia",32,"India"),
                new Users("Rachel Broshnan","LA",22,"USA")
        ));
        allUsersList.addUsersToList(providedList);
        allUsersList.showAllUsers();
        input.close();
    }
}
