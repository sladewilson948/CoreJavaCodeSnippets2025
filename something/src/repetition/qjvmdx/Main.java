package repetition.qjvmdx;

import java.util.*;


class OuterClass
{

    public class ManageUsers
    {

        private List<FirstInnerClass> usersList;

        public ManageUsers()
        {
            this.usersList = new ArrayList<>();
        }

        public void addAllUsersToList(List<FirstInnerClass> providedUsers)
        {
            for(FirstInnerClass users: providedUsers)
            {
                usersList.add(users);
            }
            System.out.println("Added all the users to the list!");
        }

        public void showAllTheUsers()
        {
            Runnable showAllUsers = ()->
            {
                for(FirstInnerClass users: usersList)
                {
                    try
                    {
                        System.out.println(users);
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }

                }
            };

            Thread t1 = new Thread(showAllUsers);
            t1.start();
        }

        public Optional<FirstInnerClass> findUserById(UUID id)
        {
            for(FirstInnerClass users: usersList)
            {
                if(users.getId().equals(id))
                {
                    return Optional.of(users);
                }
            }

            return Optional.empty();
        }
    }

    public class FirstInnerClass
    {

        private UUID id;
        private String name;
        private String city;
        private String country;
        private int age;

        public FirstInnerClass(String name, String city, String country, int age)
        {
            this.id = UUID.randomUUID();
            this.name = name;
            this.city = city;
            this.country = country;
            this.age = age;
        }

        @Override
        public String toString()
        {
            return "User => ("+id+", "+name+", "+city+", "+country+", "+age+")";
        }

        public UUID getId()
        {
            return id;
        }

        public int getAge()
        {
            return age;
        }

    }


    public void takeMeToThirdInnerClass()
    {


        class ThirdInnerClass
        {
            private UUID id;
            private String name;
            private String city;
            private int randomNumber;
            private static final Random random = new Random();
            private static List<ThirdInnerClass> usersLists = new ArrayList<>();


            public ThirdInnerClass(String name, String city)
            {
                this.id = UUID.randomUUID();
                this.name = name;
                this.city = city;
                this.randomNumber = random.nextInt(1000);
                usersLists.add(this);
            }

            @Override
            public String toString()
            {
                return "UserFromThirdInner("+id+", "+name+", "+city+", "+randomNumber+")";
            }

            public static void showAllUsers()
            {
                for(ThirdInnerClass users: usersLists)
                {
                    System.out.println(users);
                }
            }

        }

        System.out.println("Welcome to the third inner class from the method");
        System.out.println("Creating users");
        ThirdInnerClass user1 = new ThirdInnerClass("Aman","Bangalore");
        ThirdInnerClass user2 = new ThirdInnerClass("Aman","Bangalore");
        ThirdInnerClass user3 = new ThirdInnerClass("Aman","Bangalore");
        ThirdInnerClass user4 = new ThirdInnerClass("Aman","Bangalore");
        ThirdInnerClass user5 = new ThirdInnerClass("Aman","Bangalore");
        ThirdInnerClass user6 = new ThirdInnerClass("Aman","Bangalore");

        System.out.println("Displaying all the users");
        ThirdInnerClass.showAllUsers();


    }
}




public class Main {

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Revisiting everything");
        System.out.println("Time to create the objects");
        OuterClass outerClass = new OuterClass();
        OuterClass.ManageUsers manageUsers = outerClass.new ManageUsers();
        manageUsers.addAllUsersToList(
                new ArrayList<>(Arrays.asList(
                        outerClass.new FirstInnerClass("Aman Dubey","Bangalore","India",27),
                        outerClass.new FirstInnerClass("Aman Dubey","Bangalore","India",27),
                        outerClass.new FirstInnerClass("Aman Dubey","Bangalore","India",27),
                        outerClass.new FirstInnerClass("Aman Dubey","Bangalore","India",27),
                        outerClass.new FirstInnerClass("Aman Dubey","Bangalore","India",27),
                        outerClass.new FirstInnerClass("Aman Dubey","Bangalore","India",27),
                        outerClass.new FirstInnerClass("Aman Dubey","Bangalore","India",27)
                ))
        );
        System.out.println("Here is a list of all the users");
        manageUsers.showAllTheUsers();
        System.out.println("Enter the user you want to find the id : ");
        UUID id = UUID.fromString(input.nextLine());
        Optional<OuterClass.FirstInnerClass> users =  manageUsers.findUserById(id);

        users.ifPresentOrElse(
                user-> System.out.println("Here is the required user "+user),
                ()-> System.out.println("Did not find the user with the given id")
        );

        outerClass.takeMeToThirdInnerClass();
    }
}
