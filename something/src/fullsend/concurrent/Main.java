package fullsend.concurrent;

import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        ConcurrentHashMap<Integer, String> maps = new ConcurrentHashMap<>();


        Runnable writer = ()-> {

            for(int i=0;i<20;i++)
            {
                maps.put(i,"value "+i);
                System.out.println("Written value in map");
            }
        };

        Runnable reader = ()-> {

            for(int i=0;i<20;i++)
            {
                String val = maps.get(i);
                System.out.println("Fetched value is "+val);
            }
        };

        Thread t1 = new Thread(writer);
        Thread t2 = new Thread(reader);

        t1.start();
        t2.start();

        input.close();
    }
}
