package walmart.comperableVScomparator;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Main implements Comparable<Main> {

    private String name;
    private int age;

    public Main(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public String getName()
    {
        return name;
    }

    public int getAge()
    {
        return age;
    }

    @Override
    public String toString()
    {
        return "Hi my name is "+name+" I am "+age+" years old.";
    }


    public static void main(String[] args)
    {
        List<Main> people = Arrays.asList(
                new Main("Aman Dubey",27),
                new Main("Archita Dubey",22),
                new Main("Sharda Dubey",20)
        );
        Collections.sort(people);
        for(Main p: people)
        {
            System.out.println(p);
        }

    }

    @Override
    public int compareTo(Main o)
    {
        return this.name.compareTo(o.name);
    }
    // if we want to sort them based on age we can do this
}
