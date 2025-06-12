package practicemakesperfect;
import java.util.*;


class SomeUsers
{

    private int id;
    private String name;
    private int age;
    private String city;
    private String country;
    Random random = new Random();

    // let us also define a noArgsConstructor for our clas

    public SomeUsers()
    {
        this("Aman Dubey",27,"Varanasi","India");
    }

    public SomeUsers(String name, int age, String city, String country)
    {
        this.id = random.nextInt(10000);
        this.name = name;
        this.age = age;
        this.city = city;
        this.country = country;
    }


    @Override
    public String toString()
    {
        return "Hi my name is "+name+ " and I am from "+city+","+country + " and I am "+age+" years old.";
    }
    
    public String someInfo()
    {
        return "Hi my name is Generic Speciofc to user class";
    }

}

// let us create a generic class that extends the SomeUsers class meaning that it will be a bounded generic all the types will be fixed to instances of this SomeUsers class

class SpecifcGenericPrinter <T extends SomeUsers>
{

    // here we are specifing that the genric will be if typoe SoemUser so we can access the methods it has
    private T genericValue;
    
    public SpecifcGenericPrinter(T genericValue)
    {
        this.genericValue = genericValue;
    }

    public void print()
    {
        System.out.println(genericValue.someInfo());
        System.out.println(genericValue);
    }

}

class GenericPrinter <T>
{
    private T genericValue;

    public GenericPrinter(T genericValue)
    {
        this.genericValue = genericValue;
    }

    public void setGenericValue(T genericValue)
    {
        this.genericValue = genericValue;
    }

    public T getGenericValue()
    {
        return this.genericValue;
    }
}


public class JavaGenerics
{

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Let us now create a generic object");
        System.out.println("Please enter a name here");
        System.out.println("Please enter a int here");
        System.out.println("Please enter a float here");
        String line = input.nextLine();
        int number = Integer.parseInt(input.nextLine());
        float floatNum = Float.parseFloat(input.nextLine());
        GenericPrinter<String> stringPrinter = new GenericPrinter<>(line);
        GenericPrinter<Integer> integerPrinter = new GenericPrinter<>(number);
        GenericPrinter<Float> floatPrinter = new GenericPrinter<>(floatNum);
        GenericPrinter<SomeUsers> userPrinter = new GenericPrinter<>(new SomeUsers());

        // now we can use the objects
        System.out.println(stringPrinter.getGenericValue());
        System.out.println(integerPrinter.getGenericValue());
        System.out.println(floatPrinter.getGenericValue());
        System.out.println(userPrinter.getGenericValue());

        System.out.println("Let us make a user specific generic printer");
        System.out.println("Please provide us with the required details");
        System.out.println("Enter name  : ");
        String name = input.nextLine();
        System.out.println("Enter age : ");
        int age = Integer.parseInt(input.nextLine());
        System.out.println("Enter city : ");
        String city = input.nextLine();
        System.out.println("Enter country : ");
        String country = input.nextLine();

        SpecifcGenericPrinter<SomeUsers> sgp = new SpecifcGenericPrinter<>(new SomeUsers(name,age,city,country));
        shout("Aman",new SomeUsers(name,age,city,country));
        sgp.print();

        List<Integer> arr1 = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,76,7,88,301));
        List<SomeUsers> arr2 = new ArrayList<>(Arrays.asList(new SomeUsers()));
        List<Float> arr3 = new ArrayList<>(Arrays.asList(4.45f,5.56f,43.44f));

        System.out.println("Using generics lists to print some values ");
        printObjectsFromList(arr1);
        printObjectsFromList(arr2);
        printObjectsFromList(arr3);

        input.close();
    }


    public static <T,V> void shout(T thingToShoutout, V otherThingToShoutOut)
    {
        System.out.println("HEY SHOUTOUT TO "+ thingToShoutout);
        System.out.println("HEY SHOUTOUT TO "+ otherThingToShoutOut);
    }

    // we want to take a list that can take ny types of Objects

    public static void printObjectsFromList(List<?> myObjectList)
    {
        for(Object item:myObjectList)
        {
            System.out.print(item + " ");
        }
        System.out.println("\n");
    }

}