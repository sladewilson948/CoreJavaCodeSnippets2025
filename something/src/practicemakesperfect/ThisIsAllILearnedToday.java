package practicemakesperfect;

import java.util.Random;
import java.util.Scanner;



///  let us also now quickly do what is called as Upcasting and Down casting
///
///
///
///
// let us now see what we can do make use of generic

/// here we will define the class that will be extended by generic
///

class MyBike
{

    Random random = new Random();
    private int chassisNumber;
    private String modelNumber;
    private String color;
    private String brandName;
    private int bikePrice;


    public MyBike(String modelNumber, String color, String brandName, int bikePrice)
    {
        this.chassisNumber = random.nextInt(10000000);
        this.modelNumber = modelNumber;
        this.color = color;
        this.brandName = brandName;
        this.bikePrice = bikePrice;
    }

    @Override
    public String toString()
    {
        return "The model number of the bike is "+modelNumber+" the bike is a "+ color + " "+ brandName + " for a price of "+bikePrice;
    }

    public void someSpecificInfo()
    {
        System.out.println("This is a very nice Bike that you have got there!");
    }
}

class GenericPrinterBike <T extends MyBike>
{
    private T myBikeGeneric;

    public GenericPrinterBike(T myBikeGeneric)
    {
        this.myBikeGeneric = myBikeGeneric;
    }

    public void getSomeInfo()
    {
        System.out.println(myBikeGeneric);
        myBikeGeneric.someSpecificInfo();
    }

}


class GenericPrinterDataType <T>
{
    private T dataType;

    public GenericPrinterDataType(T dataType)
    {
        this.dataType = dataType;
    }

    @Override
    public String toString()
    {
        return "This is a data type of type "+ dataType;
    }
}

abstract class MyAnimal
{
    private String name;
    private int age;

    public MyAnimal(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public abstract void doSomething();

    public void makeNoises()
    {
        System.out.println("Wierd animal noises");
    }
}

class MyCat extends MyAnimal
{

    private String name;
    private int age;

    public MyCat(String name, int age) {
        super(name, age);
    }

    @Override
    public void doSomething() {
        System.out.println("I am just meowing around");
    }

    @Override
    public void makeNoises()
    {
        System.out.println("Meow Meow");
    }

}


class MyDog extends MyAnimal
{

    private String name;
    private int age;

    public MyDog(String name,int age)
    {
        super(name,age);
    }

    @Override
    public void doSomething()
    {
        System.out.println("Hi I am just barking around");
    }

    @Override
    public void makeNoises()
    {
        System.out.println("Bark Bark!!");
    }
}


// let also quickly add multiThreading

class MyMutliThreadOne extends Thread
{

    private int threadNumber;

    public MyMutliThreadOne(int threadNumber)
    {
        this.threadNumber = threadNumber;
    }

    @Override
    public void run()
    {
        for(int i=0;i<10;i++)
        {
            System.out.println("Hello this message is from thread "+threadNumber);
        }
    }

}

class MyMutliThreadTwo implements Runnable
{

    private int threadNumber;

    public MyMutliThreadTwo(int threadNumber)
    {
        this.threadNumber = threadNumber;
    }

    @Override
    public void run()
    {
        for(int i=0;i<10;i++)
        {
            System.out.println("Greeting this message is from thread "+ threadNumber);
        }
    }
}

class UsersNow
{
    Random random = new Random();
    private int id;
    private String name;
    private int age;
    private String city;
    private String country;


    ///  let's also create a default constructor


    public UsersNow(String name,int age,String city, String country)
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
        return "Hi my name is "+name + " I am "+age+ " years old." +" I am from "+ city+","+ country+". My id is"+id;
    }

    static class NewInnerClass
    {
        private String name;
        private String city;

        public NewInnerClass(String name,String city)
        {
            this.name = name;
            this.city = city;
        }

        @Override
        public String toString()
        {
            return "Hi my name is "+name+" and I am from "+city;
        }
    }


    class InnerClassNew
    {
        private String name;
        private int age;
        private String city;
        private String country;


        public InnerClassNew(String name,int age, String city, String country)
        {
            this.name = name;
            this.age = age;
            this.city = city;
            this.country = country;
        }


