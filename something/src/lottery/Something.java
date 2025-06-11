package lottery;
import java.util.Scanner;

class OutterClass
{
    public void greetFromOuter()
    {
        System.out.println("Greetings from the outer class");

        class InnerClass
        {
            private String name;
            private int age;
            private String city;
            private String country;

            public InnerClass(String name, int age, String city, String country)
            {
                this.name = name;
                this.age = age;
                this.city = city;
                this.country = country;
            }

            @Override
            public String toString()
            {
                return "Hi my name is '" + name + "' and I am from '" + city + "," +country + "' and I am '" +  age + "' years old";
            }

            public void greetFromInnerClass()
            {
                System.out.println("Hi my name is aman dubey");
            }
        }
        Scanner input = new Scanner(System.in);
        // to use the inner class provide the below details
        System.out.println("Please enter name : ");
        String name = input.nextLine();
        System.out.println("Please enter age : ");
        int age = Integer.parseInt(input.nextLine());
        System.out.println("Please enter city name : ");
        String city = input.nextLine();
        System.out.println("Please enter country name : ");
        String country = input.nextLine();

        InnerClass inner = new InnerClass(name,age,city,country);
        System.out.println(inner);
        inner.greetFromInnerClass();
        input.close();


    }
}

public class Something {

    public static void main(String[] args)
    {
        System.out.println("Hi welcome to my application");
        OutterClass outer = new OutterClass();
        outer.greetFromOuter();
    }
}
