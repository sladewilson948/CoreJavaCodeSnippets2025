package something;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Base64;

public class encoderFinalBoss {


    public String encodeDataFromFile(String filePath)
    {
        StringBuilder sb = new StringBuilder();

        try(BufferedReader br = new BufferedReader(new FileReader(filePath)))
        {
            String line;
            while((line = br.readLine())!=null)
            {
                sb.append(line).append("\n");
            }
            if(sb.length()>0)
            {
                sb.setLength(sb.length()-1);
            }

        }

        catch (IOException e)
        {
            e.printStackTrace();
            System.out.println("Error while reading the file");
        }

        String encodedString = Base64.getEncoder().encodeToString(sb.toString().getBytes());
        System.out.println("Encoding complete!!");
        return encodedString;
    }


    public String decodeString(String encodedString)
    {
        byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
        String decodedString = new String(decodedBytes);
        return decodedString;
    }


    public static void main(String[] args)
    {
        encoderFinalBoss obj = new encoderFinalBoss();
        System.out.println("This is a file encoder!!");
        System.out.println("Reading file");
        String res = obj.encodeDataFromFile("D:\\JAVA2025\\something\\src\\something\\sample.txt");
        System.out.println("Encoded output : "+ res);
        System.out.println("Decoded string : \n"+ obj.decodeString(res));

    }


}
