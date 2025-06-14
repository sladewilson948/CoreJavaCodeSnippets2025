package practicemakesperfect;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.Random;
import java.util.stream.LongStream;
import java.util.stream.Stream;


class EmployeeDetails
{
    private Integer id;
    private String name;
    private String department;
    private Integer salary;
    Random random = new Random();

    public EmployeeDetails(String name, String department, Integer salary)
    {
        this.id = random.nextInt(1000);
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getName()
    {
        return name;
    }

    public String getDepartment()
    {
        return department;
    }
    public Integer getSalary()
    {
        return salary;
    }
    public Integer getId()
    {
        return id;
    }

    @Override
    public String toString()
    {
        return "Hi my name is "+name+ " I work at "+department+ " I am making around "+salary+" INR.";
    }
}



public class JavaStreams
{

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Let us start with arrays");
        int[] nums = {1,2,3,4,5,6,76,8};
        Integer[] numsNew = {1,2,3,4,5,6,76,434,34};
        System.out.println("This is an array : "+nums);
        final IntStream intStream = Arrays.stream(nums);
        final Stream<Integer> integerStream = Stream.of(numsNew);

        System.out.println("Printing all the values from primitive stream");
        intStream.forEach(System.out::println);
        System.out.println("Printing all the values from object stream");
        integerStream.forEach(System.out::println);

        // for a List<Integer> we can have something like
        List<Integer> someList = Arrays.asList(34,122,43,12,55,234);
        System.out.println("Converting an array object to stream something like");
        someList.stream()
                .forEach(System.out::println);

        System.out.println("Lets see how we can perform a filter method on the list like this");
        List<Integer> mineList = Arrays.asList(12,43,1234,23,234,23423,123);
        mineList.stream()
                        .filter(n -> n%2==0)
                                .forEach(System.out::println);
        List<Integer> lists = new ArrayList<>(Arrays.asList(1,2,33,43,23,54,456));
        filterValues(lists);
        List<String> namesLower = new ArrayList<>(Arrays.asList("john","doe","aman","rachel","nidhi"));
        toUpperCase(namesLower);
        System.out.println("Keep typing the values and once done press quit");
        List<Integer> arr1 = new ArrayList<>();
        while(true)
        {
            try{
                int num = Integer.parseInt(input.nextLine());
                arr1.add(num);
            }
            catch (Exception e)
            {
                break;
            }

        }
        reduceNumbers(arr1);
        List<List<String>> listsExtra = new ArrayList<>(Arrays.asList(
                Arrays.asList("aman","dubey"),
                Arrays.asList("is","a","fucking","legend"),
                Arrays.asList("having","said","that","what"),
                Arrays.asList("you","really","gonna","do","with","it")
        ));
        // using flat Map we can flatten out 2d list to a single 1 d list how cool is that
        listsOfList(listsExtra);
        peakElementFromList(lists);
        List<Integer> duplicateValues = new ArrayList<>(Arrays.asList(1,43,4,4,4,3,3,34,4,5,5,5,5,6,6,7,7,7,7,7,7,10,10,10,10));
        List<String> duplicateNames = new ArrayList<>(Arrays.asList("Aman","Archita","Aman","Mukesh","Rachel","Zendaya","kiwi","fruits"));
        getSumOfDistinctElements(duplicateValues);
        sortNumbersInAscendingOrder(duplicateValues);
        sortBasedOnSize(duplicateNames);
        pickSomeElements(duplicateNames);
        limitSomeElements(duplicateNames);
        getSumOfAllValues(duplicateValues);
        System.out.println("Lets try to understand the collect which is a terminal method in java");
        System.out.println("Calling the collect method");
        System.out.println("Let us now try to understand how to use the GroupBy type shi");
        numsCollectSome(duplicateValues);
        System.out.println("Let us now see how we can use the groupby property in java stream");
        System.out.println("Let us make some users list now");

