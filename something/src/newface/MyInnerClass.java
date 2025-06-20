package newface;

import java.util.Scanner;
import java.util.Random;

class BroskiThisISSomethingElse {

    private int tourid;
    private String artistName;
    private String contact;
    private String tourName;
    Random random = new Random();

    public BroskiThisISSomethingElse()
    {
        this("Drake","number - 000000","Anita Max Wyn");
    }

    public BroskiThisISSomethingElse(String artistName, String contact, String tourName){
        this.tourid = random.nextInt();
        this.artistName = artistName;
        this.contact = contact;
        this.tourName = tourName;
    }

    @Override
    public String toString()
    {
        return "Hi weclome to the "+artistName + " tour "+tourName + ", for booking call "+contact;
    }

    public String artistSings()
    {
        return "la la lallla alallala";
    }
}


class TheOtherOuterClass
{

    static class TheOtherInnerClass
    {
        private int id;
        private String name;
        private String city;
        private String contact;
        private String country;
        Random random = new Random();


        public TheOtherInnerClass(String name, String city, String contact, String country)
        {
            this.id = random.nextInt(100000);
            this.name = name;
            this.city = city;
            this.contact = contact;
            this.country = country;
        }

        public TheOtherInnerClass()
        {
            this("Aman Dubey","Varanasi","9123589087","India");
        }

        @Override
        public String toString()
        {
            return "Hi my name is "+name+ " and I am from "+city+", " +country+" and you can call me at "+contact;
        }

        public String getUserContact()
        {
            return contact;
        }



    }
}

class OuterClass
{

    class InnerClass
    {

        private String name;
        private int age;
        private String contact;
        private String city;


        public InnerClass(String name, int age, String contact, String city)
        {
            this.name = name;
            this.age = age;
            this.contact = contact;
            this.city = city;
        }

        @Override
        public String toString()
        {
            return "Hi my name is "+name+" I am "+ age+" years old." + " I am from "+city+" and you call me at "+contact;
        }

        public void getUserNameInUpperCase()
        {
            System.out.println(name.toUpperCase());
        }
    }
}


class UserDetails
{

    private int id;
    private String name;
    private String city;
    private String contact;
    Random random = new Random();

    public UserDetails(String name,String city, String contact)
    {
        this.id = random.nextInt(1000);
        this.name = name;
        this.city = city;
        this.contact = contact;
    }

    public void someFunctionToUse()
    {
        System.out.println("Its time to use the inner class now");
        class MyInnerClass
        {

            private String name;
            private int age;
            private String city;


            public MyInnerClass(String name, int age, String city)
            {
                this.name = name;
                this.age = age;
                this.city = city;
            }

            public void thisIsMyFunction()
            {
                System.out.println("Hi I am calling from the innner function");
            }
        }

        System.out.println("We are going to use the inner class here");
        MyInnerClass myInnerClass = new MyInnerClass("Rachel Mc Adams",27,"LA, California");
        myInnerClass.thisIsMyFunction();
    }
}

public class MyInnerClass {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("In this program we will see all the types of inner classes");
        System.out.println("This is one way to use inner class in Java");
        System.out.println("Enter name : ");
        String name = input.nextLine();
        System.out.println("Enter city : ");
        String city = input.nextLine();
        System.out.println("Enter contact : ");
        String contact = input.nextLine();
        UserDetails userDetails = new UserDetails(name, city, contact);
        System.out.println("Time to trigger the inner class by calling method");
        userDetails.someFunctionToUse();
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("Time to use the second way");
        OuterClass myobj = new OuterClass();
        OuterClass.InnerClass myIner = myobj.new InnerClass("Aman Dubey", 27, "981723891293", "Bangalore");
        myIner.getUserNameInUpperCase();
        System.out.println("Let us now see the other way to use the inner class");
        TheOtherOuterClass theOtherOuterClass = new TheOtherOuterClass();
        TheOtherOuterClass.TheOtherInnerClass theOtherInnerClass = new TheOtherOuterClass.TheOtherInnerClass();
        System.out.println(theOtherInnerClass.getUserContact());
        System.out.println(" ");
        System.out.println("Now we will take a look how to use Anonymous inner class in the code");
        System.out.println("Lets go");
        BroskiThisISSomethingElse broskiThisISSomethingElse = new BroskiThisISSomethingElse("Gunna", "9123123123", "The Gunna Wunna");
        BroskiThisISSomethingElse broskiThisISSomethingElse1 = new BroskiThisISSomethingElse(){

            @Override
            public String artistSings()
            {
                return "TAY KEITH BLESS THESE PEOPLE UP!!!";
            }

        };
        System.out.println(broskiThisISSomethingElse1.artistSings());
        System.out.println(broskiThisISSomethingElse.artistSings());

        input.close();
    }
}
