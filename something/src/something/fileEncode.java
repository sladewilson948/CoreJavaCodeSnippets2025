package something;
import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;



public class fileEncode {


    public String encodeFile(String filePath)
    {
        StringBuilder sb = new StringBuilder();
        Map<Character,Integer> map1 = new LinkedHashMap<>();
        for(char chars: extractTextContentFromFile(filePath).toCharArray())
        {
            map1.put(chars, map1.getOrDefault(chars,0)+1);
        }

        // time to build the encoding part
        for(Map.Entry<Character,Integer> entry: map1.entrySet()){
            sb.append(entry.getKey()).append(entry.getValue().toString());
        }

        return sb.toString();

    }


    /// now we can define a method which will write the extracted data back into the text file

    public void addEncodedDataToTextFile(String encodedText)
    {
        try(BufferedWriter br = new BufferedWriter(new FileWriter("D:\\JAVA2025\\something\\src\\something\\encoding.txt")))
        {
            br.write(encodedText);

        }
        catch (IOException e)
        {
            e.printStackTrace();
            System.out.println("Some error while trying to read the file");

        }

    }

    public String extractTextContentFromFile(String filePath)
    {
        StringBuilder sb = new StringBuilder();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath)))
        {
            String line;
            while((line=br.readLine())!=null)
            {
                String clearText = line.replace(" ","").toLowerCase();
                sb.append(clearText);
            }

            return sb.toString();
        }

        catch (IOException e)
        {
            e.printStackTrace();
            return "Something went wrong while reading the file!";
        }
    }


    public static void main(String[] args)
    {
        fileEncode fe = new fileEncode();
        System.out.println("Welcome to my program to encode and decode entire files!!");
        System.out.println("Reading the file info!!");
        String res = fe.encodeFile("D:\\JAVA2025\\something\\src\\something\\sample.txt");
        fe.addEncodedDataToTextFile(res);
        System.out.println("Successfully added the encoded content to the text file!!!");

    }
}
