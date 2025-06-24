package fullsend.practice;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.Random;


class YourUsersList
{

    private List<YourUsers> lists;

    public YourUsersList()
    {
        this.lists = new ArrayList<>();
    }

    public void addUsersToList(YourUsers users)
    {
        lists.add(users);
    }

    public void showAllUsers()
    {
        for(YourUsers users: lists)
        {
            System.out.println(users);
        }
    }


}


class YourUsers
{

    private static final Random random = new Random();
    private int id;
    private String name;
    private String city;
    private String country;
    private List<String> subjects;


    public YourUsers(String name, String city, String country, List<String> subjects)
    {
        this.id = random.nextInt(1000);
        this.name = name;
        this.city = city;
        this.country = country;
        this.subjects = subjects;
    }

    @Override
    public String toString()
    {
        return "Hi my name is "+name+" and I am from "+city+" and I have an id of "+id;
    }

    public int getId()
    {
        return id;
    }

    public List<String> getAllSubjects()
    {
        return subjects;
    }
}



public class Saturday {
    
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("We will see how java optionals work!");
        input.close();
    }
}
