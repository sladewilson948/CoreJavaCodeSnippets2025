package learnbeforeearn;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



public class AboutYou {



    public static String encodeString(String textVal)
    {
        StringBuilder sb = new StringBuilder();
        Map<Character,Integer> map = new HashMap<>();
        textVal = textVal.replace(" ","").toLowerCase();
        for(char chars: textVal.toCharArray())
        {
            map.put(chars,map.getOrDefault(chars,0)+1);
        }
        // time to build the encoded string
        for(Map.Entry<Character,Integer> entry: map.entrySet())
        {
            sb.append(entry.getKey()).append(entry.getValue().toString());
        }

        return sb.toString();

    }


    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a very long string here : ");
        String text = input.nextLine();
        System.out.println("Decoded text is : "+encodeString(text));
        input.close();
    }
}
