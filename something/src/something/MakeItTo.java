package something;
import org.jetbrains.annotations.NotNull;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;



public class MakeItTo {


    /// now let us try to do the same thing by reading data from a text file

    public static @NotNull String encodeUserInputFromFile(String filePath)
    {
        StringBuilder sb = new StringBuilder();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath)))
        {
            String line;
            while((line=br.readLine())!=null)
            {
                line = line.replace(" ","").toLowerCase();
                sb.append(line);
            }

            String encodedTextFromFile = encodeUserInput(sb.toString());

            return encodedTextFromFile;
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return "Something went wrong while reading the file!!";
        }
    }

    public static @NotNull String encodeUserInput(String textVal)
    {
        /// performing some operations on the text value
        textVal = textVal.replace(" ","").toLowerCase();
        StringBuilder sb = new StringBuilder();
        Map<Character,Integer> map1 = new LinkedHashMap<>();
        for(Character chars: textVal.toCharArray())
        {
            map1.put(chars,map1.getOrDefault(chars,0)+1);
        }
        for(Map.Entry<Character,Integer> entry : map1.entrySet())
        {
            sb.append(entry.getKey()).append(entry.getValue().toString());
        }

        return sb.toString();
    }


    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a very long string here like you like");
        String textVal = input.nextLine();
        String encodedText = encodeUserInput(textVal);
        System.out.println("Encoded text : "+encodedText);
        System.out.println("Encoded text from file : " + encodeUserInputFromFile("D:\\JAVA2025\\something\\src\\something\\sample.txt"));
        input.close();
    }
}
