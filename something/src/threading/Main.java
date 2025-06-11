package threading;
import java.util.Scanner;


class MultiThreading extends Thread
{
    private int threadNumber;

    public MultiThreading(int threadNumber)
    {
        this.threadNumber = threadNumber;
    }

    @Override
    public void run()
    {
        // here we will basically write the code that we want to be executed in a seperate thread
        for(int i=0;i<10;i++)
        {
            System.out.println(i + "The thread number is " + threadNumber);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class Main {

    public static void main(String[] args)
    {
        System.out.println("In this program we will see how to use multi threading!!");
        System.out.println("Lets create like 10 diffrent threads now");
        for(int i=0;i<10;i++)
        {
            MultiThreading multi = new MultiThreading(i);
            multi.start();
        }

    }

}
