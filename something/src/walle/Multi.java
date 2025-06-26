package walle;


import java.util.concurrent.ConcurrentHashMap;

public class Multi {

    public static void main(String[] args)
    {

        ConcurrentHashMap<Integer, String> maps = new ConcurrentHashMap<>();

        Runnable partone = ()-> {

            for(int i=0;i<100;i++)
            {
                maps.put(i,"The value "+i+1);
                System.out.println("Added value "+i+1+" in the hash map");
            }
        };

        Runnable parttwo = ()-> {

            for(int i=0;i<100;i++)
            {
                String value = maps.get(i);
                System.out.println("The value for key "+i+ " is "+value);
            }
        };


        Thread t1 = new Thread(partone);
        Thread t2 = new Thread(parttwo);

        t1.start();
        t2.start();

    }
}
