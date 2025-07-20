package walmart.comperableVScomparator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

class Employee
{

    private String name;
    private int age;
    private int salary;
    private String city;
    private String country;
    private int randomNumber;
    private static final Random random = new Random();


    public Employee(String name, int age, int salary, String city, String country)
    {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.city = city;
        this.country = country;
        this.randomNumber = random.nextInt(100000);
    }

    public String getCity()
    {
        return city;
    }
    public String getName()
    {
        return name;
    }

    public int getAge()
    {
        return age;
    }

    public int getSalary()
    {
        return salary;
    }

    public int getRandomNumber()
    {
        return randomNumber;
    }

    @Override
    public String toString()
    {
        return "(name "+name+", age "+age+", salary "+salary+", city "+city+", random "+randomNumber+")";
    }
}

public class GoCrazy {

    private static final Random random = new Random();

    public static void main(String[] args)
    {
        System.out.println("We will see about comperator");
        System.out.println("Creating a list of employees");
        List<Employee> employeeList = Arrays.asList(
                new Employee("Aman Dubey",27,123650000,"Varanasi","India"),
                new Employee("Archita Dubey",22,450000,"Bangalore","India"),
                new Employee("Sharda Dubey",20,250000,"Mumbai","India"),
                new Employee("Mukesh Dubey",47,750000,"Pune","India"),
                new Employee("Rachel Mc Adamas",37,1050000,"Shimla","India"),
                new Employee("Zig Ziggler",21,12650000,"Chennai","India")
        );

        System.out.println("By Age");
        employeeList.sort(Comparator.comparing(Employee::getAge));
        runForLoop(employeeList);

        System.out.println("By City");
        employeeList.sort(Comparator.comparing(Employee::getCity));
        runForLoop(employeeList);

        System.out.println("By Random Number");
        employeeList.sort(Comparator.comparing(Employee::getRandomNumber));
        runForLoop(employeeList);

        System.out.println("By Name");
        employeeList.sort(Comparator.comparing(Employee::getName));
        runForLoop(employeeList);

        timeToUseFunctionalInterface();

    }

    public static void runForLoop(List<Employee> employeeList)
    {
        for(Employee employee: employeeList)
        {
            System.out.println(employee);
        }
        System.out.println("  ");
        System.out.println("  ");
    }

    public static void timeToUseFunctionalInterface()
    {

        System.out.println("These are the dour diffrent functional interface avilable to us in java");

        Consumer<Integer> consume = value-> System.out.println(value);
        Supplier<Integer> supply = ()-> random.nextInt(1000);
        Function<Integer,Integer> doSomething = value -> value*value;
        Predicate<Integer> checkIfEvcen = value -> value%2==0;

        consume.accept(123);
        int somevalue = supply.get();
        System.out.println(somevalue);
        System.out.println(doSomething.apply(123));
        System.out.println("The number 127 is even or not ?:"+checkIfEvcen.test(127));


    }
}
