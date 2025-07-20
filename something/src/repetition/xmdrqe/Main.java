package repetition.xmdrqe;

import java.util.Scanner;
import java.util.UUID;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;


class Outer
{

    public class FirstInnerClass
    {
        private final UUID id;
        private final String name;
        private final String city;
        private final String country;
        private final int randomInt;
        private static final Random random = new Random();

        public FirstInnerClass(String name, String city, String country)
        {
            this.id = UUID.randomUUID();
            this.name = name;
            this.city = city;
            this.country = country;
            this.randomInt = new AtomicInteger(457).get()+random.nextInt(1000);
        }

        // default constructor

        public FirstInnerClass()
        {
            this("Aman Dubey","Varanasi","Inida");
        }

        @Override
        public String toString()
        {
            return "Hi my name is "+name+" my id is "+id+" I am from "+city+", "+country+" and my random int is "+randomInt;
        }

    }
}

public class Main {


    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("We finna go crazy fr");
        System.out.println("Time to create outer class object");
        Outer outer = new Outer();
        Outer.FirstInnerClass firstInnerClass = outer.new FirstInnerClass("Mukesh Dubey","Varanasi","India");
        System.out.println("Object created for first inner class "+firstInnerClass);
        Outer.FirstInnerClass firstInnerClass1 = outer.new FirstInnerClass();
        System.out.println("This is the object created using the default constructor "+firstInnerClass1);
        input.close();
    }
}
