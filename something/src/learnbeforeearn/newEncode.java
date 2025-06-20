package learnbeforeearn;

import org.jetbrains.annotations.NotNull;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Map;



public class newEncode {


    public static @NotNull String createMap(String textVal)
    {
        // fitst we need to define a map
        textVal = textVal.replace(" ","").toLowerCase();
        Map<Character,Integer> map = new LinkedHashMap<>();
        for(char chars: textVal.toCharArray())
        {
            map.put(chars,map.getOrDefault(chars,0)+1);
        }

        return encodeText(map);
    }

    public static @NotNull String encodeText(Map<Character,Integer> map)
    {
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Character,Integer> entry: map.entrySet())
        {
            sb.append(entry.getKey()).append(entry.getValue().toString());
        }

        return sb.toString();
    }


    public static void main(String[]  args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a very long string here : ");
        String textVal = input.nextLine();
        System.out.println(createMap(textVal));
        input.close();
    }
}
