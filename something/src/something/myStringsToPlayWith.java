package something;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;


public class myStringsToPlayWith
{

    Map<String,String> map1 = new HashMap<>();


    public String encodeString(String textVal)
    {
        StringBuilder sb = new StringBuilder();
        Map<Character,Integer> map2 = new LinkedHashMap<>();
        String cleanText = textVal.replace(" ","").toLowerCase();
        for(char chars : cleanText.toCharArray())
        {
            map2.put(chars, map2.getOrDefault(chars,0)+1);
        }

        for(Map.Entry<Character,Integer> entry: map2.entrySet())
        {
            sb.append(entry.getKey()).append(entry.getValue());
        }

        // now we need to store the string we coded to the coded value in map1 so that we can later retrive the coded value
        map1.put(sb.toString(),textVal);
        return sb.toString();


    }

    public String decodeString(String textVal)
    {
        return map1.getOrDefault(textVal, "you did not encode this string in the first place");
    }

    public static void main(String[] args)
    {

        Scanner input = new Scanner(System.in);
        myStringsToPlayWith obj = new myStringsToPlayWith();
        System.out.println("Enter the string that you want to encode : ");
        String text = input.nextLine();
        System.out.println("The encoded string is : "+obj.encodeString(text));
        System.out.println("Enter the string that you want to decode back : ");
        String textIn = input.nextLine();
        System.out.println("The decoded string is : "+obj.decodeString(textIn));
        input.close();
    }
}