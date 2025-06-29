package repetition.vexlur;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


class SomeClassToReflect
{

    private final UUID id;
    private final String name;
    private final String city;
    private final String country;
    private final BigDecimal salary;

    public SomeClassToReflect(String name, String city, String country, BigDecimal salary)
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
        return "Hi my name is "+name+" and I am from "+city+", "+country+" and my salary is "+salary+" INR and my id is "+id;
    }

    private static void someInfo()
    {
        System.out.println("So as you can see this mnethod is private");
    }
    public void greetMe(String name)
    {
        System.out.println("Hi your name is "+name+" and the length of your name is "+name.length());
    }

}

class OutterClass {

    public void overrideMe() {
        System.out.println("I am doing something!");
    }

    // let su now see how we can make use of bounded generics
    class SpecialUsers {

        private int id;
        private String name;
        private String city;
        private String country;
        private static final Random random = new Random();

        public SpecialUsers(String name, String city, String country) {
            this.id = random.nextInt();
            this.name = name;
            this.city = city;
            this.country = country;
        }

        @Override
        public String toString() {
            return "SpecialUser(" + id + ", " + name + ", " + city + ", " + country + ")";
        }

        public void introduceYourSelf() {
            System.out.println("Hi here is an intorudction aboue me " + name + " " + city);
        }

    }

    class GenericSpecialUers<T extends SpecialUsers> {
        List<T> specialUsersList;

        public GenericSpecialUers() {
            this.specialUsersList = new ArrayList<>();
        }

        public void addAllSpecialUsersToList(List<T> providedList) {
            for (T users : providedList) {
                specialUsersList.add(users);
            }
        }

        public void showAllSpecialUsers() {
            for (T users : specialUsersList) {
                users.introduceYourSelf();
            }
        }
    }

    // making use of java generics classes to print any number I want to

    class Genericprinter<T> {

        private List<T> objectsList;


        @Override
        public String toString() {
            return "Hi this is the list that you have " + objectsList;
        }

        public Genericprinter() {
            this.objectsList = new ArrayList<>();
        }

        public void addAllElementsInList(List<T> providedList) {
            for (T item : providedList) {
                objectsList.add(item);
            }
        }

        public void printAllElementsFromList() {
            for (T item : objectsList) {
                System.out.println("This is generic " + item);
            }
        }

    }


    class FirstClassUserUtility {

        private List<FirstInnerClass> usersLists;

        public FirstClassUserUtility() {
            this.usersLists = new ArrayList<>();
        }

        public Optional<FirstInnerClass> searchByUUID(String id) {
            for (FirstInnerClass users : usersLists) {
                if (users.id.equals(UUID.fromString(id))) {
                    return Optional.of(users);
                }
            }
            return Optional.empty();
        }

        public void addAllFirstClassUsersToList(List<FirstInnerClass> providedList) {
            for (FirstInnerClass users : providedList) {
                usersLists.add(users);
            }
            System.out.println("Added all the users successfuly");
        }

        public void showAllUsers() {
            System.out.println("Here is a list of all the users");
            for (FirstInnerClass users : usersLists) {
                System.out.println(users);
            }
        }

        public void provideTextDataForEachUserFile(Scanner input) {
            for (FirstInnerClass users : usersLists) {
                String filename = users.getFileName();
                System.out.println("Enter the data you want to enter in the text file");
                try (BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\JAVA2025\\something\\src\\repetition\\vexlur\\output\\" + filename))) {
                    StringBuilder sb1 = new StringBuilder();

                    while (true) {
                        String data1 = input.nextLine();
                        if (data1.equals("")) {
                            break;
                        }
                        sb1.append(data1);
                        sb1.append("\n");
                    }
                    if (sb1.length() > 0) {
                        sb1.setLength(sb1.length() - 1);
                    }
                    // time to encode the text file
                    String encodedText = Base64.getEncoder().encodeToString(sb1.toString().getBytes(StandardCharsets.UTF_8));
                    bw.write(encodedText);
                } catch (IOException e) {
                    System.out.println("Something went wrong while writing to the file!!");
                }
            }
            System.out.println("Data added in the files of all the users");
        }

        public void decryptAllTheDataOfUsers() throws IOException {
            for (FirstInnerClass user : usersLists) {
                String filename = user.getFileName();
                String lines = Files.readString(Paths.get("D:\\JAVA2025\\something\\src\\repetition\\vexlur\\output\\" + filename));
                String decodedText = new String(Base64.getDecoder().decode(lines));
                System.out.println("............");
                System.out.println(decodedText);
                System.out.println("............");
            }
        }


