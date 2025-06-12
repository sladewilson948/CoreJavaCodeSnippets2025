package rivisitingInnnerClasses;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Base64;
import java.util.Scanner;


public class Main {

    public String decodeString(String textValue)
    {
        byte[] arr1 =  Base64.getDecoder().decode(textValue);
        return new String(arr1);
    }

    public String encodeFile(String filePath)
    {
        StringBuilder sb = new StringBuilder();

        try(BufferedReader br = new BufferedReader(new FileReader(filePath)))
        {
            String line;
            while((line=br.readLine())!=null)
            {
                sb.append(line);
                sb.append("\n");
            }

            if(sb.length()>0)
            {
                sb.setLength(sb.length()-1);
            }


            String encodedText = Base64.getEncoder().encodeToString(sb.toString().getBytes());

            return encodedText;
        }

        catch(IOException e)
        {
            e.printStackTrace();
            return "Something went wrong while reading the file";
        }

    }


    public static void main(String[] args)
    {

        Scanner input = new Scanner(System.in);
        Main obj = new Main();
        System.out.println("Welcome to file encoder!!");
        String output = obj.encodeFile("D:\\JAVA2025\\something\\src\\rivisitingInnnerClasses\\data.txt");
        System.out.println("Encoded String : "+output);
        input.close();
    }
}
