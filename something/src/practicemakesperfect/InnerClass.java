package practicemakesperfect;
import java.util.Random;
import java.util.Scanner;



/// let us now see the last way where we can use static keyword for our class name to ease out the contrutot making process


class OuterClassThree

{

    static class MyInnerClassThree
    {

        private int id;
        private String name;
        private int age;
        private String city;
        private String country;
        Random rand = new Random();


        public MyInnerClassThree(String name, int age, String city, String country)
        {
            this.id = rand.nextInt(10000);
            this.name = name;
            this.age = age;
            this.city = city;
            this.country = country;
        }


        @Override
        public String toString()
        {
            return "Hi my name is "+name +" and I am from "+city
                    +". I am a proud citizen of "+country+ " and my ID is "+id;
        }
    }
}


/// let us create one more Outer Class

class OuterClassTwo
{

    class MyInnerClassTwo
    {
        private int id;
        private String name;
        private int age;
        private String city;
        private String country;
        Random rand = new Random();


        public MyInnerClassTwo(String name,int age,String city, String country)
        {
            this.id = rand.nextInt(10000);
            this.name = name;
            this.age = age;
            this.city = city;
            this.country = country;
        }


        @Override
        public String toString()
        {

            return "Hi my name is "+name+" and I am "+age+ "years old."
                    + " I am from "+city+","+country+". It was nice meeting you all";
        }


    }
}


class OuterClassOne
{

    public String greetFromOuterClass()
    {
        return "Hi there I am writing from outer class";
    }

    public void greetUser()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Hi this is to tell you that the inner class begins now");
        //// we can drfine the inner class here
        // also one thing to note is that we will have to usee this class right here in this function called greetUser
        class MyInnerClass
        {
            private int id;
            private String name;
            private int age;
            private String city;
            private String country;

            Random rand = new Random();

            public MyInnerClass(String name,int age, String city, String country)
            {
                this.id = rand.nextInt(1000);
                this.name = name;
                this.age = age;
                this.city = city;
                this.country = country;
            }


            @Override
            public String toString()
            {
                return "Hi my name is "+name+ " and I am from "
                        + city +", " + country + ". I am "+age+" years old!.";
            }

            public String oneIntrestingFact()
            {
                int x = rand.nextInt(1000);
                return x>500 ? "Did you know "+x+" is greater than 500" :"Did you know "+x+" is less than 500";
            }

        }

        /// now its time to use this class right here
        System.out.println("Hi please provide us with the required details");
        System.out.println("Please enter your name");
        String name = input.nextLine();
        System.out.println("Please enter your age : ");
        int age = Integer.parseInt(input.nextLine());
        System.out.println("Please enter your city name : ");
        String city = input.nextLine();
        System.out.println("Please enter your country name : ");
        String country = input.nextLine();

        MyInnerClass mic = new MyInnerClass(name,age,city,country);
        System.out.println(mic);
        System.out.println(mic.oneIntrestingFact());
    }
}

public class InnerClass {


    public static void main(String[] args)
    {
        System.out.println("In this program we will see how we can make use of the Inner Classes in Java in three possible ways");
        System.out.println("Hi my name is Aman Dubey");
        Scanner input = new Scanner(System.in);
        /// make the outer class object here
        OuterClassOne oco = new OuterClassOne();
        System.out.println(oco.greetFromOuterClass());
        oco.greetUser();


        /// l;ets call the outer call two object and uinsg that cereate the inner class ojct
        OuterClassTwo oct = new OuterClassTwo();
        /// this is how we create the object for the inner class defined inside the OuterClassTwo
        System.out.println("Please enter name : ");
        String name = input.nextLine();
        System.out.println("Please enter age : ");
        int age = Integer.parseInt(input.nextLine());
        System.out.println("Please enter city name : ");
        String city = input.nextLine();
        System.out.println("Please enter country name : ");
        String country = input.nextLine();
        OuterClassTwo.MyInnerClassTwo mict = oct.new MyInnerClassTwo(name,age,city,country);
        System.out.println(mict);


        /// creating the outerclass three inner class object
        // simple as that easy peasy
        System.out.println("Please enter name : ");
        String name1 = input.nextLine();
        System.out.println("Please enter age : ");
        int age1 = Integer.parseInt(input.nextLine());
        System.out.println("Please enter city name : ");
        String city1 = input.nextLine();
        System.out.println("Please enter country name : ");
        String country1 = input.nextLine();
        OuterClassThree.MyInnerClassThree mictt = new OuterClassThree.MyInnerClassThree(name1,age1,city1,country1);
        System.out.println(mictt);

        input.close();
    }
}