        public void timeToPlayWithThreads(Scanner input) {
            FirstInnerClass firstInnerClass = new FirstInnerClass("asd", "asd");

            System.out.println("We will have some threads and some tasks that we will perform using thread");
            Runnable task1 = () -> {

                for (int i = 0; i < 20; i++) {
                    System.out.println("Hi there my name is " + firstInnerClass.getFileName());

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };

            Runnable task3 = () -> {

                for (int i = 0; i < 100; i++) {
                    System.out.println("All weapons pointed at me gotta jam");
                }
            };

            Runnable task2 = () -> {

                for (int i = 0; i < 20; i++) {
                    System.out.println("Broski I am a legend here");
                }
            };

            Thread t1 = new Thread(task1);
            Thread t2 = new Thread(task2);
            Thread t3 = new Thread(task3);
            t1.start();
            t2.start();
            t3.start();


        }
    }

    class FirstInnerClass {
        // this class will be used to encode and decode strings for a particular user
        private UUID id;
        private String name;
        private String city;
        private String fileName;
        private static final Random random = new Random();


        public FirstInnerClass(String name, String city) {
            this.id = UUID.randomUUID();
            this.name = name;
            this.city = city;
            this.fileName = getRandomFileName();

        }

        public static String getRandomFileName() {
            List<String> allLetters = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z");
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                sb.append(allLetters.get(random.nextInt(26)));
            }

            return sb + ".txt";
        }

        public String getFileName() {
            return fileName;
        }

        @Override
        public String toString() {
            return "User(" + id + ", " + name + ", " + city + ", " + fileName + ")";
        }

    }

