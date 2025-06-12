package practicemakesperfect;



/// let us see the other way to use Thread


class MyThreadClassTwo implements Runnable
{

    private int threadNumber;

    public MyThreadClassTwo(int threadNumber)
    {
        this.threadNumber = threadNumber;
    }

    @Override
    public void run()
    {
        for(int i=0;i<10;i++)
        {
            System.out.println("Hello there the thread number is "+threadNumber);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}


class MyThreadClassOne extends Thread
{

    private int threadNumber;

    public MyThreadClassOne(int threadNumber)
    {
        this.threadNumber = threadNumber;
    }

    @Override
    public void run()
    {
        for(int i=0;i<10;i++)
        {
            System.out.println("Thread number "+threadNumber+" says hello");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

    }
}



public class MultiThread {


    public static void main(String[] args) throws InterruptedException {
        for(int i=0;i<10;i++)
        {

            MyThreadClassOne thread1 = new MyThreadClassOne(i);
            thread1.start();

        }

        for(int i=0;i<10;i++)
        {
            MyThreadClassTwo mtct = new MyThreadClassTwo(i);
            Thread thread = new Thread(mtct);
            thread.start();
        }

    }
}
