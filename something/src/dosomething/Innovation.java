package dosomething;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Innovation {


    public static String getEncodedString(String textVal)
    {
        StringBuilder sb = new StringBuilder();
        textVal = textVal.replace(" ","").toLowerCase();
        Map<Character,Integer> map = new LinkedHashMap<>();
        for(char chars: textVal.toCharArray())
        {
            map.put(chars,map.getOrDefault(chars,0)+1);
        }

        for(Map.Entry<Character,Integer> entry: map.entrySet())
        {
            sb.append(entry.getKey()).append(entry.getValue().toString());
        }

        return sb.toString();
    }

    public static void main(String[] args)
    {

        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to my application : ");
        System.out.println("Please enter a very logn string here");
        String line = input.nextLine();
        System.out.println("Encoded string is " + getEncodedString(line));
        input.close();
    }
}
