package fullsend.innerclass;
import java.util.Scanner;
import java.util.Random;

// I am going to define a Class here and then we will kind of make a subclass out iof it with no name with ease

class SomeThingAboutYou
{

    private int id;
    private String name;
    private int waistInInches;
    private int weightInKg;
    private float height;
    private String eyeColor;
    private String favFood;


    public SomeThingAboutYou(String name, int waistInInchesm, int weightInKg, float height, String eyeColor, String favFood)
    {
        Random random = new Random();
        this.id = random.nextInt(100000);
        this.name = name;
        this.waistInInches =waistInInchesm;
        this.weightInKg = weightInKg;
        this.height = height;
        this.eyeColor = eyeColor;
        this.favFood = favFood;
    }

    // some random function right here
    public void modelDoesRampWalk()
    {
        System.out.println(".... tick tock tick tock");
    }


}



class NewRegistry
{


    static class InnerClassTwo
    {
        private int id;
        private String name;
        private int age;
        private String city;
        private String country;
        Random random = new Random();

        public InnerClassTwo(String name, int age, String city, String country)
        {
            this.id = random.nextInt(1000);
            this.name = name;
            this.age = age;
            this.city = city;
            this.country = country;
        }


        @Override
        public String toString()
        {
            return "Hi this is from inner class two "+
                    "my name is " + name + " and I am from "
                    +city+", "+country+" and my id is "+id;
        }
    }

    class InnerClassOne
    {
        private int id;
        private String name;
        private int age;
        private String city;
        private String country;
        Random random = new Random();


        public InnerClassOne(String name, int age, String city, String country)
        {
            this.id = random.nextInt(1000);
            this.name = name;
            this.age = age;
            this.city = city;
            this.country = country;
        }

        @Override
        public String toString()
        {
            return "Hi my name is "+name+ " and I am from "+city+", "+country+" and I am "+age+" years old.";
        }

        public int getId()
        {
            return id;
        }
    }


}


class User
{
    ///  this is way one to deal with inner functions
    private int id;
    private String name;
    private String city;
    private int age;
    private String country;
    Random random = new Random();

    public User(String name, String city, int age, String country)
    {
        this.id = random.nextInt();
        this.name = name;
        this.city = city;
        this.age = age;
        this.country = country;
    }


    @Override
    public String toString()
    {
        return "Hi this is the outter class";
    }

    public String getUserDetail()
    {
        return "Hi my name is "+name+" and I am from "+city+", "+country+" I am "+age+" years old";
    }

    public void firstInnerFunctionCall()
    {

        class Aman
        {
            private String city;
            private String address;
            private int age;


            public Aman(String city, String address, int age)
            {
                this.city = city;
                this.address = address;
                this.age = age;
            }

            @Override
            public String toString()
            {
                return "Hi my name is Aman and "+ " I live in "+city+" and my address is "+address +" and I am "+age+" years old";
            }

        }
        Scanner input = new Scanner(System.in);
        System.out.println("Time to call the class from this method");
        System.out.println("Creating inner class object");
        System.out.println("Enter city name : ");
        String city = input.nextLine();
        System.out.println("Enter address : ");
        String address = input.nextLine();
        System.out.println("Enter age here : ");
        int age = Integer.parseInt(input.nextLine());
        Aman aman = new Aman(city,address,age);
        System.out.println(aman);
        input.close();
    }

}

public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Shi getting really spooky out here!!!!");
        System.out.println("Lets try to first use the inner function via the function");
        User user = new User("Aman Dubey","Varanasi",27,"India");
        System.out.println(user);
        user.getUserDetail();
        user.firstInnerFunctionCall();
        System.out.println("Now let us try to use the inner class from New Registry");
        NewRegistry newRegistry = new NewRegistry();
        NewRegistry.InnerClassOne innerClassOne = newRegistry.new InnerClassOne("Archita Dubey",22,"Mumbai","India");
        System.out.println(innerClassOne);
        System.out.println(innerClassOne.getId());
        System.out.println("Now let us try to call the inner class which has been declared as static");
        NewRegistry.InnerClassTwo innerClassTwo = new NewRegistry.InnerClassTwo("Sharda Dubey",22,"Balia","India");
        System.out.println(innerClassTwo);
        System.out.println("This is how we define all these inner classes and call them accordingly");
        System.out.println("Now as a final touch let us also try to see how we can implement the anonymous inner classes");
        SomeThingAboutYou someThingAboutYou = new SomeThingAboutYou("Avanati Nagrath",24,47,1.75f,"Brown","Pizza");
        SomeThingAboutYou someThingAboutYou1 = new SomeThingAboutYou("Akshar ShivKumar",23,45,1.65f,"Hazel","Podi"){

            @Override
            public void modelDoesRampWalk() {
                System.out.println("Tose naina lage jiya savareeee!!!!");
            }
        };

        someThingAboutYou.modelDoesRampWalk();
        someThingAboutYou1.modelDoesRampWalk();
        input.close();
    }

}