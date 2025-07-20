package virtualthread;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        final int threadCount = 1000;
        List<Thread> threads = new ArrayList<>();

        Runnable t1 = () -> {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        };

        for(int i=0;i<threadCount;i++)
        {
//            Thread thread = new Thread(t1);  this is the the use of platform thread which makie ti using of os resources
//            Thread thread = Thread.ofVirtual().unstarted(t1);
//            thread.setName("thread "+i);
//            thread.start();
//            System.out.println("Thread number => "+i);
//            threads.add(thread);
        }


        for(Thread thread: threads)
        {
            thread.join();
            System.out.println("Completed : "+thread.getName());
        }
    }

}
