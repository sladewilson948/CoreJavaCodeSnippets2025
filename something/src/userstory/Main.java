package userstory;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.util.List;


class Users implements Serializable
{

    private int id;
    private String name;
    private short age;
    private String city;
    private List<String> favSubject;


    public static int getRandomId()
    {
        Random rand = new Random();
        return rand.nextInt(10000);
    }

    public Users(String name, short age, String city, List<String> favSubject)
    {
        this.id = getRandomId();
        this.name = name;
        this.age = age;
        this.city = city;
        this.favSubject = favSubject;
    }

    public int getUserId()
    {
        return id;
    }



    @Override
    public String toString()
    {
        return "id=> '" + id + "' name=> '" + name + "' age=> '" + age + "' city=> '" + city + "' subjects=> '" + favSubject + "'";
    }

}



class UsersTools
{

    private static final String filePath = "D:\\JAVA2025\\something\\src\\userstory\\mydata.dat";


    public static String saveUserDataToFile(List<Users> users)
    {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath)))
        {
            oos.writeObject(users);
            return "Successfuly added the data to the object";
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return "Something went wrong";
        }

    }


    public static List<Users> getAllUsers()
    {
        List<Users> lists = new ArrayList<>();
        File file = new File(filePath);
        if(!file.exists())
        {
            return lists;
        }
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath)))
        {
            lists = (List<Users>) ois.readObject();
        }
        catch(IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
            System.out.println("There was an error while reading the data");
        }

        return lists;
    }


    /// method to get a user from id
    public static Users getUserById(int id)
    {
        List<Users> allUsers = getAllUsers();
        for(Users user: allUsers)
        {
            if(user.getUserId()==id)
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
        System.out.println("Welcome to my users data base");
        System.out.println("This is an object database where data is stored in an object file");

        while (true)
        {
            System.out.println("To view all data press 1");
            System.out.println("To add new data press 2");
            System.out.println("To view by id press 3");
            System.out.println("To quit press 4");
            try
            {
                int option = Integer.parseInt(input.nextLine());
                if(option==1)
                {
                    if(UsersTools.getAllUsers().isEmpty())
                    {
                        System.out.println("No suers to show atm database empty");
                    }
                    for(Users users: UsersTools.getAllUsers())
                    {
                        System.out.println(users);
                    }
                }
                else if(option==2)
                {
                    List<String> favSubjects = new ArrayList<>();
                    System.out.println("Please provide me with all the required details");
                    System.out.print("Please enter name here : ");
                    String name = input.nextLine();
                    System.out.print("Please enter age here : ");
                    short age = Short.parseShort(input.nextLine());
                    System.out.print("Please enter the name of the city : ");
                    String city = input.nextLine();
                    System.out.println("Keep entering fav subjects one by one when done enter quit");
                    while (true)
                    {
                        System.out.println("Enter subject name");
                        String subjectName = input.nextLine();
                        if(subjectName.equals("quit"))
                        {
                            System.out.println("List data saved for user "+name);
                            break;
                        }
                        else{
                            favSubjects.add(subjectName);
                        }
                    }

                    /// creating user Object
                    Users users = new Users(name,age,city,favSubjects);
                    List<Users> allUsers = UsersTools.getAllUsers();
                    allUsers.add(users);
                    UsersTools.saveUserDataToFile(allUsers);
                }
                else if(option==3)
                {
                    System.out.println("Please provide me with the id number : ");
                    int id = Integer.parseInt(input.nextLine());
                    Users users = UsersTools.getUserById(id);
                    if(users!=null)
                    {
                        System.out.println(users);
                    }
                    else
                    {
                        System.out.println("No data exists in the system for the user with id : "+id);
                    }
                } else if (option==4) {

                    System.out.println("Thanks for using our application");
                    break;
                } else{
                    System.out.println("Please provide a value in 1,2 or 3 dummie");
                }
            }
            catch (NumberFormatException e)
            {
                e.printStackTrace();
                System.out.println("Please provide a valid int to start the program");
            }

        }


        input.close();
    }
}
