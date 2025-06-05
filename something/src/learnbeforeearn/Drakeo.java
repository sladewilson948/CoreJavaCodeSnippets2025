package learnbeforeearn;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;


/// let us now make some users class


class UsersList
{


    private List<Users> myUsers;

    public UsersList()
    {
        this.myUsers = new ArrayList<>();
    }


    public void addUserToList(Users user)
    {
        myUsers.add(user);
        System.out.println("Successfuly added the user to the list");
    }

    public void showAllUsers()
    {
        for(Users user: myUsers)
        {
            System.out.println(user);
        }
    }
}

class Users
{

    private String name;
    private int age;
    private Long salary;


    public Users(String name, int age, Long salary)
    {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }


    @Override
    public String toString()
    {
        return "Hi my name is '" + name + "'. I am '" + age + "' years old and I am making around '" + salary + "' pa";
    }
}



public class Drakeo {


    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Hello there welcome to my program and today we will study about classes");
        System.out.print("Please enter your name : ");
        String name = input.nextLine();
        System.out.print("Please enter your age : ");
        int age = Integer.parseInt(input.nextLine());
        System.out.print("Enter your salary : ");
        Long salary = Long.parseLong(input.nextLine());
        /// creating user object
        Users users = new Users(name,age,salary);
        UsersList usl = new UsersList();
        usl.addUserToList(users);
        input.close();
    }
}
