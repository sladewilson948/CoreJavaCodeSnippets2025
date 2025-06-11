package dosomething;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;


public class Main
{

    public static String getEncodedText(String val)
    {
        val = val.replace(" ","").toLowerCase();
        Map<Character,Integer> map = new LinkedHashMap<>();

        for(char chars: val.toCharArray())
        {
            map.put(chars,map.getOrDefault(chars,0)+1);
        }
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Character,Integer> entry: map.entrySet())
        {
            sb.append(entry.getKey()).append(entry.getValue()).toString();
        }

        return sb.toString();
    }

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a long text here : ");
        String line = input.nextLine();
        System.out.println("Encoded string is : "+getEncodedText(line));

    }
}