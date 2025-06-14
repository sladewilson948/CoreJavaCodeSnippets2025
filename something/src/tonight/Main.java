package tonight;
import java.util.*;


class User
{
    private int id;
    private String name;
    private int age;
    private String city;
    private String country;
    Random random = new Random();

    public User()
    {
        this("Unknown",0,"Unknown","Unknown");
    }

    public User(String name,int age, String city, String country)
    {
        this.id = random.nextInt(1000);
        this.name = name;
        this.age = age;
        this.city = city;
        this.country = country;
    }

    @Override
    public String toString()
    {
        return "User(name : "
                +name+ " age : "+age
                + " id "+id +" city "+city
                + " country "+country + ")";
    }

    public int getId()
    {
        return id;
    }

}


public class Main {

    static final List<User> usersList = new ArrayList<>(Arrays.asList(

            new User("Aman Dubey",27,"Banaglore","India"),
            new User("Mukesh Dubey",55,"Varanasi","India"),
            new User("Archita Dubey",22,"Mumbai","India"),
            new User("Rachel Mc Adams",35,"Los Angeles","USA"),
            new User("Prem Kumar",23,"asod","asdasd")
    ));

    public static void main(String[] args)
    {


        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the application.");
        System.out.println("Here is a list fo all users");
        System.out.println("--------------");
        for(User user: usersList)
        {
            System.out.println(user);
        }


        System.out.println("Enter the id you want to search : ");
        int id = Integer.parseInt(input.nextLine());

        Optional<User> optionalUser = getUserById(id,usersList);

        // there are two way to go aboiiut it
        if(optionalUser.isPresent())
        {
            System.out.println("this is your required user : "+optionalUser.get());
            System.out.println("Required id : "+optionalUser.get().getId());
        }
        else{
            System.out.println("This means we got a null as the return and it has to be handled");
            System.out.println("No user found with the given id "+id);
        }

        // the other way to handle this is by the
        User user = optionalUser.orElse(new User());
        System.out.println("The user you were looking for "+user.getId());
        System.out.println(user);

        input.close();
    }

    // we need to define the method that will return us a user for a given id

    public static Optional<User> getUserById(int id, List<User> usersList)
    {

        return usersList.stream()
                .filter(x->x.getId()==id)
                .findFirst();


    }
}
