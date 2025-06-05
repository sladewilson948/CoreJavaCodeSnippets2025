package learnbeforeearn;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Alphabets {


    public static void addDataToFile(String textVal)
    {
        StringBuilder sb = new StringBuilder();
        textVal = textVal.replace(" ","").toLowerCase();
        Map<Character,Integer> map1 = new HashMap<>();

        for(char chars: textVal.toCharArray())
        {
            map1.put(chars, map1.getOrDefault(chars,0)+1);
        }

        for(Map.Entry<Character,Integer> entry: map1.entrySet())
        {
            String line = entry.getKey() + " => " + entry.getValue().toString() + "\n";
            sb.append(line);
        }
        if (sb.length()>0)
        {
            sb.setLength(sb.length()-1);
        }
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("someonfo.txt")))
        {
            bw.write(sb.toString());
            System.out.println("Successfully added all the data to the text file!!");
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a very long string here : ");
        String textVal = input.nextLine();
        addDataToFile(textVal);
        input.close();
    }
}
