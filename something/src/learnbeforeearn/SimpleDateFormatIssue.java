package learnbeforeearn;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleDateFormatIssue {

    /// what we are seeing here is very unexpected behaviour each time we run this code the reason being that the simple date format is not thread safe
    /// simple date format is not thread safe
    /// basically instead of creating a hsred sinmple date format for all thread
    /// we should make a new simple data format Object for each thread when they run
    // private static final SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

    public static void main(String[] args)
    {
        String dateString = "2020-19-17T12:34:15";

        // gives us ten threads to run simultaneously
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Runnable runnable  = () -> {

            try
            {
                Date date = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse(dateString);
                System.out.println("Successfuly parsed the date : "+date);
            }
            catch(Exception e)
            {
                System.out.println("Exception : ");
                e.printStackTrace();
            }
        };

        for(int i=0;i<10;i++)
        {
            executorService.submit(runnable);
        }
        executorService.shutdown();

    }
}
