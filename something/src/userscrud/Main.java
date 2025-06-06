package userscrud;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.util.List;


class User implements Serializable
{
    private int id;
    private String name;
    private int age;
    private String city;
    private String country;


    public static int getRandomNumber()
    {
        Random rand = new Random();
        return rand.nextInt(10000);
    }

    public int getUserId()
    {
        return id;
    }

    public User(String name, int age, String city, String country)
    {
        this.id = getRandomNumber();
        this.name = name;
        this.age = age;
        this.city = city;
        this.country = country;
    }

    @Override
    public String toString()
    {
        return "Id : '" + id + " 'Hi my name is '"+ name +"'. I am from '" + city + "', '" + country + "'. I am '" + age + "' years old";
    }

}


class UserUtility
{
    private static final String filepath = "D:\\JAVA2025\\something\\src\\userscrud\\userdetails.dat";

    public static void addUserInfoToFile(List<User> usersList)
    {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filepath)))
        {
            oos.writeObject(usersList);
            System.out.println("Successfully added the user data to file");
        }
        catch(IOException e)
        {
            System.out.println("Error occurred while reading yt");
        }
    }

    public static List<User> readUserInfoFromFile()
    {
        List<User> lists = new ArrayList<>();
        File file = new File(filepath);
        if(!file.exists())
        {
            return lists;
        }
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filepath)))
        {
            lists = (List<User>) ois.readObject();
        }
        catch(IOException | ClassNotFoundException e)
        {
            System.out.println("Error while reading the file from data");
        }

        return lists;
    }


    public static User getUserById(int id)
    {
        for(User user: readUserInfoFromFile())
        {
            if (user.getUserId()==id)
            {
                return user;
            }
        }

        return null;
    }


}


public class Main {


    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        // time to make some users
        System.out.println("Enter name : ");
        String name = input.nextLine();
        System.out.println("Enter age : ");
        int age = Integer.parseInt(input.nextLine());
        System.out.println("Enter city : ");
        String city = input.nextLine();
        System.out.println("Enter country : ");
        String country = input.nextLine();

        /// creating user object
        User user = new User(name,age,city,country);
        List<User> exisitngData = UserUtility.readUserInfoFromFile();
        // adding user info to this lists
        exisitngData.add(user);
        /// displaying all the user info
        for(User userData: exisitngData)
        {
            System.out.println(userData);
        }
        // writing this updated list back to the file
        UserUtility.addUserInfoToFile(exisitngData);

        System.out.println("To earch a user by id enter user id : ");
        int idSer = Integer.parseInt(input.nextLine());
        if(UserUtility.getUserById(idSer)!=null)
        {
            System.out.println(UserUtility.getUserById(idSer));
        }
        else{
            System.out.println("This user does not exists!!");
        }
        input.close();
    }
}
