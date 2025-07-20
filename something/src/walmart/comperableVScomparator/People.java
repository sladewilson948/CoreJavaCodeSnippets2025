package walmart.comperableVScomparator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class People {

    private String name;
    private int salary;
    private String city;
    private int age;
    private int randomNumber;
    private static final Random random = new Random();

    public People(String name, int salary, String city, int age)
    {
        this.name = name;
        this.salary = salary;
        this.city = city;
        this.age = age;
        this.randomNumber = random.nextInt(1000);
    }

    public String getName()
    {
        return name;
    }

    public String getCity()
    {
        return city;
    }

    public int getSalary()
    {
        return salary;
    }

    public int getAge()
    {
        return age;
    }

    public int getRandomNumber()
    {
        return randomNumber;
    }

    @Override
    public String toString()
    {
        return "Name "+name+", age : "+age+", city : "+city+", salary : "+salary+", random number : " +randomNumber;
    }

    public static void main(String[] args)
    {
        System.out.println("Time to make some people object");
        List<People> people = Arrays.asList(
                new People("Aman Dubey",23000,"Varanasi",37),
                new People("Sharda Dubey",123000,"Los Angeles",27),
                new People("Mukesh Dubey",233000,"Florida",21),
                new People("Rachel Weisz",232000,"Utah",47),
                new People("Christain Bale",233000,"Smallville",17),
                new People("Tom Hidilston",230004,"Gotham",29)
        );


        System.out.println("Sorted by age");
        people.sort(Comparator.comparing(People::getAge));
        runForLoop(people);
        System.out.println(" ");
        System.out.println("Sorted by random number");
        people.sort(Comparator.comparing(People::getRandomNumber));
        runForLoop(people);
        System.out.println(" ");
        System.out.println("Sorted by salary");
        people.sort(Comparator.comparing(People::getSalary));
        runForLoop(people);
        System.out.println(" ");
        System.out.println("Sorted by name but in reverse");
        people.sort(Comparator.comparing(People::getName).reversed());
        runForLoop(people);


    }

    public static void runForLoop(List<People> people)
    {
        for(People people1: people)
        {
            System.out.println(people1);
        }
    }
}
