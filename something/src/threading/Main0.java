package threading;
import java.util.ArrayList;
import java.util.Random;
import java.util.List;
import java.util.Arrays;


/// the other way to implement thread is to make use of the Runnable interface

class MyThreadTwo implements Runnable
{

    private int threadNumber;

    public MyThreadTwo(int threadNumber)
    {
        this.threadNumber = threadNumber;
    }


    @Override
    public void run()
    {
        for(int i=0;i<10;i++)
        {
            System.out.println("Hi my name is Aman Dubey " + "my thread number is "+ threadNumber);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }


    }
}


// this is one way to implement the thread
class MyThreadOne extends Thread
{

    private int threadNumber;

    public MyThreadOne(int threadNumber)
    {
        this.threadNumber = threadNumber;
    }

    public static String getRandomName()
    {
        List<String> names = new ArrayList<>(Arrays.asList("Aman","Archita","Mukesh","Sharda","Lokesh","Venkat","Ravi"));
        return names.get(new Random().nextInt(names.size()));
    }

    @Override
    public void run()
    {
        // in this part of the code we write the code which each of the thread will run
        for(int i=0;i<10;i++)
        {
            System.out.println("Hi my name is : "+getRandomName() + " the thread number is "+threadNumber);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }


    }
}

public class Main0 {


    public static void main(String[] args)
    {
        System.out.println("We will see what are the diffrent ways to actually implement the threads in Java");
        for(int i=0;i<10;i++)
        {
            MyThreadOne myThread = new MyThreadOne(i);
            myThread.start();
        }

        System.out.println("Now let us see the other way of doing this");
        for(int i=0;i<10;i++)
        {
            MyThreadTwo myThreadTwo = new MyThreadTwo(i);
            Thread thread = new Thread(myThreadTwo);
            thread.start();
        }

    }
}
