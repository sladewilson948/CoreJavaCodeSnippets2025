package something;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class MyCollections {

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        Map<Character,Integer> myMap = new HashMap<>();
        System.out.println("Please enter a very long string here : ");
        String text = input.nextLine().replace(" ","").toLowerCase();
        for(int i=0;i<text.length();i++)
        {
            if(myMap.containsKey(text.charAt(i)))
            {
                myMap.put(text.charAt(i), myMap.get(text.charAt(i))+1);
            }
            else{
                myMap.put(text.charAt(i), 1);
            }
        }

        for(char letter: myMap.keySet())
        {
            System.out.println(letter + "=>" + myMap.get(letter));
        }
        System.out.println("Character user : " + myMap.size() + "/26");

        input.close();
    }
}
