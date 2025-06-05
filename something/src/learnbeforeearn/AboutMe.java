package learnbeforeearn;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class AboutMe {


    public static String encodeInputData(String textVal)
    {
        Map<Character,Integer> map1 = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        textVal = textVal.replace(" ","").toLowerCase();
        for(char chars: textVal.toCharArray())
        {
            map1.put(chars,map1.getOrDefault(chars,0)+1);
        }
        for(Map.Entry<Character,Integer> entry: map1.entrySet())
        {
            sb.append(entry.getKey()).append(entry.getValue().toString());
        }

        return sb.toString();
    }

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a very long string here : ");
        String textVal = input.nextLine();
        System.out.println("Final encoded text value : "+encodeInputData(textVal));
        input.close();
    }
}
