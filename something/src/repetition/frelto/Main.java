package repetition.frelto;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;


class TimeToEncodeDecode
{

    private String filename;
    private static final Random random = new Random();


    public void addDataToTextFile(Scanner input)
    {
        System.out.println("Enter data you want to enter in the file");
        StringBuilder sb = new StringBuilder();
        while (true)
        {
            String data = input.nextLine();
            if(data.equals(""))
            {
                break;
            }
            sb.append(data);
            sb.append("\n");
        }
        if(sb.length()>0)
        {
            sb.setLength(sb.length()-1);
        }
        String textData = sb.toString();

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename)))
        {
            bw.write(Base64.getEncoder().encodeToString(textData.getBytes(StandardCharsets.UTF_8)));
            System.out.println("Data encoded and added to file "+filename);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public void decodeDataFromFile(String filename)
    {

        try(BufferedReader br = new BufferedReader(new FileReader(filename)))
        {
            StringBuilder sb  = new StringBuilder();
            String line;
            while((line = br.readLine())!=null)
            {
                sb.append(line);
            }
            String decodedText = new String(Base64.getDecoder().decode(sb.toString()));
            System.out.println(decodedText);

        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public TimeToEncodeDecode()
    {
        this.filename = generateRandomFileName() + ".txt";
    }

    public static String generateRandomFileName()
    {
        StringBuilder sb = new StringBuilder();
        List<String> chars = Arrays.asList(
                "a","b","c","d","e","f","g","h",
                "i","j","k","l","m","n","o","p",
                "q","r","s","t","u","v","w","x",
                "y","z"
        );

        for(int i=0;i<6;i++)
        {
            sb.append(chars.get(random.nextInt(chars.toArray().length)));
        }

        return sb.toString();

    }

    @Override
    public String toString()
    {
        return filename;
    }
}


class OuterClass
{

    class InnerClassOneUtil
    {
        private List<InnerClassOne> usersList;

        public InnerClassOneUtil()
        {
            this.usersList = new ArrayList<>();
        }

        public void addAllUsersToList(List<InnerClassOne> providedList)
        {
            usersList.addAll(providedList);
            System.out.println("Successfuly added all the users!");
        }

        public void showAllUsers()
        {
            for(InnerClassOne users: usersList){
                System.out.println(users);
            }
        }

        public Optional<InnerClassOne> findUsersByUUID(UUID id)
        {
            for(InnerClassOne users: usersList)
            {
                if(users.getId().equals(id))
                {
                    return Optional.of(users);
                }
            }

            return Optional.empty();
        }

    }

    class InnerClassOne
    {
        private UUID id;
        private String name;
        private String city;
        private int age;


        public InnerClassOne(String name, String city, int age)
        {
            this.id = UUID.randomUUID();
            this.name = name;
            this.city = city;
            this.age = age;
        }

        @Override
        public String toString()
        {
            return "User("+id+", "+name+", "+city+", "+age+")";
        }

        public UUID getId()
        {
            return id;
        }

    }


    public void takeMeToSecondInnerClass(Scanner input)
    {
        @FunctionalInterface
        interface NoFace
        {
            void doSomething();

        }

        class InnerClassTwo
        {
            private UUID id;
            private String name;
            private String department;
            private String city;
            private int salary;
            private static final Random random = new Random();

            public InnerClassTwo(String name, String department, String city)
            {
                this.id = UUID.randomUUID();
                this.name = name;
                this.department = department;
                this.city = city;
                this.salary = random.nextInt(1000000);
            }

            @Override
            public String toString()
            {
                return "User("+id+", "+name+", "+department+", "+city+", "+salary+")";
            }

            public int getSalary()
            {
                return salary;
            }

            public String getDepartment()
            {
                return department;
            }

            public String getCity()
            {
                return city;
            }
        }

        class OneMoreClass
        {
            NoFace func = ()->{
                System.out.println("In this world of all evil be good");
            };
            public void callLambda()
            {
                func.doSomething();
            }
        }

        class InnerClassTwoUtil
        {
            private List<InnerClassTwo> lists;


            public InnerClassTwoUtil()
            {
                this.lists = new ArrayList<>();
            }

            public void addAllUsersToList(List<InnerClassTwo> providedList)
            {
                lists.addAll(providedList);
                System.out.println("Added all the values");
            }

            public void showAllUsers(){
                for(InnerClassTwo users: lists){
                    System.out.println(users);
                }
            }
            public void getSalarySum()
            {
                int sumSalary = lists.stream()
                        .map(user->user.getSalary())
                        .reduce(0,(a,b)->a+b);

                System.out.println("The total sum of all the users "+sumSalary);
            }

            public void groupUserByDepartment()
            {
                Map<String, List<InnerClassTwo>> maps =  lists.stream()
                        .collect(Collectors.groupingBy(users->users.getDepartment()));

                for(Map.Entry<String, List<InnerClassTwo>> entry: maps.entrySet())
                {
                    System.out.println(entry.getKey() +" => "+entry.getValue());
                }
            }

            public void partitionUsersBySalary()
            {
                Map<Boolean, List<InnerClassTwo>> maps =  lists.stream()
                        .collect(Collectors.groupingBy(users->users.getSalary()>500000));

                System.out.println("Here is a list of all users having salary more than 500000");
                maps.get(true).stream().forEach(System.out::println);
                System.out.println(" ");
                System.out.println("Here is a list of all users having salary less than 500000");
                maps.get(false).stream().forEach(System.out::println);
            }

            public void filterUsersBasedOnCity(String city)
            {

                List<InnerClassTwo> newUsers = lists.stream().filter(user->user.getCity().equals(city)).toList();

                Runnable task = ()-> {

                    for(InnerClassTwo user: newUsers)
                    {
                        System.out.println(user);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                };

                Thread t1 = new Thread(task);
                t1.start();
            }



        }


        System.out.println("Now we are inside the second inner class time to go bonkers");
        System.out.println("Lets go crazy");
        InnerClassTwoUtil innerClassTwoUtil = new InnerClassTwoUtil();
        innerClassTwoUtil.addAllUsersToList(Arrays.asList(
                new InnerClassTwo("Aman Dubey", "CompSci","Bangalore"),
                new InnerClassTwo("Archita Dubey", "Business","Mumbai"),
                new InnerClassTwo("Mukesh Dubey", "Business","Varanasi"),
                new InnerClassTwo("Sharda Dubey", "Maths","Balia"),
                new InnerClassTwo("Shanti Devi", "Maths","Balia"),
                new InnerClassTwo("Rachel Broshnan", "Drama","LA")
        ));
        innerClassTwoUtil.getSalarySum();
        innerClassTwoUtil.showAllUsers();
        innerClassTwoUtil.groupUserByDepartment();
        innerClassTwoUtil.partitionUsersBySalary();
        System.out.println("Time to use little bit of filter in streams");
        System.out.println("Enter city name : ");
        String city = input.nextLine();
        innerClassTwoUtil.filterUsersBasedOnCity(city);
        OneMoreClass oneMoreClass = new OneMoreClass();
        oneMoreClass.callLambda();


    }

    public void takeMeToGenricPrinter()
    {

        class Users
        {

            private UUID id;
            private String name;
            private String city;
            private String country;
            private int age;


            public Users(String name, String city, String country, int age)
            {
                this.id = UUID.randomUUID();
                this.name = name;
                this.city = city;
                this.country = country;
                this.age = age;
            }

            public Users()
            {
                this("Aman Dubey","Varanasi","India",27);
            }


            @Override
            public String toString()
            {
                return "User("+id+", "+name+", "+city+", "+age+" "+country+")";
            }

            public void introduceYourself(Users user)
            {
                System.out.println("Hi my name is User and here are my details "+user);
            }
        }

        class NewPrinter <T extends Users>
        {
            T item;

            public NewPrinter(T item)
            {
                this.item = item;
            }

            public void print()
            {
                System.out.println("Here is something "+item);
            }

        }

        class GenericPrinter <T>
        {

            private T value;

            public GenericPrinter(T value)
            {
                this.value = value;
            }

            @Override
            public String toString()
            {
                return "The value is "+value;
            }

        }

        class GenericPrinterUtil <T>
        {
            private List<T> genericList;

            public GenericPrinterUtil()
            {
                this.genericList = new ArrayList<>();
            }

            public void addAllGenericItemsInList(List<T> providedList)
            {
                for(T value: providedList)
                {
                    genericList.add(value);
                }
            }

            public void showAllGenericValues()
            {
                for(T value : genericList)
                {
                    System.out.println(value);
                }
            }
        }




        GenericPrinterUtil<Integer> integerlist = new GenericPrinterUtil<>();
        GenericPrinterUtil<String> stringlist = new GenericPrinterUtil<>();
        GenericPrinterUtil<Float> floatlist = new GenericPrinterUtil<>();
        GenericPrinterUtil<GenericPrinter> strings = new GenericPrinterUtil<>();
        integerlist.addAllGenericItemsInList(Arrays.asList(
                123,22,345,234,324,21321,234,-234,23423,-345,234
        ));
        stringlist.addAllGenericItemsInList(Arrays.asList(
                "Hi","my","name","is","aman","dubey"
        ));
        floatlist.addAllGenericItemsInList(Arrays.asList(
                12.34f, 34.5f, 45.5f, 34.566f
        ));
        strings.addAllGenericItemsInList(Arrays.asList(
                new GenericPrinter<>("Hi my name is aman dubey"),
                new GenericPrinter<>(234),
                new GenericPrinter<>(45.56f),
                new GenericPrinter<>(12),
                new GenericPrinter<>(123),
                new GenericPrinter<>(true)
        ));
        List<GenericPrinterUtil> lists = Arrays.asList(integerlist, stringlist, floatlist, strings);
        for(GenericPrinterUtil listItem: lists)
        {
            listItem.showAllGenericValues();
        }

        Users users = new Users("Archita Dubey","Mumbai","India",22);
        NewPrinter<Users> u = new NewPrinter<>(users);
        u.print();


    }
}

public class Main
{

    public static void main(String[] args)
    {

        Scanner input = new Scanner(System.in);
        System.out.println("Let us cover all core java topics in one single file");
        System.out.println("Lets go crazy");
        OuterClass outterClass = new OuterClass();
        OuterClass.InnerClassOneUtil innerClassOneUtil = outterClass.new InnerClassOneUtil();
        innerClassOneUtil.addAllUsersToList(Arrays.asList(
                outterClass.new InnerClassOne("Aman Dubey", "Bangalore", 27),
                outterClass.new InnerClassOne("Archita Dubey", "Bangalore", 27),
                outterClass.new InnerClassOne("Mukesh Dubey", "Bangalore", 27),
                outterClass.new InnerClassOne("Sharda Dubey", "Bangalore", 27),
                outterClass.new InnerClassOne("Chalrie Singh", "Bangalore", 27),
                outterClass.new InnerClassOne("Slime Singh", "Bangalore", 27)
        ));
        innerClassOneUtil.showAllUsers();

        UUID id = null;
        while (true)
        {
            try{
                System.out.println("Enter the UUID you wanted to search");
                id = UUID.fromString(input.nextLine());
                break;
            }
            catch (IllegalArgumentException e)
            {
                System.out.println("Please add a valid UUID to search");
            }
        }

        Optional<OuterClass.InnerClassOne> optionalUser = innerClassOneUtil.findUsersByUUID(id);
        UUID finalId = id;
        optionalUser.ifPresentOrElse(
                user-> System.out.println("This is the required "+user),
                ()-> System.out.println("No users found with the id "+ finalId)
        );

        System.out.println("Time to go inside the Outter Class Two method");
        outterClass.takeMeToSecondInnerClass(input);
        outterClass.takeMeToGenricPrinter();


        System.out.println("Its time to checkout the generic printer");
        List<Integer> lists = new ArrayList<>(Arrays.asList(12,33,34,23,44,324,44,33,4,34,34,43));
        printGenericListValues(lists);
        System.out.println("Time to generate a file");
        TimeToEncodeDecode timeToEncodeDecode = new TimeToEncodeDecode();
        timeToEncodeDecode.addDataToTextFile(input);
        System.out.println("Enter the name of the file you want to decode");
        String fileToEncode = input.nextLine();
        timeToEncodeDecode.decodeDataFromFile(fileToEncode);
        input.close();
    }

    public static void printGenericListValues(List<?> genericListValues)
    {
        for(Object obj: genericListValues)
        {
            System.out.print(obj+"->");
        }
        System.out.print("\n");
    }


}