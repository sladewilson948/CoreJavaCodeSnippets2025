package learnbeforeearn;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;



public class PlainObject
{

    public static String getEncodedText(String textVal)
    {
        textVal = textVal.replace(" ","").toLowerCase();
        Map<Character,Integer> map = new LinkedHashMap<>();
        for(char chars: textVal.toCharArray())
        {
            map.put(chars,map.getOrDefault(chars,0)+1);
        }

        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Character,Integer> entry: map.entrySet())
        {
            sb.append(entry.getKey()).append(entry.getValue().toString());
        }

        return sb.toString();
    }

    public static void main(String[] args)
    {


        Scanner input =  new Scanner(System.in);
        System.out.println("Let us get to know each other");
        System.out.println("Type a long text in here : ");
        String line = input.nextLine();
        String output = getEncodedText(line);
        System.out.println("Encoded text is : "+output);
        input.close();
    }
}