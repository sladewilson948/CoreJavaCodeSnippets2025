package something;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



public class letMeSomething {


    /// let us make a function that will read text from a file and will return us a hashmap

    public String giveHashMap(String filePath)
    {
        StringBuilder sb = new StringBuilder();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath)))
        {
            String line;

            while((line = br.readLine())!=null)
            {
                line = line.replace(" ","");
                line = line.toLowerCase();
                sb.append(line);
            }


        }

        catch (IOException e)
        {
            e.printStackTrace();
            System.out.println("Error while reading the file!!!");
        }

        return getAllChars(sb.toString());

    }


    public String getAllChars(String textVal)
    {
        Map<Character,Integer> map1 = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(char myChar: textVal.toCharArray())
        {
            if(map1.containsKey(myChar))
            {
                map1.put(myChar, map1.get(myChar)+1);
            }
            else{
                map1.put(myChar,1);
            }
        }
        for(char chars: map1.keySet())
        {
            sb.append(chars);
        }


        return sb.toString();
    }

    public static void main(String[] args)
    {
        letMeSomething obj = new letMeSomething();
        Scanner input = new Scanner(System.in);
        String res = obj.giveHashMap("D:\\JAVA2025\\user_details.txt");
        System.out.print(res);
        input.close();
    }
}
