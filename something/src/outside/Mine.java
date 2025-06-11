/// in this example we will see the other way to make and use of the inner class
package outside;
import java.util.Scanner;
import java.util.Random;



class Outer
{

    public void greetFromOuter()
    {
        System.out.println("Hi there welcome to the outer class!!!");
    }

    static class InnerClass
    {
        /// we will do evrything in here
        private int id;
        private String name;
        private int age;
        private String city;
        private String country;

        Random rand = new Random();

        public InnerClass(String name, int age, String city, String country)
        {
            this.id = rand.nextInt(10000);
            this.name = name;
            this.age = age;
            this.city = city;
            this.country = country;
        }


        /// defining some methods

        @Override
        public String toString()
        {
            return "Hi my name is "+name + "I am from "+country + " It was nice meeting you";
        }
    }
}

public class Mine {


    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Hi there welcome to the program where we will use the inner class from within inner class");
        System.out.println("Please enter your name");
        String name = input.nextLine();
        System.out.println("Please enter age : ");
        int age = Integer.parseInt(input.nextLine());
        System.out.println("Please enter your city name : ");
        String city = input.nextLine();
        System.out.println("Please enter your country name : ");
        String country = input.nextLine();


        Outer outer = new Outer();
        outer.greetFromOuter();
        // creating inner class Object

        Outer.InnerClass inner = new Outer.InnerClass(name,age,city,country);
        System.out.println(inner);
        input.close();
    }
}
