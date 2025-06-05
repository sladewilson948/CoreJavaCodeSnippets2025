package learnbeforeearn;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Scanner;



public class Today {



    public static String encodedTextFromFile()
    {
        StringBuilder sb = new StringBuilder();
        try(BufferedReader br = new BufferedReader(new FileReader("D:\\JAVA2025\\something\\src\\learnbeforeearn\\data.txt")))
        {
            String line;
            while((line = br.readLine())!=null)
            {
                line = line.replace(" ","").toLowerCase();
                sb.append(line);
            }

            // time to make the frequency map here
            Map<Character,Integer> map1 = new LinkedHashMap<>();
            for(char chars: sb.toString().toCharArray())
            {
                map1.put(chars,map1.getOrDefault(chars,0)+1);
            }
            /// time to build the answer string
            /// clearing the string builder object
            sb.setLength(0);

            for(Map.Entry<Character,Integer> entry: map1.entrySet())
            {
                sb.append(entry.getKey()).append(entry.getValue().toString());
            }

            return sb.toString();
        }
        catch (IOException e)
        {
            return "Error while reading the file!!";
        }
    }

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to my text encoder program");
        System.out.println("The encoded value is : " + encodedTextFromFile());
    }
}
