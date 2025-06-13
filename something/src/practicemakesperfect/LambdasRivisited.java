package practicemakesperfect;
import java.util.Scanner;
import java.util.Random;

@FunctionalInterface
interface SomeInfoNeeded
{
    void useThisMethod();
}

class ThisUser implements SomeInfoNeeded
{
    Random random = new Random();
    int id;
    String name;
    int age;
    String city;
    String country;

    public ThisUser(String name, int age, String city, String country)
    {
        this.id = random.nextInt(10000);
        this.age = age;
        this.city = city;
        this.country = country;
    }

    @Override
    public void useThisMethod() {
        System.out.println("Hi my name is "+name+" I am "+age+" years old. I am from "+ city+", "+country);
    }


}


public class LambdasRivisited {


    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Let us now see lambda in action");
        System.out.println("Please provide us with the required details");
        System.out.println("Enter name : ");
        String name = input.nextLine();
        System.out.println("Enter age : ");
        int age = Integer.parseInt(input.nextLine());
        System.out.println("Enter city name : ");
        String city = input.nextLine();
        System.out.println("Enter country name : ");
        String country = input.nextLine();

        // creating ThisUser object
        // so instead of paSSING THE entire ibject we are only passing the function that we have defined in the int erfce
        ThisUser userone = new ThisUser(name,age,city,country);

        // now its time to make the Intyerface method
        // as you can see what is actually happening is that instead of passinbg the whole object of the ThisUser class we are only
        SomeInfoNeeded sin = ()-> System.out.println("Hi my name is "+name+" I am "+age+" years old. I am from "+ city+", "+country);
        useInterfaceMethod(sin);
        input.close();
    }


    public static void useInterfaceMethod(SomeInfoNeeded sin)
    {
        sin.useThisMethod();
    }
}
