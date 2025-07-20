package walmart;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;


class Employee
{

    private UUID id;
    private String name;
    private int age;
    private int salary;
    private String city;
    private String country;


    public Employee(String name, int age, int salary, String city, String country)
    {
        this.id = UUID.randomUUID();
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.city = city;
        this.country = country;
    }

    public String getName()
    {
        return name;
    }

    public int getSalary()
    {
        return salary;
    }

    public String getCity()
    {
        return city;
    }


    @Override
    public String toString()
    {
        return "Name : "+name+", "+"age: "+age+", salary: "+salary+", city: "+city+", country : "+country;
    }

}

public class Today {

    private static final Random random = new Random();

    public static void main(String[] args)
    {
        System.out.println("Let us first see how we can use the comparator in this case!!");
        List<Employee> employeeList = Arrays.asList(
                new Employee("Aman Dubey",27,123433,"Varanasi","India"),
                new Employee("Archita Dubey",37,9817238,"Mumbai","India"),
                new Employee("Mukesh Dubey",17,55000,"Bangalore","India"),
                new Employee("Sharda Dubey",47,43433,"Balia","India"),
                new Employee("Charlie Singh",12,453433,"Gotham","India")
        );

        System.out.println("Sorting on name");
        employeeList.sort(Comparator.comparing(Employee::getName));
        runForLoop(employeeList);
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("Sorting on salary");
        employeeList.sort(Comparator.comparing(Employee::getSalary));
        runForLoop(employeeList);
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("Sorting on city but in reverse");
        employeeList.sort(Comparator.comparing(Employee::getCity).reversed());
        runForLoop(employeeList);
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("Time to check the functional interface");
        functionalInterfaceJava();
        System.out.println("");
        System.out.println("Applying custom functions like interface in java stream");
        applyCustomFunctions();
        playingWithStreams();

    }

    public static void runForLoop(List<Employee> employeeList)
    {
        for(Employee employee: employeeList)
        {
            System.out.println(employee);
        }
    }


    public static void functionalInterfaceJava()
    {
        System.out.println("Let us now try to take a look at the functional interface in java");
        System.out.println("There are four in total");
        System.out.println("Consumer");
        System.out.println("Supplier");
        System.out.println("Function");
        System.out.println("Predicate");


        Consumer<String> consumer = textval-> System.out.println("this is a text value "+textval);
        Supplier<Integer> suplier = ()-> random.nextInt(1000);
        Function<Integer,Integer> dosomeThing = val-> val*val;
        Predicate<Integer> checkIfEven = val-> val%2==0;


        consumer.accept("test string");
        int randomValue = suplier.get();
        System.out.println("Random value I got "+randomValue);
        int result = dosomeThing.apply(12);
        System.out.println("Result after something : "+result);
        System.out.println("We can use predictet on a list of nums");
        List<Integer> arr1 = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        arr1.stream()
                .filter(checkIfEven)
                .forEach(System.out::println);

    }

    public static void applyCustomFunctions()
    {
        List<String> names = Arrays.asList(
                "Aman", "Dubey","Rachel",
                "Something","Broski","frfr",
                "myslime","yyo","Badrinath",
                "Dubey"
        );

        Consumer<String> consume = val-> System.out.println(val);
        Function<String,String> dosomething = textVal-> textVal.toUpperCase()+" is a legend!!";
        Predicate<String> checkIfLength = textVal-> textVal.length()>=4;

        List<String> finalLists = names.stream()
                .map(dosomething)
                .filter(checkIfLength)
                .collect(Collectors.toList());

        System.out.println("Names after all the operations "+finalLists);

        // time to define the functions
    }

