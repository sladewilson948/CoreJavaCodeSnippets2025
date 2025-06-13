package practicemakesperfect;
import java.util.*;


class YourUsers
{
    Random random = new Random();
    private int id;
    private String name;
    private String city;
    private String country;


    public YourUsers(String name, String city, String country)
    {
        this.id = random.nextInt(10000);
        this.name = name;
        this.city = city;
        this.country = country;
    }

    @Override
    public String toString()
    {
        return "Hi my name is "+name+ " and I am from "+city+","+country+". My id is "+id;
    }

    public String userSpecificMethod()
    {
        return "This is a user specific method I need you to keep that in mind";
    }

    public String getName()
    {
        return this.name;
    }
}

class YourGenericPrinter <T>
{
    private T genericValue;

    public YourGenericPrinter(T genericValue)
    {
        this.genericValue = genericValue;
    }

    @Override
    public String toString()
    {
        return "Hi this is a generic printer for the value "+genericValue;
    }
}


class YourGenericClassPrinter <T extends YourUsers>
{
    private T genericUser;

    public YourGenericClassPrinter(T genericUser)
    {
        this.genericUser = genericUser;
    }

    public T getGenericUser() {
        return genericUser;
    }

    @Override
    public String toString()
    {
        return "Hi this is a generic class of the type user that you provided "+ genericUser.userSpecificMethod() + " "+genericUser.getName();
    }
}

public class MyGenerics {

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        YourGenericPrinter<String> stringGeneric = new YourGenericPrinter<>("Something about you");
        YourGenericPrinter<Float> floatGeneric = new YourGenericPrinter<>(23.45f);
        YourGenericPrinter<Integer> integerGeneric = new YourGenericPrinter<>(1234);
        System.out.println(stringGeneric);
        System.out.println(floatGeneric);
        System.out.println(integerGeneric);
        ///  now let us try to make use of the class that we have
        System.out.println("Please provide us with the required details");
        System.out.println("Please enter your name : ");
        String name = input.nextLine();
        System.out.println("Please enter your city name : ");
        String city = input.nextLine();
        System.out.println("Please enter your country name : ");
        String country = input.nextLine();

        YourUsers users = new YourUsers(name,city,country);
        YourGenericClassPrinter<YourUsers> classGeneric = new YourGenericClassPrinter<>(users);
        System.out.println(classGeneric);

        System.out.println("Let us now see how we can print a lot of diffrent types of data");
        List<String> list1 = new ArrayList<>(Arrays.asList("Aman","Archita","Mukesh","Sharda","Charlie"));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(1,2,33,4,33,4,55,6,77,8,999,3));
        List<YourUsers> list3 = new ArrayList<>();
        list3.add(new YourUsers("Aman Dubey","Varanasi","India"));
        list3.add(new YourUsers("Mukesh Dubey","Bangalore","India"));
        list3.add(new YourUsers("Archita Dubey","Mumbai","India"));

        System.out.println("Time to call the universal printer");
        universalPrinter(list1);
        universalPrinter(list2);
        universalPrinter(list3);

        System.out.println("Now let us also see the use of generic methods in java");
        giveShoutOut("Aman Dubey. He is a fucking legend", new YourUsers("Slade Wilson","Bangalore","India"));
        input.close();
    }

    public static void universalPrinter(List<?> objects)
    {
        for(Object obj: objects)
        {
            System.out.println(obj);
        }
    }

    public static <T,V> void giveShoutOut(T genericTypeT, V genericTypeV)
    {
        System.out.println("Hey shoutout to "+genericTypeT);
        System.out.println("Hey shoutout to "+genericTypeV);
    }
}
