package practicemakesperfect;
import java.util.*;


class MineUsersList{

    private List<MineUser> allMineUsers;


    public MineUsersList()
    {
        allMineUsers = new ArrayList<>();
    }

    public List<MineUser> getAllMineUsers()
    {
        return allMineUsers;
    }

    public void addMineUser(MineUser user)
    {
        allMineUsers.add(user);
        System.out.println("Successfuly added the user to the database");
    }

    public void showAllUsers()
    {
        for(MineUser user: allMineUsers)
        {
            System.out.println(user);
        }
    }
}

class MineUser
{
    Random random = new Random();
    private int id;
    private String name;
    private int age;
    private String city;
    private String country;


    public MineUser(String name, int age, String city, String country)
    {
        this.id = random.nextInt(10000);
        this.name = name;
        this.age = age;
        this.city = city;
        this.country = country;
    }

    @Override
    public String toString()
    {
        return "Hi my name is "+name+", and I am from "+city+", "+country+" nice to meet you. My id is "+id;
    }

    public String getName()
    {
        return this.name;
    }
    public int getId()
    {
        return this.id;
    }


}


public class MyOptionals {


    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the program");
        System.out.println("Time to create some users");
        System.out.println("Enter name : ");
        String name = input.nextLine();
        System.out.println("Enter age : ");
        int age = Integer.parseInt(input.nextLine());
        System.out.println("Enter city : ");
        String city = input.nextLine();
        System.out.println("Enter country : ");
        String country = input.nextLine();
        System.out.println("Time to add this object to a object list");
        MineUsersList mineuserslist = new MineUsersList();
        mineuserslist.addMineUser(new MineUser(name,age,city,country));
        System.out.println("Here are all the users added so far");
        mineuserslist.showAllUsers();
        System.out.println("Enter the id you want to search : ");
        int id = Integer.parseInt(input.nextLine());
        // this indicates that the return value could be a value or an null as well
        Optional<MineUser> optionalUser = getSingleUserById(id,mineuserslist.getAllMineUsers());

        if(optionalUser.isPresent())
        {
            System.out.println(optionalUser.get().getName());
        }
        else{
            System.out.println("No users exist for the id " + id);
        }

        // the other way of doing this is
        MineUser mineUser = optionalUser.orElse(new MineUser("Unknown",0,"Unknown","Unknown"));
        System.out.println("Here are the required details : "+mineUser);

        input.close();
    }


    // now what we will do it define a method that will take two parameters id and the list of all MineUsers and then return the user with the id this is where we can make use of optional in java
    public static Optional<MineUser> getSingleUserById(int id, List<MineUser> usersList)
    {
        for(MineUser user: usersList)
        {
            if(user.getId()==id)
            {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }
}