        @Override
        public String toString()
        {
            return "Hi my name is " + name+" I am "+ age+ " years old. I am from "+ city + ", "+country;
        }
    }

    ///  let us also define a method of type void where in we can use the

    public void greetFromInnerFunction()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Hi there I hope you are doing well");

        class InnerClass
        {

            private int id;
            private String name;
            private int age;
            private String city;
            private String country;


            public InnerClass(String name, int age, String city, String country)
            {
                this.id = random.nextInt(10000);
                this.age = age;
                this.name = name;
                this.city = city;
                this.country = country;
            }

            @Override
            public String toString()
            {
                return "Hi my name is "+ name+ "it was nice to meet you. I am "+ age + "years old. I am from "+city+","+country+"my id is "+id;
            }
        }

        System.out.println("It's time to ise the inner class right now");
        System.out.println("Please enter name : ");
        String name = input.nextLine();
        System.out.println("Please enter age : ");
        int age = Integer.parseInt(input.nextLine());
        System.out.println("Please enter city : ");
        String city = input.nextLine();
        System.out.println("Please enter country : ");
        String country = input.nextLine();

        ///  creating the inner class object here
        InnerClass innerClass = new InnerClass(name,age,city,country);
        System.out.println(innerClass);

    }

}



public class ThisIsAllILearnedToday {


    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Boy am I gonna have fun!!");
        System.out.println("Enter name : ");
        String name = input.nextLine();
        System.out.println("Enter age : ");
        int age = Integer.parseInt(input.nextLine());
        System.out.println("Enter city : ");
        String city = input.nextLine();
        System.out.println("Enter country : ");
        String country = input.nextLine();
        UsersNow usernow = new UsersNow(name,age,city,country);
        System.out.println("Time to use the inner class way 1");

        UsersNow.InnerClassNew icn = usernow.new InnerClassNew(name,age,city,country);
        System.out.println(icn);

        System.out.println("Time to use inner class way 2");
        UsersNow.NewInnerClass nic = new UsersNow.NewInnerClass(name,city);
        System.out.println(nic);

        System.out.println("Time to use the inner class way 3");
        usernow.greetFromInnerFunction();

        System.out.println("Now its time to make use of the Anonymous Inner Class");
        System.out.println("For that we need to create one more object of the UserNow class which we will modify accordingly");
        System.out.println("Please provide us with the details");
        System.out.println("Boy am I gonna have fun!!");
        System.out.println("Enter name : ");
        String name1 = input.nextLine();
        System.out.println("Enter age : ");
        int age1 = Integer.parseInt(input.nextLine());
        System.out.println("Enter city : ");
        String city1 = input.nextLine();
        System.out.println("Enter country : ");
        String country1 = input.nextLine();
        UsersNow usersnow = new UsersNow(name1,age1,city1,country1)
        {
          // what we can do is in here overwrite an existing methods inside the UserNow Class

          @Override
          public String toString()
          {
              return "Hi my name is "+name1+" and just know that I have overwritten your methods just like that";
          }
        };
        System.out.println("Here is the overridden method in action using anonymous class "+ usersnow);
        System.out.println("------------");
        System.out.println("Time to use the threads in java");
        for(int i=0;i<10;i++)
        {
            MyMutliThreadOne thread1 = new MyMutliThreadOne(i);
            MyMutliThreadTwo thread2 = new MyMutliThreadTwo(i);
            Thread thread = new Thread(thread2);
            // time to execute the threads
            thread1.start();
            thread.start();
            System.out.println("Thread execution completed!!");
        }


        ///  let us now see how we can make use of the Animal Class
        // time to make some animal class

        MyAnimal animal1 = new MyCat("Tom",10);
        MyAnimal animal2 = new MyDog("Charlie",12);

        doAnimalStuff(animal1);
        doAnimalStuff(animal2);

        input.close();
    }


    public static void doAnimalStuff(MyAnimal animal)
    {
        if(animal instanceof MyCat)
        {
            // this would mean we can type cast this animal object to a Cat object without getting Casting Error
            animal.doSomething();
            animal.makeNoises();
        }

        if(animal instanceof MyDog)
        {
            ///  this would mean we can do TypeCast i.e. down type cast Parent Class gets type cast to Child Class in this case
            ///  the dog class

            animal.doSomething();
            animal.makeNoises();
        }


    }
}
