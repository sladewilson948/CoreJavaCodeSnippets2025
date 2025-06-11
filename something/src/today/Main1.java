package today;
import java.util.Scanner;
import java.util.Random;



class Outer
{
    Scanner input = new Scanner(System.in);

    public void greetUserFromOuter()
    {
        System.out.println("Hi there welcome to the java program outer class");
    }

    public void innerMethod()
    {
        System.out.println("Hi there now we are entering the inner class");

        class Inner
        {
            private int id;
            private String name;
            private int age;
            private String city;
            private String country;


            public Inner(String name, int age, String city, String country)
            {
                this.id = new Random().nextInt(1000);
                this.name = name;
                this.age = age;
                this.city = city;
                this.country = country;
            }


            @Override
            public String toString()
            {
                return "User : " + id + ", Hi my name is" + name + "  and I am "+age+" years old and I live in "
                        + city +" it was nice meeting you all. "+" I am from "+country;
            }
        }

        // time to use this inner class

        System.out.println("Please provide with the required details");
        System.out.println("Please enter your name : ");
        String name = input.nextLine();
        System.out.println("Please enter your age : ");
        int age = Integer.parseInt(input.nextLine());
        System.out.println("Please enter your city : ");
        String city = input.nextLine();
        System.out.println("Please enter your country : ");
        String country = input.nextLine();


        // creating the Inner class object
        Inner inner = new Inner(name,age,city,country);
        System.out.println(inner);
    }




}



public class Main1 {


    public static void main(String[] args)
    {
        System.out.println("Welcome to the program");
        System.out.println("We will see what are the three ways to use inner classes in Java");
        // making the object for the outer class
        Outer outer = new Outer();
        outer.greetUserFromOuter();
        outer.innerMethod();
    }
}
