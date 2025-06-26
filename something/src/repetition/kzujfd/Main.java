package repetition.kzujfd;

import java.util.*;
import java.util.stream.Collectors;

interface NoFaceInThis
{
    String getSomeMessage(String name);
}

class OuterClass
{

    public void thisIsAMethod()
    {
        System.out.println("This is a method and this is what it does!!");
    }

    class UsersList
    {

        private List<FirstInnerClass> usersLists;

        public UsersList()
        {
            this.usersLists = new ArrayList<>();
        }

        public void addUsersToList(List<FirstInnerClass> providedList)
        {
            for(FirstInnerClass users: providedList)
            {
                usersLists.add(users);
            }
            System.out.println("Added the users to the list");
        }

        public void showAllUsers() throws InterruptedException {

            Runnable showUsers = ()-> {
                for(FirstInnerClass users: usersLists)
                {
                    System.out.println(users);
                    try
                    {
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }

            };

            System.out.println("Printing users on a separate thread");
            Thread t1 = new Thread(showUsers);
            t1.start();


        }
    }

    static class FirstInnerClass
    {

        private final int id;
        private final String name;
        private final String city;
        private final String country;
        private static final Random random = new Random();

        public FirstInnerClass(String name,String city, String country)
        {
            this.id = random.nextInt(1000);
            this.name = name;
            this.city = city;
            this.country = country;
        }

        @Override
        public String toString()
        {
            return "User => (id:"+id+"name:"+name+"city:"+city+"country:"+country+")";
        }

        public int getId()
        {
            return id;
        }


    }

    static class SecondInnerClass
    {
        private static List<SecondInnerClass> usersFromSecondClass = new ArrayList<>();
        private final UUID id;
        private String name;

        public SecondInnerClass(String name)
        {
            this.id = UUID.randomUUID();
            this.name = name;
            usersFromSecondClass.add(this);
        }

        public UUID getId()
        {
            return id;
        }

        public void showAllUsers()
        {
            for(SecondInnerClass users: usersFromSecondClass)
            {
                System.out.println(users);
            }
        }

        public Optional<SecondInnerClass> getUserFromUuid(UUID id)
        {
            for(SecondInnerClass users: usersFromSecondClass)
            {
                if(users.getId().equals(id))
                {
                    return Optional.of(users);
                }
            }

            return Optional.empty();
        }


        @Override
        public String toString()
        {
            return "Hi my name is "+name+" my id is "+id;
        }
    }

    public void takeMeToThirdInnerClass()
    {
        class ThirdInnerClass
        {
            // we will define all the properties of the class here and use it here itself

            private String name;
            private String city;
            private String country;
            private int salary;
            private static List<ThirdInnerClass> lists = new ArrayList<>();

            public ThirdInnerClass(String name, String city, String country, int salary)
            {
                this.name = name;
                this.city = city;
                this.country = country;
                this.salary = salary;
            }

            public int getSalary()
            {
                return salary;
            }

            @Override
            public String toString()
            {
                return "Hi my name is "+name+" and I am from "+city+", "+country+" and I make around "+salary;
            }

            public static void partitionUsersBySalary()
            {
                Map<Boolean, List<ThirdInnerClass>> maps = lists.stream()
                        .collect(Collectors.partitioningBy(user-> user.getSalary()>=50000));

                System.out.println("Here are the users having salary greater than 50000");
                maps.get(true).forEach(System.out::println);
                System.out.println("........................");
                System.out.println("Here are the users having salary less than 50000");
                maps.get(false).forEach(System.out::println);

            }

        }

        System.out.println("Welcome to the third inner class lets make some objects");
        System.out.println("........");

        ThirdInnerClass.lists.add(new ThirdInnerClass("Aman Dubey","Bangalore","India",120000));
        ThirdInnerClass.lists.add(new ThirdInnerClass("Archita Dubey","Mumbai","India",20000));
        ThirdInnerClass.lists.add(new ThirdInnerClass("Rachel Weiszy","Tampa","USA",420000));
        ThirdInnerClass.lists.add(new ThirdInnerClass("Mukesh Dubey","Varanasi","India",3000));
        ThirdInnerClass.lists.add(new ThirdInnerClass("Rachel Zigler","California","USA",420000));
        ThirdInnerClass.lists.add(new ThirdInnerClass("Stacy Martin","Paris","France",5000));

        ThirdInnerClass.partitionUsersBySalary();



    }
}


public class Main {

    public static void main(String[] args) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        System.out.println("The date is 25th June 2025");
        OuterClass outerClass = new OuterClass();
        outerClass.takeMeToThirdInnerClass();

        OuterClass.UsersList usersList = outerClass.new UsersList();

        usersList.addUsersToList(new ArrayList<>(Arrays.asList(
                new OuterClass.FirstInnerClass("Aman Dubey", "Varanasi", "India"),
                new OuterClass.FirstInnerClass("Archita Dubey", "Bangalore", "India"),
                new OuterClass.FirstInnerClass("Mukesh Dubey", "Bangalore", "India"),
                new OuterClass.FirstInnerClass("Sharda Dubey", "Balia", "India"),
                new OuterClass.FirstInnerClass("Charlie Dubey", "LA", "USA"),
                new OuterClass.FirstInnerClass("Gabriel", "Mexico City", "USA")
        )));

        OuterClass.SecondInnerClass secondInnerClass = new OuterClass.SecondInnerClass("Aman");
        secondInnerClass.showAllUsers();

        // creating one more instance of the outer class to override the method in it

        OuterClass outerClass1 = new OuterClass()
        {
            @Override
            public void thisIsAMethod()
            {
                for(int i=0;i<100;i++)
                {
                    System.out.println("The function has been overidden fr");
                }
            }
        };
        outerClass1.thisIsAMethod();

        usersList.showAllUsers();
        System.out.println("Broski this part of the code is still in the main thread fr");
        System.out.println("I am mr everything fr fr");
        input.close();

        NoFaceInThis noFaceInThis = (name)-> "Hello I hope you are doing good today "+name;
        String textVal = noFaceInThis.getSomeMessage("Slade Wilson");
        System.out.println(textVal);
        System.out.println();
        selectGreetMessageBasedOnRole("jhfghj","Aman");
    }

    public static void selectGreetMessageBasedOnRole(String role, String name)
    {
        String greet = switch(role)
        {
            case "Engineer" -> "Good Morning";
            case "Professor" -> "Good Morning sir";
            case "Baker" -> "Good Morning Haluwai";
            default -> "Tu kaun hai be ?";

        };

        System.out.println(greet +" "+name);
    }

}