        List<EmployeeDetails> employeeList = Arrays.asList(

                new EmployeeDetails("Aman Dubey","IT",3000),
                new EmployeeDetails("Sharda Dubey","HR",4000),
                new EmployeeDetails("Mukesh Dubey","Finance",2000),
                new EmployeeDetails("Dave Free","Finance",1000),
                new EmployeeDetails("Arburay Grahams","IT",3000),
                new EmployeeDetails("Jaques Webstre","HR",2000)
        );
        groupAllEmployeesByDepartment(employeeList);
        partitioningAllEmployeesBySalary(employeeList);
        getMaxValueFromStream(duplicateValues);
        findFirstElement(duplicateValues);
        anyMatchExample(duplicateNames);
        getCountOfValues(duplicateValues);
        getSumOfAllValues(duplicateValues);
        parallelStreamBadCase();
        parallelStreamGoodCase();
        input.close();
    }


    // filter method
    public static void filterValues(List<Integer> lists)
    {
        System.out.println("Lets try to apply a filter on it and then return the sum of only the even number");
        lists.stream()
                .filter(n->n%2==0)
                .forEach(System.out::println);
    }

    // map method
    public static void toUpperCase(List<String> namesLower)
    {
        namesLower.stream()
                .map(x->x.toUpperCase())
                .forEach(System.out::println);
    }

    //reduce method
    public static void reduceNumbers(List<Integer> nums)
    {
        int sumVal = nums.stream()
                            .reduce(0,(a,b)->a+b);
        System.out.println("Numbers added "+ nums);
        System.out.println(sumVal);
    }
    // this is for the case where we have a list of lists as the input and how to use stream on this
    public static void listsOfList(List<List<String>> listsExtra)
    {
        // since each elemnt inside the list is a list in its own hence we must use what is called as flatMap
        listsExtra.stream()
                .flatMap(Collection::stream)
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }

    // let see how we can use peak
    // performs few operastion on stream but wont modiy it
    // but will return us some value

    public static void peakElementFromList(List<Integer> nums)
    {
        List<Integer> squaredLists = nums.stream()
                .map(x->x*x)
                .peek(System.out::println)
                .collect(Collectors.toList());

        System.out.println("Here is the final list");
        System.out.println(squaredLists);
    }

    // let us now see how we can make use of the distinct in java streams

    public static void getSumOfDistinctElements(List<Integer> nums)
    {
        List<Integer> uniqueValuesOnly = nums.stream()
                .distinct()
                .collect(Collectors.toList());

        final int outputValue = uniqueValuesOnly.stream()
                .reduce(0,(a,b)->a+b);
        System.out.println("All unique values in list are "+uniqueValuesOnly);
        System.out.println("The sum of the distinct values in the list "+nums);
        System.out.println(outputValue);
    }

    public static void sortNumbersInAscendingOrder(List<Integer> nums)
    {
        List<Integer> sortedNums = nums.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        System.out.println(sortedNums);

    }

    // streams to sort all the words in a list based on there length
    public static void sortBasedOnSize(List<String> namesList)
    {
        namesList.stream()
                .distinct()
                .map(String::toUpperCase)
                .sorted(Comparator.comparingInt(String::length).reversed())
                .forEach(System.out::println);
    }

    public static void pickSomeElements(List<String> namesList)
    {
        List<String> skippedValues = namesList.stream()
                .skip(2)
                .toList();
        System.out.println(skippedValues);
    }

    public static void limitSomeElements(List<String> namesList)
    {
        List<String> limitedValues = namesList.stream()
                .limit(3)
                .toList();

        limitedValues.stream()
                .forEach(System.out::println);
    }

    public static void numsCollectSome(List<Integer> nums)
    {
        List<Integer> newNums = nums.stream()
                .distinct()
                .filter(x->x%2==0)
                .map(x->x*x)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println(newNums);
    }


    public static void partitioningAllEmployeesBySalary(List<EmployeeDetails> employeeDetails)
    {
        ///  this returns us a map where the key is Boolean and the values are list
        Map<Boolean,List<EmployeeDetails>> newmap =
        employeeDetails.stream()
                .collect(Collectors.partitioningBy(employee -> employee.getSalary()>2000));

        // now we can actually iterate this map
        System.out.println("Employees with salary less than 2000");
        newmap.get(false).forEach(System.out::println);
        System.out.println(".....");
        System.out.println("Employees with salary more than 2000");
        newmap.get(true).forEach(System.out::println);
    }

