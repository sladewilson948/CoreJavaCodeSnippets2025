package fullsend.javastreams;
import java.util.*;
import java.util.stream.Collectors;

// let us now define a EmployeeClass to understand
// grouping by and partioning by

class User
{
    private int id;
    private String name;
    private int age;
    private int salary;
    private String city;
    Random random = new Random();

    public User(String name, int age, int salary, String city)
    {
        this.id = random.nextInt(1000);
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.city = city;
    }

    @Override
    public String toString()
    {
        return "Hi my name is "+name+" and I am from "+city+" and I am "+age+" years old and I am making "+salary+" per annum";
    }

    public int getSalary()
    {
        return salary;
    }

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public String getCity()
    {
        return city;
    }

}

public class Main {

    public static void main(String[] args)
    {
        System.out.println("Welcome to java streams");
        List<String> names = new ArrayList<>(Arrays.asList("Aman","Dubey","Rachel","McAdams","Cahrlie"));
        List<Integer> nums = new ArrayList<>(Arrays.asList(1,3,2,4,5,434,5,3,4,34,545,3,34,45,345,65,45));
        List<String> lowerNames = new ArrayList<>(Arrays.asList("aman","dubey","is","a","fucking","legend"));
        List<List<String>> nestedList = new ArrayList<>(Arrays.asList(
                Arrays.asList("aman","dubey","is","a"),
                Arrays.asList("great","programmer","lets"),
                Arrays.asList("be","real","here")
        ));
        List<String> newNames = new ArrayList<>(Arrays.asList(
                "Aman", "Dubey","is","a","great","developer","the","fact","is","undeniable","thats","just","persuvasive","frfr"
        ));
        List<Integer> myNums = new ArrayList<>(Arrays.asList(1,1,2,2,2,3,3,3,3,4,4,4,5,5,5,6,6,6,7,54,4,3,3,12,3,23,21,31,231,32,4,344,23,22,3423,321,32,123,123,21,3131,12,12,31,123,123,234,23,4324,234,23,23,123,1234,24,345,4,57,5,645,534,545,756,876,8));

        System.out.println("..............................");
        System.out.println("Time to make some users");
        List<User> userList = new ArrayList<>(Arrays.asList(

                new User("Aman Dubey",27,650000,"Varanasi"),
                new User("Archita Dubey",22,50000,"Varanasi"),
                new User("Mukesh Dubey",27,600000,"Bangalore"),
                new User("Sharda Dubey",30,750000,"Bangalore"),
                new User("Chris Evans",37,6250000,"LA")
        ));

        flatTheList(nestedList);
        myPersonalStream(names);
        streamToCheckEvenNumbers(nums);
        makeStringsUpperCase(lowerNames);
        addAllNumsInArray(nums);
        flatTheList(nestedList);
        getSumofDistinctValues(nums);
        sortingNumbers(myNums);
        sortingListBasedOnLength(newNames);
        skipSomeElements(newNames);
        limitSomeElements(newNames);
        getFirstElementWithLengthSix(lowerNames);
        getCountOfUniqueElements(lowerNames);
        partionUsersBySalary(userList);
        groupAllUsersByCity(userList);


    }


    public static void myPersonalStream(List<String> names)
    {
        names.stream()
                .filter(x->x.length()==5)
                .forEach(System.out::println);
    }
    public static void streamToCheckEvenNumbers(List<Integer> nums)
    {
        Optional<Integer> ans  = nums.stream()
                .filter(x->x%2==0)
                .peek(System.out::println)
                .reduce((a,b)->a+b);

        if(ans.isPresent())
        {
            System.out.println(ans.get());
        }
        else{
            System.out.println("No result");
        }
    }
    public static void makeStringsUpperCase(List<String> lowercaseNames)
    {
        lowercaseNames.stream()
                .map(x->x.toUpperCase())
                .forEach(System.out::println);
    }
    public static void addAllNumsInArray(List<Integer> allNums)
    {
        int finalAnswer = allNums.stream()
                .reduce(0,(a,b)->a+b);

        System.out.println("sum of all the numbers in the list "+allNums+" "+finalAnswer);
    }

    public static void flatTheList(List<List<String>> nestedList)
    {
        System.out.println("This is the original list "+nestedList);
        List<String> namesFalt = nestedList.stream()
                .flatMap(Collection::stream)
                .map(String::toUpperCase)
                .peek(System.out::println)
                .collect(Collectors.toList());

        System.out.println(namesFalt);
    }

    public static void getSumofDistinctValues(List<Integer> duplicatedList)
    {

        int answer = duplicatedList.stream()
                .distinct()
                .map(x->x*x)
                .filter(x->x%2==0)
                .peek(System.out::println)
                .reduce(0,(a,b)->a+b);

        System.out.println(answer);
    }

    public static void sortingNumbers(List<Integer> myNums)
    {
        System.out.println("Here is a list of all numbers sorted and distcint as well");
        List<Integer> newnums = myNums.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println("Original list : "+ myNums);
        System.out.println("Sorted distinct list : "+newnums);
    }

    public static void sortingListBasedOnLength(List<String> names)
    {
        List<String> newNames= names.stream()
                .distinct()
                .sorted(Comparator.comparingInt(String::length).reversed())
                .peek(System.out::println)
                .collect(Collectors.toList());

        System.out.println("Here is the modified list : "+newNames);
    }

    public static void skipSomeElements(List<String> newNames)
    {
        List<String> someNames = newNames.stream()
                .distinct()
                .sorted(Comparator.comparingInt(String::length).reversed())
                .skip(3)
                .toList();

        System.out.println("Names after skipping the first 3 "+someNames);
    }

    public static void limitSomeElements(List<String> newNames)
    {
        List<String> namesOnly =  newNames.stream()
                .distinct()
                .sorted(Comparator.comparingInt(String::length).reversed())
                .limit(6)
                .map(String::toUpperCase)
                .toList();

        System.out.println("Names after only considering the first 6 elements "+namesOnly);
    }

    public static void getFirstElementWithLengthSix(List<String> myNames)
    {
        Optional<String> requiredValue = myNames.stream()
                .distinct()
                .filter(x->x.length()==6)
                .findFirst();

        if(requiredValue.isPresent())
        {
            System.out.println("first name of length 6 is "+requiredValue.get());
        }
        else{
            System.out.println("No answer ");
        }
    }

    public static void getCountOfUniqueElements(List<String> getNames)
    {
        final long answer = getNames.stream()
                .distinct()
                .count();
        System.out.println("This is the count of all the distinct values "+answer);
    }


    public static void partionUsersBySalary(List<User> usersList)
    {
        Map<Boolean,List<User>> newmap = usersList.stream()
                .collect(Collectors.partitioningBy(user->user.getSalary()<=750000));

        System.out.println("List of all users less than 750000 salary");
        System.out.println(newmap.get(true));
        System.out.println("List of all users more than 750000 salary");
        System.out.println(newmap.get(false));
    }

    public static void groupAllUsersByCity(List<User> usersList)
    {
        Map<String, List<User>> newmap = usersList.stream()
                .collect(Collectors.groupingBy(User::getCity));

        System.out.println("Iterating over this map");

        for(Map.Entry<String, List<User>> entry : newmap.entrySet())
        {
            System.out.println(entry.getKey() + "==>"+ entry.getValue());
        }
    }


}
