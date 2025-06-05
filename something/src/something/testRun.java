package something;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;


public class testRun {


    public static String encodedText(String textVal)
    {

        /// slight cleanup on the textVal by eliminating extra space and making it all in lowercase
        textVal = textVal.replace(" ","").toLowerCase();
        StringBuilder sb = new StringBuilder();
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
        System.out.println("Let us try to encode what you type in here rally fast");
        System.out.println("Please enter a very long string here : ");
        String textVal = input.nextLine();
        String output = encodedText(textVal);
        System.out.println("Final output after encoding is : "+output);
        input.close();
    }
}
