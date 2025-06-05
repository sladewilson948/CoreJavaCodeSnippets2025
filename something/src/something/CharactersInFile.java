/// I want to make a program where I can see how many times a character is getting used up
package something;
import java.time.Instant;
import java.time.Duration;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CharactersInFile {
    public static void main(String[] args)
    {

        Scanner input = new Scanner(System.in);
        System.out.println("Reading the file!!");
        Map<Character,Integer> myMap = new HashMap<>();

        try(BufferedReader br = new BufferedReader(new FileReader("D:\\JAVA2025\\something\\src\\something\\sample.txt")))
        {
            Instant start = Instant.now();
            String line;
            while((line=br.readLine())!=null)
            {
                line = line.replace(" ","").toLowerCase();
                char[] myArr = line.toCharArray();
                for(char letter: myArr)
                {
                    if(myMap.containsKey(letter))
                    {
                        myMap.put(letter, myMap.get(letter)+1);
                    }
                    else{
                        myMap.put(letter,1);
                    }
                }
            }


            Instant end = Instant.now();
            Long duration = Duration.between(start,end).toMillis();
            System.out.println("Successfuly read the file in : "+duration+" milli seconds");
            for(char letter : myMap.keySet())
            {
                System.out.println(letter + "=>" + myMap.get(letter));
            }
        }
        catch (IOException e)
        {
            System.out.println("There was an exception while reading the file!!");
            e.printStackTrace();
        }
        input.close();
    }

}