    public static void groupAllEmployeesByDepartment(List<EmployeeDetails> employeeDetails)
    {
        Map<String, List<EmployeeDetails>> employeesByDepartment =   employeeDetails.stream()
                .collect(Collectors.groupingBy(EmployeeDetails::getDepartment));

        System.out.println(employeesByDepartment);
        // we can also perform some type of for loop on this map we just got
        for(Map.Entry<String, List<EmployeeDetails>> entry: employeesByDepartment.entrySet())
        {
            System.out.println(entry.getKey() + " ===> " + entry.getValue());
        }
    }

    public static void getMaxValueFromStream(List<Integer> nums)
    {
        Optional<Integer> number =  nums.stream()
                .max(Comparator.naturalOrder());
        System.out.println(number.get());
    }

    public static void findFirstElement(List<Integer> nums)
    {
        ///  simple terminal operation we can perform
        Optional<Integer> finalNums = nums.stream()
                .distinct()
                .filter(x->x%2==0)
                .findFirst();

        if(finalNums.isPresent())
        {
            System.out.println(finalNums.get());
        }
        else{
            System.out.println("No element present in the stream that satisfies the condition.");
        }
    }

    public static void anyMatchExample(List<String> namesList)
    {
        final Boolean b = namesList.stream()
                .distinct()
                .anyMatch(x->x.length()==6);
        System.out.println(b);
    }

    public static void getCountOfValues(List<Integer> nums)
    {
        System.out.println(nums);
        final long countVal = nums.stream()
                .distinct()
                .count();
        System.out.println("Number of unique values : "+countVal);
    }

    public static void getSumOfAllValues(List<Integer> nums)
    {
        System.out.println(nums);
        final long sumValues = nums.stream()
                .distinct()
                .reduce(0,(a,b)->a+b);

        System.out.println("Final sum is "+sumValues);
    }

    public static void parallelStreamGoodCase()
    {
        // parallel streams should always be used in the case of heavy computational task
        long[] longArr = new long[20000];
        for(int i=0;i<longArr.length;i++)
        {
            longArr[i]=i+1;
        }

        long startTime = System.currentTimeMillis();
        long sequentialSum = Arrays.stream(longArr)
                .map(JavaStreams::factorialOfNumber)
                .sum();
        long endTime = System.currentTimeMillis();
        System.out.println("Sequnetial sum value "+ sequentialSum + " time taken is "+(endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        long parallelSum = Arrays.stream(longArr)
                .parallel()
                .map(JavaStreams::factorialOfNumber)
                .sum();
        endTime = System.currentTimeMillis();
        System.out.println("Parallel sum value " + parallelSum + " time take is "+ (endTime - startTime) + "ms");
    }

    public static void parallelStreamBadCase()
    {
        // parllel streams should not be used in the case of easy or less heavy computational task
        int[] arrNew = new int[1000000];
        Arrays.fill(arrNew,2);

        long startTime = System.currentTimeMillis();
        final int sequentialSum = Arrays.stream(arrNew)
                .map(x->x*x)
                .sum();

        long endTime = System.currentTimeMillis();
        System.out.println("Seuqential sum "+sequentialSum + " time taken "+ (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        final int parllelSum = Arrays.stream(arrNew)
                .parallel()
                .map(x->x*x)
                .sum();
        endTime = System.currentTimeMillis();
        System.out.println("Parallel sum "+sequentialSum + " time taken "+ (endTime - startTime) + " ms");
        System.out.println("................");
        System.out.println("As you can see using parallel stream for simple example always backfires. It should only be used on computational heavy tasks");
    }


    public static long factorialOfNumber(long number)
    {
        return LongStream.rangeClosed(1,number)
                .reduce(1,(long a, long b)-> a*b);
    }

}