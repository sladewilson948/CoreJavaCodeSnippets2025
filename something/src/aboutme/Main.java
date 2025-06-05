package aboutme;
import java.io.*;
import java.util.Scanner;
import java.util.Base64;




public class Main {

    private static String inputPath = "D:\\JAVA2025\\something\\src\\aboutme\\input.txt";
    private static String outputPath = "D:\\JAVA2025\\something\\src\\aboutme\\output.txt";


    public void decodeString(String outputPath, String inputPath)
    {

        // now it time to decode the string back lets do this
        StringBuilder sb = new StringBuilder();
        try(BufferedReader br = new BufferedReader(new FileReader(outputPath)))
        {
            String line;
            while((line=br.readLine())!=null)
            {
                sb.append(line);
            }
            byte[] arr1 = Base64.getDecoder().decode(sb.toString());
            String output = new String(arr1);

            /// now we need to write this data back to the input file
            try(BufferedWriter bw = new BufferedWriter(new FileWriter(inputPath)))
            {
                bw.write(output);
                System.out.println("Data has been decoded check result at : "+inputPath);
            }
            catch (IOException e)
            {
                e.printStackTrace();
                System.out.println("Somethign went wrong while writing the data");
            }


        }
        catch (IOException e)
        {
            e.printStackTrace();
            System.out.println("An error occured while reading the data from file!!");
        }


    }


    public void encodeString(String inputPath, String outputPath)
    {
        // in this method what we are going to do is take the input from the input path and encode it and put it on the oputput path
        try(BufferedReader br =  new BufferedReader(new FileReader(inputPath)))
        {
            StringBuilder sb = new StringBuilder();
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
            System.out.println(encodedText);
            // now that we have this encodedText we need to write it in the outputFile
            try(BufferedWriter bw = new BufferedWriter(new FileWriter(outputPath)))
            {
                bw.write(encodedText);
                System.out.println("Data has been encoded check result at : "+outputPath);
            }
            catch (IOException e)
            {
                e.printStackTrace();
                System.out.println("Somethign went wrong while writing the data");
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
            System.out.println("Error while reading the line");
        }

        /// now that we have read the input from the user we need encode it to a string lets do that



    }


    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("The program is simple. It will encode and decode text data for you");
        System.out.println("To encode press 1");
        System.out.println("To decode press 2");
        Main obj = new Main();
        int option = input.nextInt();
        input.nextLine();
        if (option==1)
        {
            obj.encodeString(inputPath,outputPath);
        }
        else
        {
            obj.decodeString(outputPath,inputPath);
        }

        input.close();
    }
}
