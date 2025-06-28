package repetition.xqjbme;
import java.util.*;
import java.util.stream.Collectors;


class OutterClass{

    class FirstInnerClass
    {

    }

    static class SeccondInnerClass
    {

    }

    public void takeMeToThirdInnerClass(Scanner input) throws InterruptedException {

        class ThirdInnerClass
        {

            private UUID id;
            private String name;
            private String city;
            private String country;
            private int randomNumber;
            private static final Random random = new Random();


            public ThirdInnerClass(String name, String city, String country)
            {
                this.id = UUID.randomUUID();
                this.name = name;
                this.city = city;
                this.country = country;
                this.randomNumber = random.nextInt(10000);
            }

            @Override
            public String toString()
            {
                return "User(id:"+id+", name:"+name+", city:"+city+", country:"+country+", randomNum:"+randomNumber+")";
            }

            public UUID getId()
            {
                return id;
            }

            public int getRandomNumber()
            {
                return randomNumber;
            }
        }

        class ThirdInnerClassUtil
        {

            private List<ThirdInnerClass> usersList;

            public ThirdInnerClassUtil()
            {
                this.usersList = new ArrayList<>();
            }

            public void addUsersToList(List<ThirdInnerClass> providedList)
            {
                for(ThirdInnerClass users: providedList)
                {
                    usersList.add(users);
                }
                System.out.println("Successfully added all the users to the list");
            }

            public void showAllUsers() throws InterruptedException {
                Runnable doThis = ()-> {
                    for(ThirdInnerClass users: usersList)
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

                Thread t1 = new Thread(doThis);
                t1.start();
                t1.join();

            }

            public Optional<ThirdInnerClass> findUserByUuid(UUID id)
            {
                for(ThirdInnerClass users: usersList)
                {
                    if(users.getId().equals(id))
                    {
                        return Optional.of(users);
                    }
                }

                return Optional.empty();
            }

            public void partitionTheUsersByRandomNumber()
            {
                Map<Boolean, List<ThirdInnerClass>> maps =  usersList.stream()
                        .collect(Collectors.partitioningBy(user->user.getRandomNumber()>=5000));
                System.out.println("Now we have the map");
                System.out.println("This is a list of all users having random number more than 5000");
                maps.get(true).forEach(System.out::println);
                System.out.println("...................");
                System.out.println("This is the list of all the users having random number less than 5000");
                maps.get(false).forEach(System.out::println);
                System.out.println("Have a nice day");
                System.out.println("Have a nice day");
            }
        }


        System.out.println("Welcome to the third inner class");
        System.out.println("Lets go crazy fr fr");

        ThirdInnerClassUtil thirdInnerClassUtil = new ThirdInnerClassUtil();
        List<ThirdInnerClass> providedList = new ArrayList<>(Arrays.asList(
                new ThirdInnerClass("Aman Dubey","Bangalore","India"),
                new ThirdInnerClass("Archita Dubey","Mumbai","India"),
                new ThirdInnerClass("Mukesh Dubey","Varanasi","India"),
                new ThirdInnerClass("Sharda Dubey","Balia","India"),
                new ThirdInnerClass("Chareli Puth","Bangalore","India")
        ));
        thirdInnerClassUtil.addUsersToList(providedList);

        thirdInnerClassUtil.showAllUsers();
        thirdInnerClassUtil.partitionTheUsersByRandomNumber();
        System.out.println("............");
        System.out.println("Enter the uuid you want to search");
        UUID uuid = UUID.fromString(input.nextLine());
        Optional<ThirdInnerClass> user = thirdInnerClassUtil.findUserByUuid(uuid);
        user.ifPresentOrElse(
                optionalUser-> System.out.println("Required user : "+optionalUser),
                ()-> System.out.println("Did not find any user")
        );

    }
}

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the application!");
        System.out.println("LET US BEGIN");
        OutterClass outterClass = new OutterClass();
        outterClass.takeMeToThirdInnerClass(input);
    }
}
