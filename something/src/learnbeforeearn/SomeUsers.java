package learnbeforeearn;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;



class CreateUsers implements Serializable
{
    private String id;
    private String name;
    private int age;
    private String city;
    private String country;


    public CreateUsers(String id, String name, int age, String city, String country)
    {
        this.id = id;
        this.name = name;
        this.age = age;
        this.city = city;
        this.country = country;
    }


    @Override
    public String toString()
    {
        return "Hi my name is '" + name + "' and I am from '" + city + "', '" + country + "'. I am '" + age + "' years old!!";
    }


}


class UsersUtility
{
    /// this is the class where we will save the users list to a .dat file and load the users from the file

    private static final String FILE_NAME = "myusers.dat";

    public static void saveUsersInfo(List<CreateUsers> someusers)
    {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME)))
        {
            oos.writeObject(someusers);
            System.out.println("Successfuly added the users to the file!!!");
        }
        catch(IOException e)
        {
            System.out.println("Some error while adding the data to file!!");
        }

    }

    public static List<CreateUsers> loadUsersInfo()
    {
        List<CreateUsers> myusers = new ArrayList<>();
        File file = new File(FILE_NAME);
        if(!file.exists()){ return myusers;}
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME)))
        {
            myusers = (List<CreateUsers>) ois.readObject();
        }
        catch (IOException | ClassNotFoundException e)
        {
            System.out.println("Error while loading the data");
        }

        return myusers;
    }
}


public class SomeUsers {


    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Weclome to my program to save user info on an actual file offcourse");
        System.out.println("Please provide these details ");
        System.out.println("Enter id : ");
        String id = input.nextLine();
        System.out.println("Enter name ");
        String name = input.nextLine();
        System.out.println("Enter age : ");
        int age = Integer.parseInt(input.nextLine());
        System.out.println("Enter city name : ");
        String city = input.nextLine();
        System.out.println("Enter country name : ");
        String country = input.nextLine();


        /// creating user object
        List<CreateUsers> usersList = UsersUtility.loadUsersInfo();
        System.out.println("Here are the details of the exisitng users in the file!!");
        for(CreateUsers userinfo: usersList)
        {
            System.out.println(userinfo);
        }
        // createing userobject

        CreateUsers user1 = new CreateUsers(id,name,age,city,country);
        usersList.add(user1);
        UsersUtility.saveUsersInfo(usersList);
        System.out.println("Successfuly added the user info on the file!!");
        System.out.println("Here is the updated users list on the file!!");
        List<CreateUsers> updatedUserInfo = UsersUtility.loadUsersInfo();
        for(CreateUsers user: updatedUserInfo)
        {
            System.out.println(user);
        }
        input.close();
    }
}
