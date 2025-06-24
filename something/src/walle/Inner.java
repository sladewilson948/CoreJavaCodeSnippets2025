package walle;


import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

class FirstInner
{



    class ExtraProperties
    {

        private List<InsideFirstInner> usersList;

        public ExtraProperties()
        {
            this.usersList = new ArrayList<>();
        }

        public void addAllUsersToList(List<InsideFirstInner> providedUsersList)
        {
            for(InsideFirstInner users: providedUsersList)
            {
                usersList.add(users);
            }
            System.out.println("Successfully added all the users to the list");
        }

        public void showAllUsersFromList()
        {
            for(int i=0;i<usersList.size();i++)
            {
                System.out.println(usersList.get(i));
            }
        }

        public Optional<InsideFirstInner> getUserById(int id)
        {
            for(InsideFirstInner users: usersList)
            {
                if(users.getId()==id)
                {
                    return Optional.of(users);
                }
            }
            return Optional.empty();
        }
    }


    class InsideFirstInner
    {

        private int id;
        private String name;
        private String city;
        private String country;
        private int age;
        private static final Random random = new Random();


        public InsideFirstInner(String name, String city, String country, int age)
        {
            this.id = random.nextInt(1000);
            this.name = name;
            this.city = city;
            this.country = country;
            this.age = age;
        }

        @Override
        public String toString()
        {
            return "User("+"id:"+id+"name:"+name+" city:"+city+" country:"+country+" age"+age+")";
        }

        public int getId()
        {
            return id;
        }
    }

    public void takeMeToInnerClass()
    {
        // the moment the method above is called the control will come here, and we will operate evreything here class aand its methods
        class InsideSecondInnerClass
        {

            private int id;
            private String name;
            private String city;
            private String country;
            private static final AtomicInteger counter = new AtomicInteger(1);

            public InsideSecondInnerClass(String name, String city, String country)
            {
                this.id = counter.getAndIncrement();
                this.name = name;
                this.city = city;
                this.country = country;
            }

            @Override
            public String toString()
            {
                return "User(id: " + id + ", name: " + name + ", city: " + city + ", country: " + country;
            }

            public int getId()
            {
                return id;
            }
        }

        System.out.println("Welcome to the second inner class");
        InsideSecondInnerClass insideSecondInnerClass = new InsideSecondInnerClass("Aman Dubey fr","Bangalore","India");
        System.out.println(insideSecondInnerClass);
        System.out.println(insideSecondInnerClass.getId());
    }
}


class Inner
{

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Lets talk about inner classes");
        System.out.println("Making the object for inner class");
        FirstInner firstInner = new FirstInner();
        FirstInner.ExtraProperties extraProperties = firstInner.new ExtraProperties();
        System.out.println("Creating users lists now");
        List<FirstInner.InsideFirstInner> providedList = new ArrayList<>(Arrays.asList(
                firstInner.new InsideFirstInner("Aman Dubey","Bangalore","India",27),
                firstInner.new InsideFirstInner("Archita Dubey","Mumbai","India",22),
                firstInner.new InsideFirstInner("Mukesh Dubey","Varanasi","India",43),
                firstInner.new InsideFirstInner("Shard Dubey","Balia","India",22),
                firstInner.new InsideFirstInner("Slade Wilson","Bangalore","India",27),
                firstInner.new InsideFirstInner("Deadshot","Bangalore","India",27)
        ));
        extraProperties.addAllUsersToList(providedList);
        extraProperties.showAllUsersFromList();
        System.out.println("Enter the id you want to search");
        int id = Integer.parseInt(input.nextLine());
        Optional<FirstInner.InsideFirstInner> user = extraProperties.getUserById(id);

        user.ifPresentOrElse(
                foundUser-> System.out.println("Users found "+foundUser),
                ()-> System.out.println("User not found with the id "+ id)
        );
        firstInner.takeMeToInnerClass();
    }
}