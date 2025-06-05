package something;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Proxy
{

    public static void main(String[] args)
    {

        Scanner input = new Scanner(System.in);
        System.out.println("Let me encode whatever you type in here");
        System.out.println("Enter a very long string here : ");
        StringBuilder sb = new StringBuilder();
        String textVal = input.nextLine();
        textVal = textVal.replace(" ","").toLowerCase();
        Map<Character,Integer> map1 = new HashMap<>();
        for(char myChar: textVal.toCharArray())
        {
            if(map1.containsKey(myChar))
            {
                map1.put(myChar, map1.get(myChar) + 1);
            }
            else{
                map1.put(myChar,1);
            }
        }

        for(char chars: map1.keySet())
        {
            sb.append(chars);
            sb.append(map1.get(chars).toString());
        }
        System.out.println(sb);
        input.close();
    }
}