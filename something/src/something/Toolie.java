package something;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Toolie {


    private Map<String,String> encodingMap = new HashMap<>();
    private static String password = "26JF4QBJJ6";

    public Map<String,String> getMapping(String pass)
    {
        if(pass.equals(password))
        {
            return encodingMap;
        }
        return null;

    }

    public String inputEncode(String textVal)
    {
        Map<Character,Integer> freqMap = new LinkedHashMap<>();
        StringBuilder sb = new StringBuilder();
        String cleanText = textVal.replace(" ","").toLowerCase();

        for(char chars: cleanText.toCharArray())
        {
            freqMap.put(chars, freqMap.getOrDefault(chars,0)+1);
        }

        for(Map.Entry<Character,Integer> entry: freqMap.entrySet())
        {
            sb.append(entry.getKey()).append(entry.getValue().toString());
        }

        encodingMap.put(sb.toString(),textVal);

        return sb.toString();

    }

    public String inputDecode(String textVal)
    {
        return encodingMap.getOrDefault(textVal, "you did not encode the string in the first place");
    }


    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        // the part which handles the input
        System.out.println("Welcome to my internal tool to encode and decode strings with ease");
        System.out.println("Select one of the options : ");
        Toolie tool = new Toolie();
        while(true)
        {
            System.out.println("To encode string press 1");
            System.out.println("To decode string press 2");
            System.out.println("To quit press 3");
            System.out.println("To see mapping press 4");
            System.out.print("Select option : ");
            int option = input.nextInt();
            input.nextLine();


            if(option==3) break;
            if(option==1)
            {
                System.out.println("Enter the text you want to encode");
                String textVal = input.nextLine();
                System.out.println("Encoded string : "+tool.inputEncode(textVal));
            } else if (option==2) {
                System.out.println("Enter the text you want to decode");
                String textVal = input.nextLine();
                System.out.println("Decoded string : "+tool.inputDecode(textVal));
            } else if (option==4) {
                System.out.println("Enter password : ");
                String pass = input.nextLine();
                System.out.println(tool.getMapping(pass));
            }
        }

        input.close();

    }
}
