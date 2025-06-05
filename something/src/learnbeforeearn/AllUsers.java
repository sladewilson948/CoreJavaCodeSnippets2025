package learnbeforeearn;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;


class PeopleLists
{


    private List<People> peopleList;

    public PeopleLists()
    {
        this.peopleList = new ArrayList<>();
    }

    public void addPeopleToList(People people)
    {
        peopleList.add(people);
        System.out.println("Added the person to the list");
    }

    public void displayAllPeople()
    {
        for(People people: peopleList)
        {
            System.out.println(people);
        }
    }

}


class People
{

    private String name;
    private int age;
    private String city;
    private static int count;
    private String country;


    public People(String name, int age, String city, String country)
    {
        this.name = name;
        this.age = age;
        this.city = city;
        this.country = country;
        updateUserCount();
    }

    public void updateUserCount()
    {
        count+=1;
    }

    public int getUserCount()
    {
        return count;
    }
}



public class AllUsers {


    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the place where we make some people");
        System.out.println("Please provide the below details!");
        System.out.println("Please enter your name : ");
        String name = input.nextLine();
        System.out.println("Please enter your age : ");
        int age = Integer.parseInt(input.nextLine());
        System.out.println("Please enter your city name : ");
        String city = input.nextLine();
        System.out.println("Please enter your country name : ");
        String country = input.nextLine();
        People people = new People(name,age,city,country);
        PeopleLists peopleLists = new PeopleLists();
        peopleLists.addPeopleToList(people);
        peopleLists.displayAllPeople();
        input.close();
    }
}
