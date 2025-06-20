package outside;
import java.util.Scanner;


class OutterClass
{

    public void insideInnerClass()
    {
        System.out.println("Welcome to the innner class");

        class InnerClass
        {
            private int age;
            private String name;
            private String city;
            private String country;

            public InnerClass(int age, String name, String city, String country)
            {
                this.age = age;
                this.name = name;
                this.city = city;
                this.country = country;
            }

            @Override
            public String toString()
            {
                return "Hi my name is '" + name + "' and I am from '" + city +", "+ country + "'";
            }


            public void greetingFromInner()
            {
                System.out.println("Welcome to inner class!!");
            }
        }

        Scanner input = new Scanner(System.in);
        System.out.println("Please provide me the details");
        int age = Integer.parseInt(input.nextLine());
        System.out.println("Please enter your name : ");
        String name = input.nextLine();
        System.out.println("Please enter your city : ");
        String city = input.nextLine();
        System.out.println("Please enter your country : ");
        String country = input.nextLine();

        /// creating the inner class Object
        InnerClass inner = new InnerClass(age,name,city,country);
        System.out.println(inner);
        inner.greetingFromInner();

    }

}

public class Main {

    public static void main(String[] args)
    {
        OutterClass outer = new OutterClass();
        outer.insideInnerClass();
    }
}
