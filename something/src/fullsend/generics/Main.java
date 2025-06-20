package fullsend.generics;
import java.util.*;

class User
{

    private int id;
    private String name;
    private int age;
    private String city;
    private String country;
    Random random = new Random();

    public User(String name, int age, String city, String country)
    {
        this.id = random.nextInt(10000);
        this.name = name;
        this.age = age;
        this.city = city;
        this.country = country;
    }

    public String userGenericMethod()
    {
        return "Hi I am a user generic method it was nice meeting you";
    }

    @Override
    public String toString()
    {
        return "Hi my name is user "+name+" and I am from "+city+","+country+" and I am "+age+" years old.";
    }
}


// let use define a genric type

class GenericValueType <T>
{
    private T genericValue;

    public GenericValueType(T genericValue)
    {
        this.genericValue = genericValue;
    }

    public T getGenericValue()
    {
        return genericValue;
    }

    @Override
    public String toString() {
        return "This is a generic printer for the type " + genericValue;
    }
}

class GenericClassType <T extends User>
{

    private T genericUser;

    public GenericClassType(T genericUser)
    {
        this.genericUser = genericUser;
    }


    @Override
    public String toString()
    {
        return "Hi this object is an instance of "+genericUser + genericUser.userGenericMethod();
    }


}


public class Main {


    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("In this java program we will look into Java Generics");
        System.out.println("Lets try to print these values");
        GenericValueType<String> stringGeneric = new GenericValueType<>("Hi my name is aman dubey");
        GenericValueType<List<String>> listStringGeneric = new GenericValueType<>(Arrays.asList("Hi","my","name","is","aman","dubey"));
        GenericValueType<List<Float>> floatGeneric = new GenericValueType<>(Arrays.asList(1.23f,4.56f,56.67f));
        System.out.println(stringGeneric.getGenericValue());
        System.out.println(floatGeneric.getGenericValue());
        System.out.println(listStringGeneric.getGenericValue());
        System.out.println(" ");
        System.out.println("Let us now try to run our global printer on this");
        globalPrinter(listStringGeneric.getGenericValue());
        globalPrinter(floatGeneric.getGenericValue());

        List<User> userList = new ArrayList<>(Arrays.asList(
                new User("Aman Dubey",22,"Bangalore","India"),
                new User("Archita Dubey",18,"Mumbai","India"),
                new User("Mukesh Dubey",22,"Varanasi","India"),
                new User("Sharda Dubey",22,"Balia","India"),
                new User("Charlie Singh",22,"Banaras","India")
        ));

        globalPrinter(userList);

        shoutout(listStringGeneric,floatGeneric);

        input.close();
    }

    public static void globalPrinter(List<?> Object)
    {
        for(Object object: Object)
        {
            System.out.println("This is a global printer and the value is "+object);
        }
    }

    public static <T,V> void shoutout(T genericType1, V genericType2)
    {
        System.out.println("Shoutout to "+genericType1);
        System.out.println("Shoutout to "+genericType2);
    }
}
