package walle;

import java.util.*;

class AllUsersList
{

    private List<AllUsers> usersList;

    public AllUsersList()
    {
        this.usersList = new ArrayList<>();
    }

    public void AddUsersToList(List<AllUsers> inputList)
    {
        for(AllUsers users: inputList)
        {
            usersList.add(users);
        }
        System.out.println("Successfully added all the users to the list");
    }

    public void showAllUsers()
    {
        for(AllUsers users: usersList)
        {
            System.out.println(users);
        }
    }

    public List<AllUsers> getUsersList()
    {
        return usersList;
    }
}



class AllUsers
{

    private int id;
    private String name;
    private String city;
    private String country;
    private static final Random random = new Random();


    public AllUsers()
    {
        this("Null","Null","Null");
    }

    public AllUsers(String name, String city, String country)
    {
        this.id = random.nextInt(10000);
        this.name = name;
        this.city = city;
        this.country = country;
    }

    public int getId()
    {
        return id;
    }

    @Override
    public String toString()
    {
        return "User("+id+","+name+","+city+","+country+")";
    }

}

public class Main {


    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to my application");
        System.out.println("LET US FIRST MAKE SOME USERS");
        AllUsersList usersList = new AllUsersList();
        List<AllUsers> inputList = new ArrayList<>(Arrays.asList(

                new AllUsers("Aman Dubey","Bangalore","India"),
                new AllUsers("Archita Dubey","Mumbai","India"),
                new AllUsers("Sharda Dubey","Balia","India"),
                new AllUsers("Mukesh Dubey", "Varanasi","India")
        ));
        usersList.AddUsersToList(inputList);
        System.out.println(" ");
        usersList.showAllUsers();
        System.out.println(" ");
        System.out.println("Enter the id you want to search by id : ");
        int id = Integer.parseInt(input.nextLine());
        Optional<AllUsers> userFoundById = findUserById(id, usersList.getUsersList());

        if(userFoundById.isPresent())
        {
            System.out.println("The required user found by id "+ id +" is "+userFoundById.get());
        }
        else{
            System.out.println("No users found with the particular id!!");
        }

        AllUsers usersFound = userFoundById.orElse(new AllUsers());
        System.out.println(usersFound);

        input.close();
    }

    private static Optional<AllUsers> findUserById(int id, List<AllUsers> inputList)
    {
        for(AllUsers users: inputList)
        {
            if(users.getId()==id)
            {
                return Optional.of(users);
            }

        }

        return Optional.empty();
    }
}
