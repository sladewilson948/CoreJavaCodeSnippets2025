package something;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class UsersList
{


    private List<Users> users = new ArrayList<>();

    public void addUsers(Users user)
    {
        users.add(user);
        System.out.println("Successfuly added the user to the list");
    }

    public void addUserInfoToFile()
    {
        for(Users user: users )
        {
            try(BufferedWriter bw = new BufferedWriter(new FileWriter("user_details.txt", true)))
            {
                bw.write(user.toString());
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }

        System.out.println("Successfully added all the users to the file");
    }
}



class Users
{

    private String name;
    private int age;
    private Long salary;
    private String city;
    private String country;



    public Users(String name, int age, Long salary, String city, String country)
    {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.city = city;
        this.country = country;
    }


    @Override
    public String toString()
    {
        return "Hi my name is '" + name + "' and I am '" + age + " ' years old. I am from '" + city + "','" + country + "'";
    }




}


public class Tonight
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        UsersList usersList = new UsersList();
        for(int i=0;i<5;i++)
        {
            System.out.println("Lets make some users!!");
            System.out.println("Please enter user name : ");
            String name = input.nextLine();
            System.out.println("Please enter user age : ");
            int age = input.nextInt();
            input.nextLine();
            System.out.println("Please enter user salary : ");
            Long salary = input.nextLong();
            input.nextLine();
            System.out.println("Please enter user city : ");
            String city = input.nextLine();
            System.out.println("Please enter user country : ");
            String country = input.nextLine();
            /// creating new user
            Users user = new Users(name,age,salary,city,country);
            usersList.addUsers(user);
        }

        usersList.addUserInfoToFile();


        input.close();
    }

}

