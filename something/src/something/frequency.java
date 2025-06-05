package something;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



public class frequency {


    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        Map<Character,Integer> myMap = new HashMap<>();

        System.out.println("Please type a very long text here");
        String text = input.nextLine();
        text = text.replace(" ","");
        text = text.toLowerCase();
        char[] arr1 = text.toCharArray();

        for(char letter: arr1)
        {
            if(myMap.containsKey(letter))
            {
                myMap.put(letter, myMap.get(letter)+1);
            }
            else{
                myMap.put(letter,1);
            }
        }
        System.out.println(myMap);

        for(char key: myMap.keySet())
        {
            System.out.println(key + " => " +myMap.get(key));
        }
        input.close();
    }
}
