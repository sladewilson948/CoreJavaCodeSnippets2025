package something;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



class MyUsers
{


    private String name;
    private int age;
    private Long salary;
    private String city;
    private static int count = 0;
    private List<String> userDetails = new ArrayList<>();


    public MyUsers(String name, int age, Long salary, String city)
    {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.city = city;
        // making sure to clear the array everytime the object is created
        userDetails.clear();
        userDetails.add(name);
        userDetails.add(String.valueOf(age));
        userDetails.add(String.valueOf(salary));
        userDetails.add(city);
        count+=1;
    }


    public String addUserInfoToFile()
    {

        try
        {
            FileWriter writer = new FileWriter("user_details.txt", true);
            for(String item: userDetails)
            {
                writer.write(item +"\n");
            }
            writer.write("Current user count : "+count + "\n");
            writer.close();

            return "Successfuly added the details of the user into the text file!!";
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return "Something went wrong while typing in the data!!";
        }
    }



    @Override
    public String toString()
    {
        return "Hi there here are some details about me : Name : '" + name + "' Age : '" + age + "' City : '" + city + "' and I am making around '" + salary + "' every year";
    }
}




public class Something {



    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the application where we will add users!!");
        while(true)
        {
            System.out.print("Enter user name : ");
            String name = input.nextLine();
            if(name.equals("CLOSE"))
            {
                break;
            }
            System.out.print("Enter user age : ");
            int age = input.nextInt();
            input.nextLine();
            System.out.print("Enter user salary : ");
            Long salary = input.nextLong();
            input.nextLine();
            System.out.print("Enter user city : ");
            String city = input.nextLine();

            // now we can make our Object the user object
            MyUsers user = new MyUsers(name,age,salary,city);
            user.addUserInfoToFile();
        }

        input.close();
    }
}
