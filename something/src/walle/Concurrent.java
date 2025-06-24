package walle;

import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Scanner;
import java.util.List;


class UserDetails
{
    Scanner input = new Scanner(System.in);

    private ConcurrentHashMap<Integer, List<String>> maps;

    public UserDetails()
    {
        this.maps = new ConcurrentHashMap<>();
    }

    public void updateKeyValueInMap(int id)
    {
        System.out.println("Enter the details you want to enter with a single space");
        String inputText = input.nextLine();
        List<String> newDetails = List.of(inputText.split(" "));
        addDetailsToMap(id,newDetails);
    }

    public void addDetailsToMap(int id, List<String> details)
    {
        maps.put(id,details);
        System.out.println("Value set in the map");
    }

    public void showMap()
    {
        System.out.println(maps);
    }


}


public class Concurrent {

    private static final Random random = new Random();

    public static void main(String[] args)
    {
        System.out.println("Welcome to the program!");
        System.out.println("In this program we will see the use of concurrent hash maps");
        System.out.println("Please provide us with the required details");
        Scanner input = new Scanner(System.in);
        UserDetails userDetails = new UserDetails();
        for(int i=0;i<5;i++)
        {
            int id = getRandomInteger();
            System.out.println("Please provide some data with a single space");
            String textVal = input.nextLine();
            List<String> details = List.of(textVal.split(" "));
            userDetails.addDetailsToMap(id, details);

        }
        userDetails.showMap();
        System.out.println("Enter the key you want to update the value of");
        int key = Integer.parseInt(input.nextLine());
        userDetails.updateKeyValueInMap(key);
        userDetails.showMap();
        System.out.println("Let us also now see how we can make use of mutli threading in java and how concurrent mps are thread safe");

        Runnable writer = ()->{

            for(int i=0;i<1000;i++)
            {
                userDetails.addDetailsToMap(getRandomInteger(),  getRandomTextValue());
                System.out.println("Added value to hash map");
            }
        };

        Runnable reader = ()-> {
            for(int i=0;i<1000;i++)
            {
                userDetails.showMap();
            }
        };


        Thread t1 = new Thread(writer);
        Thread t2 = new Thread(reader);

        t1.start();
        t2.start();


        input.close();
    }


    public static List<String> getRandomTextValue()
    {
        List<String> arr1 = new ArrayList<>(Arrays.asList(
                "Hi","my","name","is","Aman","Dubey","I","hope"
        ));
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<4;i++)
        {
            sb.append(arr1.get(random.nextInt(arr1.size())));
            sb.append(" ");
        }

        if(sb.length()>1)
        {
            sb.setLength(sb.length()-1);
        }
        return List.of(sb.toString().split(" "));


    }

    public static int getRandomInteger()
    {
        return random.nextInt(10000);
    }
}
