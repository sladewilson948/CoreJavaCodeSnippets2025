package threading;
import java.util.*;


class MyThreadThing implements Runnable
{
    private int threadNumber;

    public static String getRandomName()
    {
        List<String> names = new ArrayList<>(Arrays.asList("Aman","Archita","Rachel","Skibidi","Munna","Bajaranagi","Mohan"));
        return names.get(new Random().nextInt(names.size()));
    }

    public MyThreadThing(int threadNumber)
    {
        this.threadNumber = threadNumber;
    }
    Scanner input = new Scanner(System.in);


    @Override
    public void run()
    {
        /// here we are going to do what each of the thread will actually do

        System.out.println("Please enter your name : ");
        String name = getRandomName();
        for(int i=0;i<new Random().nextInt(10);i++)
        {
            System.out.println("Hi my name is "+name + " my thread number is "+threadNumber);
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        input.close();

    }
}


public class Main1 {

    public static void main(String[] args)
    {
        System.out.println("Welcome to my java program");
        System.out.println("Let us create a thread");
        for(int i=0;i<10;i++)
        {
            MyThreadThing mything = new MyThreadThing(i);
            Thread thread = new Thread(mything);
            thread.start();
        }
    }
}