    public void takeMeToThirdClass()
    {

        class GenericClassTwoManager <T>
        {
            private List<T> listOfObjectsOfSpecificType;

            public GenericClassTwoManager()
            {
                this.listOfObjectsOfSpecificType = new ArrayList<>();
            }

            public void addAllDataOfSpecificType(List<T> providedData)
            {
                for(T data: providedData)
                {
                    listOfObjectsOfSpecificType.add(data);
                }
                System.out.println("Successfuly added all the data");
            }

            public void showAllData()
            {
                for(T data: listOfObjectsOfSpecificType)
                {
                    System.out.println(data);
                }
            }

            public void genericValueChecker()
            {
                for(T items: listOfObjectsOfSpecificType)
                {
                    if(items instanceof Integer)
                    {
                        System.out.println("The value "+items+" is an integer");
                    } else if (items instanceof String) {
                        System.out.println("The value "+items+" is a string");
                    } else if (items instanceof Float) {
                        System.out.println("The value "+items+" is a float");
                    }
                }
            }
        }


        class GenericClassTwo <T>
        {

            private T value;

            public GenericClassTwo(T value)
            {
                this.value = value;
            }

            @Override
            public String toString()
            {
                return "Hi there the data you provided is "+value;
            }

        }

        GenericClassTwoManager genericClassTwoManager = new GenericClassTwoManager<>();
        List<GenericClassTwo> list1 = new ArrayList<>(Arrays.asList(

                new GenericClassTwo<>("Aman Dubey"),
                new GenericClassTwo<>(23),
                new GenericClassTwo<>("I am a fucking legend"),
                new GenericClassTwo<>(23.3f),
                new GenericClassTwo<>(-45.567),
                new GenericClassTwo<>("sa"),
                new GenericClassTwo<>(false)

        ));

        genericClassTwoManager.addAllDataOfSpecificType(list1);
        genericClassTwoManager.showAllData();
        genericClassTwoManager.genericValueChecker();
        System.out.println("Call complete");
    }


}

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("I am going to squeeze in all the java topics in this");
        OutterClass outterClass = new OutterClass();
        OutterClass.FirstClassUserUtility firstClassUserUtility = outterClass.new FirstClassUserUtility();
        firstClassUserUtility.addAllFirstClassUsersToList(

                Arrays.asList(

                        outterClass.new FirstInnerClass("Aman Dubey", "Varanasi"),
                        outterClass.new FirstInnerClass("Archita Dubey", "Mumbai"),
                        outterClass.new FirstInnerClass("Sharda Dubey", "Balia"),
                        outterClass.new FirstInnerClass("Mukesh Dubey", "Varanasi"),
                        outterClass.new FirstInnerClass("Charlie the dog", "Varanasi")
                )
        );
        firstClassUserUtility.provideTextDataForEachUserFile(input);
        firstClassUserUtility.decryptAllTheDataOfUsers();
        outterClass.overrideMe();
        OutterClass outterClass1 = new OutterClass() {

            @Override
            public void overrideMe() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("hello there");
                }
            }
        };
        outterClass1.overrideMe();
        System.out.println(" ");
        firstClassUserUtility.showAllUsers();
        System.out.println("..........");
        System.out.println("Enter the UUID you want to search!!");
        String id = input.nextLine();
        Optional<OutterClass.FirstInnerClass> users = firstClassUserUtility.searchByUUID(id);
        users.ifPresentOrElse(
                userFound -> System.out.println("The required user is " + userFound),
                () -> System.out.println("Did not find any user for the id " + id)
        );
        System.out.println("Its threading time!");
        firstClassUserUtility.timeToPlayWithThreads(input);
        System.out.println("............");
        System.out.println("Time to use the generic printer class");
        List<String> stringValues = new ArrayList<>(Arrays.asList(
                "Hi", "my", "name", "is", "aman", "dubey", "and", "I", "am", "a", "legend"
        ));
        List<Integer> integerValues = new ArrayList<>(Arrays.asList(1, 2, 3, 2, 3, 3, 1, 2, 2, 3, 3, 3, 3, 3, 4, 44, 4, 23, 23, 3, 3));
        List<Float> floatValues = new ArrayList<>(Arrays.asList(23.45f, 32.44f, 12.5f, 56.7f, 56.43f));
        OutterClass.Genericprinter<Integer> genericprinter1 = outterClass.new Genericprinter();
        genericprinter1.addAllElementsInList(integerValues);

        OutterClass.Genericprinter<Float> genericprinter2 = outterClass.new Genericprinter();
        genericprinter2.addAllElementsInList(floatValues);

        OutterClass.Genericprinter<String> genericprinter3 = outterClass.new Genericprinter();
        genericprinter3.addAllElementsInList(stringValues);

        genericprinter1.printAllElementsFromList();
        genericprinter2.printAllElementsFromList();
        genericprinter3.printAllElementsFromList();
        System.out.println(".....................");
        System.out.println(genericprinter1);
        System.out.println(".....................");
        System.out.println(".....................");
        System.out.println(genericprinter2);
        System.out.println(".....................");
        System.out.println(".....................");
        System.out.println(genericprinter3);
        System.out.println(".....................");

        OutterClass.GenericSpecialUers<OutterClass.SpecialUsers> genericSpecialUers = outterClass.new GenericSpecialUers();
        genericSpecialUers.addAllSpecialUsersToList(Arrays.asList(
                outterClass.new SpecialUsers("Aman Dubey", "Varanasi", "India"),
                outterClass.new SpecialUsers("Aman Dubey", "Varanasi", "India"),
                outterClass.new SpecialUsers("Aman Dubey", "Varanasi", "India"),
                outterClass.new SpecialUsers("Aman Dubey", "Varanasi", "India")

        ));

        genericSpecialUers.showAllSpecialUsers();
        genericMethod("Aman Dubey");
        genericMethod(outterClass.new SpecialUsers("Aman Dubey", "Varanasi", "India"));
        genericMethod(12.34f);
        System.out.println(".....");
        System.out.println("...........");
        System.out.println("Time to use generics wildcards");
        List<Object> lists = Arrays.asList("1", "Aman", 123, "asd", 23.f, "asd");
        genericPrintLists(lists);
        outterClass.takeMeToThirdClass();

        System.out.println("Time to play with some reflections");
        SomeClassToReflect someClassToReflect = new SomeClassToReflect("Aman Dubey","Bangalore","India",new BigDecimal("123123123.1231"));
        System.out.println(someClassToReflect);
        System.out.println("Time to do some reflections");
        Field[] fields =  someClassToReflect.getClass().getDeclaredFields();

        for(Field field: fields)
        {
            System.out.println(field.getName());
        }

        System.out.println("Time to set the value to something");
        for(Field field: fields)
        {
            if(field.getName().equals("name"))
            {
                field.setAccessible(true);
                field.set(someClassToReflect,"I am Batman bih");
            }
            if(field.getName().equals("salary"))
            {
                field.setAccessible(true);
                field.set(someClassToReflect, new BigDecimal("6969.6969"));
            }
        }

        System.out.println(someClassToReflect);
        System.out.println("Time to play with some metyhods");
        Method[] declaredMethods = someClassToReflect.getClass().getDeclaredMethods();

        for(Method method: declaredMethods)
        {
            if(method.getName().equals("someInfo"))
            {
                method.setAccessible(true);
                method.invoke(null);
            }
            if(method.getName().equals("greetMe"))
            {
                method.invoke(someClassToReflect,"Aman Dubey");
            }
        }


        input.close();
    }

    public static <T> void genericMethod(T genericType) {
        if (genericType instanceof OutterClass.SpecialUsers) {
            ((OutterClass.SpecialUsers) genericType).introduceYourSelf();
        } else {
            System.out.println(genericType);
        }

    }

    public static void genericPrintLists(List<?> myLists) {
        for (Object item : myLists) {
            System.out.println(item);
        }
    }

}
