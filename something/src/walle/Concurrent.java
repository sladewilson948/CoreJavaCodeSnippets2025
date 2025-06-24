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
        input.close();
    }


    public static int getRandomInteger()
    {
        return random.nextInt(10000);
    }
}
