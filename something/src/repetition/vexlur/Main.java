package repetition.vexlur;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

class OutterClass
{

    public void overrideMe()
    {
        System.out.println("I am doing something!");
    }
    class FirstClassUserUtility
    {

        private List<FirstInnerClass> usersLists;

        public FirstClassUserUtility()
        {
            this.usersLists = new ArrayList<>();
        }

        public Optional<FirstInnerClass> searchByUUID(String id)
        {
            for(FirstInnerClass users : usersLists)
            {
                if(users.id.equals(UUID.fromString(id)))
                {
                    return Optional.of(users);
                }
            }
            return Optional.empty();
        }

        public void addAllFirstClassUsersToList(List<FirstInnerClass> providedList)
        {
            for(FirstInnerClass users: providedList)
            {
                usersLists.add(users);
            }
            System.out.println("Added all the users successfuly");
        }

        public void showAllUsers()
        {
            System.out.println("Here is a list of all the users");
            for(FirstInnerClass users: usersLists)
            {
                System.out.println(users);
            }
        }

        public void provideTextDataForEachUserFile(Scanner input){
            for(FirstInnerClass users: usersLists)
            {
                String filename = users.getFileName();
                System.out.println("Enter the data you want to enter in the text file");
                try(BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\JAVA2025\\something\\src\\repetition\\vexlur\\output\\"+filename)))
                {
                    StringBuilder sb1 = new StringBuilder();

                    while(true)
                    {
                        String data1 = input.nextLine();
                        if(data1.equals(""))
                        {
                            break;
                        }
                        sb1.append(data1);
                        sb1.append("\n");
                    }
                    if(sb1.length()>0)
                    {
                        sb1.setLength(sb1.length()-1);
                    }
                    // time to encode the text file
                    String encodedText = Base64.getEncoder().encodeToString(sb1.toString().getBytes(StandardCharsets.UTF_8));
                    bw.write(encodedText);
                }

                catch (IOException e)
                {
                    System.out.println("Something went wrong while writing to the file!!");
                }
            }
            System.out.println("Data added in the files of all the users");
        }

        public void decryptAllTheDataOfUsers() throws IOException {
            for(FirstInnerClass user: usersLists)
            {
                String filename = user.getFileName();
                String lines = Files.readString(Paths.get("D:\\JAVA2025\\something\\src\\repetition\\vexlur\\output\\"+filename));
                String decodedText = new String(Base64.getDecoder().decode(lines));
                System.out.println("............");
                System.out.println(decodedText);
                System.out.println("............");
            }
        }


        public void timeToPlayWithThreads(Scanner input)
        {
            FirstInnerClass firstInnerClass = new FirstInnerClass("asd","asd");

            System.out.println("We will have some threads and some tasks that we will perform using thread");
            Runnable task1 = ()->{

                for(int i=0;i<20;i++)
                {
                    System.out.println("Hi there my name is "+firstInnerClass.getFileName());

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

            Runnable task2 = ()-> {

                System.out.println("Enter a number : ");
                int number = Integer.parseInt(input.nextLine());
                for(int i=0;i<number;i++)
                {
                    System.out.println("Broski I am a legend here");
                }
            };

            Thread t1 = new Thread(task1);
            Thread t2 = new Thread(task2);
            t1.start();
            t2.start();


        }
    }

    class FirstInnerClass
    {
        // this class will be used to encode and decode strings for a particular user
        private UUID id;
        private String name;
        private String city;
        private String fileName;
        private static final Random random = new Random();


        public FirstInnerClass(String name, String city)
        {
            this.id = UUID.randomUUID();
            this.name = name;
            this.city = city;
            this.fileName = getRandomFileName();

        }

        public static String getRandomFileName()
        {
            List<String> allLetters = Arrays.asList("a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z");
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<6;i++)
            {
                sb.append(allLetters.get(random.nextInt(26)));
            }

            return sb + ".txt";
        }

        public String getFileName()
        {
            return fileName;
        }

        @Override
        public String toString()
        {
            return "User("+id+", "+name+", "+city+", "+fileName+")";
        }

    }

}

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("I am going to squeeze in all the java topics in this");
        OutterClass outterClass = new OutterClass();
        OutterClass.FirstClassUserUtility firstClassUserUtility = outterClass.new FirstClassUserUtility();
        firstClassUserUtility.addAllFirstClassUsersToList(

                Arrays.asList(

                        outterClass.new FirstInnerClass("Aman Dubey","Varanasi"),
                        outterClass.new FirstInnerClass("Archita Dubey","Mumbai"),
                        outterClass.new FirstInnerClass("Sharda Dubey","Balia"),
                        outterClass.new FirstInnerClass("Mukesh Dubey","Varanasi"),
                        outterClass.new FirstInnerClass("Charlie the dog","Varanasi")
                )
        );
        firstClassUserUtility.provideTextDataForEachUserFile(input);
        firstClassUserUtility.decryptAllTheDataOfUsers();
        outterClass.overrideMe();
        OutterClass outterClass1 = new OutterClass(){

            @Override
            public void overrideMe()
            {
                for(int i=0;i<10;i++)
                {
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
                userFound-> System.out.println("The required user is "+userFound),
                ()-> System.out.println("Did not find any user for the id "+id)
        );
        System.out.println("Its threading time!");
        firstClassUserUtility.timeToPlayWithThreads(input);
        input.close();
    }
}
