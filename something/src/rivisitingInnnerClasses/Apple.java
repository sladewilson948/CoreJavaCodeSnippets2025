package rivisitingInnnerClasses;
import java.util.Scanner;
import java.util.Random;


/// last and final way to actually use the OuterClass is using the static keyword in the inner class that way it becomes slightyl easiewr


class MyOuterClass
{



}


// let's take a look at the opther way to do this

class OutterClass
{
    Random rand = new Random();

    private int id;
    private String name;
    private int age;
    private String city;

    public OutterClass(String name, int age, String city)
    {
        this.id = rand.nextInt(1000);
        this.name = name;
        this.age = age;
        this.city = city;
    }


    class MyInnerClass
    {
        public void greetingsFromInnerClass()
        {
            System.out.println("Hi my name is "+ name + " and I am from "+ city + ". My age is "+age);
        }
    }
}


class ThisIsClass
{

    private int id;
    private String name;
    private String city;
    private String country;
    Random rand = new Random();


    public ThisIsClass(String name, String city, String country)
    {
        this.id = rand.nextInt(1000);
        this.name = name;
        this.city = city;
        this.country = country;
    }


    // definiing some methods

    public void getOneTrivia()
    {
        System.out.println("Did you know that we can make use of inner classes via a methods defined inside the oiuter claaa");

        class MyInnerClass
        {

            // defining the parameters for this inner class


            @Override
            public String toString()
            {
                return "Hi my name is "+name + " I am from "+city+" and I a proud citizen of the country " + country;
            }
        }

        // the thing is that now we will have a to use this class right here
        // creatying the class object
        MyInnerClass mic = new MyInnerClass();
        System.out.println(mic);
        System.out.println("This is one of the way to call a inner class from inosde  am,ethod");
    }
}


public class Apple {


    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Today we are going to see how we can use the inner class in three diffrent ways");
        System.out.println("There are three ways to use the inner class");
        System.out.println("Lets try to call the inner class");
        // let us first see the first method
        System.out.println("Enter name : ");
        String name = input.nextLine();
        System.out.println("Enter age : ");
        int age = Integer.parseInt(input.nextLine());
        System.out.println("Enter name of the city : ");
        String city = input.nextLine();
        System.out.println("Enter country name : ");
        String country = input.nextLine();

        OutterClass oc = new OutterClass(name,age,city);
        // this is how we call the inner class in java
        OutterClass.MyInnerClass mic = oc.new MyInnerClass();
        mic.greetingsFromInnerClass();
        System.out.println("This is how you call the inner class one of the ways");
        System.out.println("The other way ius toi direclty call the class inside a method defined in the outside class");
        ThisIsClass tic = new ThisIsClass(name,city,country);
        tic.getOneTrivia();
        input.close();
    }
}
