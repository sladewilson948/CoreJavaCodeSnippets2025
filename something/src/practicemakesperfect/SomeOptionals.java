package practicemakesperfect;
import java.util.Scanner;
import java.util.Random;




class SomeHero
{

    private int id;
    private String name;
    private String city;
    private int age;
    private String country;
    Random random = new Random();

    public SomeHero(String name, String city, int age, String country)
    {
        this.id = random.nextInt();
        this.name = name;
        this.city = city;
        this.age = age;
        this.country = country;

    }

    public int getId()
    {
        return this.id;
    }
    public String getName()
    {
        return this.name;
    }

    @Override
    public String toString()
    {
        return "Hi my name is "+name+ " and I am from "+city+","+country +". I am "+age+ " years old." + "I am id is "+id;
    }
}


public class SomeOptionals {

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("We will be playing with some optionals today.");
        input.close();
    }
}
