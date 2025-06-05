package allwords;
import java.io.*;
import java.util.*;


public class Main {


    /// as a smart programmer what we can also do is save all the result string to a seperate file called possible.txt

    public static void saveAllPossible(List<String> lists)
    {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\JAVA2025\\something\\src\\allwords\\possible.txt")))
        {
            for(String line: lists)
            {
                System.out.println(line);
                bw.write(line+"\n");
            }
            System.out.println("Saved all data to possible.txt file");
        }
        catch (IOException e)
        {
            System.out.println("Error while writing to the file!!");
        }
    }


    public static List<String> getAllPossibleWords(Map map)
    {
        /// now we need to read all the data or text from the dictionary text file that we have
        List<String> result = new ArrayList<>();
        // we will store all the words in this list
        List<String> payload = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader("D:\\JAVA2025\\something\\src\\allwords\\dictionary.txt")))
        {
            String line;
            while((line = br.readLine())!=null)
            {
                line = line.toLowerCase();
                payload.add(line);
            }

            /// now we need interate for each of the word and crrate a hash map for that word
            Map<Character,Integer> wordmap = new HashMap<>();
            for(String word: payload)
            {

                for(char chr: word.toCharArray())
                {
                    wordmap.put(chr,wordmap.getOrDefault(chr,0)+1);
                }
                // now we need to compare from both the maps
                Boolean flag = false;
                for(Map.Entry<Character,Integer> entry: wordmap.entrySet())
                {
                    if(map.containsKey(entry.getKey()) && entry.getValue()<=(int) map.get(entry.getKey()))
                    {
                         flag = true;
                    }
                    else{
                        flag = false;
                        break;
                    }
                }
                if(flag)
                {
                    result.add(word);
                }
                // here we are clearing the map for further iteratrion so that new maps are not created again and again
                wordmap.clear();

            }

        }

        catch (IOException e)
        {
            System.out.println("Error occurred while reading the file");
        }

        return result;
    }


    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to my program to make all words as possible");
        System.out.println("Enter all the chars you want in lowercase : ");
        String textVal = input.nextLine();

        /// creating the map of the text user entyers

        Map<Character,Integer> map1 = new HashMap<>();
        for(Character chars: textVal.toCharArray())
        {
            map1.put(chars, map1.getOrDefault(chars,0)+1);
        }
        //System.out.println("Possible word formations are : "+ getAllPossibleWords(map1));
        saveAllPossible(getAllPossibleWords(map1));

        input.close();
    }
}
