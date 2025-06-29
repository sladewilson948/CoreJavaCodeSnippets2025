package repetition.kzujfd;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.UUID;

class UserDetails
{

    private final UUID id;
    private final String name;
    private final String city;
    private final String country;
    private final int salary;


    public UserDetails(String name, String city, String country, int salary)
    {
        this.id = UUID.randomUUID();
        this.name = name;
        this.city = city;
        this.country = country;
        this.salary = salary;
    }

    @Override
    public String toString()
    {
        return "UserDetails("+id+", "+name+", "+city+", "+country+", "+salary+")";
    }

    public String getName()
    {
        return name;
    }

    public String getCity()
    {
        return city;
    }

    public String getCountry()
    {
        return country;
    }

    public UUID getId()
    {
        return id;
    }

    public void meow()
    {
        System.out.println("I am just meowing around!!");
    }

    public void greetMe(String name, int age)
    {
        System.out.println("Hi my name is "+name+" and I am "+age+" years old");
    }

    private void doSomething()
    {
        System.out.println("He this is a private method!! how did you call it ?");
    }


    public static void publicStaticMethod()
    {
        System.out.println("This is a public static method");
    }

    private static void privateStaticMethod()
    {
        System.out.println("This is a private static method");
    }


}


public class Reflect {


    public static void main(String[] args) throws Exception {
        UserDetails userDetails = new UserDetails("Aman Dubey","Bangalore","India",650000);
        System.out.println("We can see the structure of our object class");
        System.out.println(userDetails);
        Field[] declaredFields = userDetails.getClass().getDeclaredFields();
        for(Field field: declaredFields)
        {
            if(field.getName().equals("name"))
            {
                field.setAccessible(true);
                field.set(userDetails, "Rachel Mc  Adamas");
            }
        }
        System.out.println(userDetails);
        System.out.println("So we saw how we were able to chnage all the fileds name even tho they were private and final");
        System.out.println("This just goes to show that we can really do whataeerv we want");
        System.out.println("Now its time to make use of the methdso in class");
        Method[] declaredMethod = userDetails.getClass().getDeclaredMethods();

        for(Method method: declaredMethod)
        {
            if(method.getName().equals("meow"))
            {
                method.invoke(userDetails);
            }
            if(method.getName().equals("greetMe"))
            {
                method.invoke(userDetails,"Aman Dubey",24);
            }
            if(method.getName().equals("doSomething"))
            {
                method.setAccessible(true);
                method.invoke(userDetails);
            }
            if(method.getName().equals("publicStaticMethod"))
            {
                method.invoke(null);
            }
            if(method.getName().equals("privateStaticMethod"))
            {
                method.setAccessible(true);
                method.invoke(null);
            }

        }
    }
}