    public static void playingWithStreams()
    {

        List<Integer> nums = Arrays.asList(1,2,3,45,12,3,435,4,3,3,434,34,54,3,4,334,32,345,34234,234,234,234);
        System.out.println("Filtering all the even numbers and then finding there sume");
        int answer = nums.stream()
                .filter(x->x%2==0)
                .reduce(0,(a,b)->a+b);

        System.out.println("Sum after filtering "+answer);

        System.out.println("Filtering names baseed in the length and then creating a new list out of it");
        List<String> names = Arrays.asList(
                "Aman","Dubey","raju","Rachel","Musk","Broski","Slime","Bale","Zayn","Gigi"
        );

        List<String> finalName = names.stream()
                .filter(x->x.length()==4)
                .map(x->x.toUpperCase())
                .collect(Collectors.toList());

        System.out.println("List of names after the operations "+finalName);

        Consumer<Integer> consume = val-> System.out.println(val);
        Function<Integer,Integer> findFactorial = val-> {
            int res = 1;
            for(int i=2;i<=val;i++)
            {
                res*=i;
            }

            return res;
        };
        List<Integer> numsToFindFactorial = Arrays.asList(
                1,2,3,4,5,6,7,8,9,10
        );

        int factorialSum = numsToFindFactorial.stream()
                .map(findFactorial)
                .peek(consume)
                .collect(Collectors.toList())
                        .stream()
                                .reduce(0,(a,b)->a+b);

        System.out.println(factorialSum);

        System.out.println("Lets say we have a list of list what will we do in that case!!");
        List<List<String>> thisIsCrazy = new ArrayList<>(Arrays.asList(
                Arrays.asList("Hi","my","name","is","Aman","Dubey"),
                Arrays.asList("But","not","to","mention","that","this"),
                Arrays.asList("is","my","world","and","I","will"),
                Arrays.asList("not","allow","anyone","to","stop","me")

        ));

        List<String> finalValues =  thisIsCrazy.stream()
                .flatMap(Collection::stream)
                .map(String::toUpperCase)
                .filter(x->x.length()<=5)
                .collect(Collectors.toList());

        System.out.println("Here are the final values "+finalValues);

        System.out.println("Lets us now try to get the sum of only the distinct values in a list of number");
        List<Integer> arr1 = Arrays.asList(1,3,22,3,55,3,4,5,34,5,23,55,3,45,5,5,5,54,34,4,3,4,43,3,33,4,34,4);
        int finakanswer = arr1.stream()
                .distinct()
                .reduce(0,(a,b)->a+b);
        System.out.println("Sum of all the distinct values in this list ");
        System.out.println(finakanswer);
        System.out.println("Sorting numbers in acxesidn order");
        List<Integer> numbers = Arrays.asList(1,3,5,23,1,2,34,345,678,789876,4,65,6,2,4,5,456,23,234,345,546,23,4456,567,345);
        System.out.println("Ascending order");
        numbers.stream()
                .sorted()
                .forEach(System.out::println);

        System.out.println("Sorting in descending order");
        List<Integer> someNums = numbers.stream()
                .sorted(Comparator.reverseOrder())
                .map(x->x*x)
                .peek(System.out::println)
                .toList();

        System.out.println(someNums);
        System.out.println("  ");
        System.out.println("Sorting based on the length of the stings");
        List<String> namesList = Arrays.asList(
                "Aman","DSubey","is","a","legend","notto","forget","allthe","great","things","I","have","done"
        );
        System.out.println(namesList);
        List<String> sortedBasedOnLength = namesList.stream()
                .map(String::toUpperCase)
                .distinct()
                .sorted(Comparator.comparingInt(String::length).reversed())
                .toList();

        System.out.println(sortedBasedOnLength);
        System.out.println("Picking some elemsts");
        namesList.stream()
                .map(String::toUpperCase)
                .skip(4)
                .forEach(System.out::println);
        System.out.println("Limiting some elements");
        namesList.stream()
                .map(String::toUpperCase)
                .limit(4)
                .forEach(System.out::println);

        System.out.println("Finding the first element for which the lnegth is 5");

        Optional<String> reqValue = namesList.stream()
                .map(String::toLowerCase)
                .filter(x->x.length()==5)
                .findFirst();

        reqValue.ifPresentOrElse(
                value-> System.out.println("This ths required value "+value),
                ()-> System.out.println("Did not find string to match this")
        );

        List<Integer> values = Arrays.asList(1,2,2,2,2,2,1,1,1,2,2,2,2,3,3,3,3,3,3,3,4,4,4,4,5,5,5,5,6,6,6,6,6,6,7,7,7);
        long distinctCount = values.stream()
                .distinct()
                .count();
        int sumOfAllValues = values.stream()
                        .distinct()
                        .reduce(0,(a,b)->a+b);

        System.out.println("Original array : "+values);
        System.out.println("Count of distrinct values "+distinctCount);
        System.out.println("Sum of all ldistinct values "+sumOfAllValues);


    }

}
