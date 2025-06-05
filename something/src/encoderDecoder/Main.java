package encoderDecoder;

import java.io.*;
import java.util.Scanner;
import java.util.Base64;



public class Main {


    private static String inputPath = "D:\\JAVA2025\\something\\src\\encoderDecoder\\input.txt";
    private static String outputPath = "D:\\JAVA2025\\something\\src\\encoderDecoder\\output.txt";

    /// logic to handle the encoding part by reading it from the encode.txt file


    public void encodeDataFromUser()
    {
        StringBuilder sb = new StringBuilder();
        try(BufferedReader br = new BufferedReader(new FileReader(this.inputPath)))
        {
            String line;
            while((line=br.readLine())!=null)
            {
                sb.append(line).append("\n");
            }
            if(sb.length()>0)
            {
                sb.setLength(sb.length()-1);
            }

            /// now we need to generate the encoded string

            String encodedString = Base64.getEncoder().encodeToString(sb.toString().getBytes());

            // adding this part to file
            try(BufferedWriter bw = new BufferedWriter(new FileWriter(this.outputPath)))
            {
                bw.write(encodedString);
                System.out.println("File encoded and data sent to : " + this.outputPath);
            }
            catch (IOException e)
            {
                e.printStackTrace();
                System.out.println("Something went wrong while writing the file");
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
            System.out.println("Something went wrong while reading the file!!");
        }
    }


    /// logic to handle the decoding part of the code

    public void decodeDataFromUser()
    {
        StringBuilder sb = new StringBuilder();
        /// first we need to read the data from the encoded text file
        try(BufferedReader br = new BufferedReader(new FileReader(this.inputPath)))
        {
            String line;
            while((line = br.readLine())!=null)
            {
                sb.append(line);
            }

            byte[] byteArr = Base64.getDecoder().decode(sb.toString());
            String decodedString =new String(byteArr);

            try(BufferedWriter bw = new BufferedWriter(new FileWriter(this.outputPath)))
            {
                bw.write(decodedString);
                System.out.println("File decoded and data sent to : " + outputPath);
            }
            catch (IOException e)
            {
                e.printStackTrace();
                System.out.println("Error while writing file!");
            }
        }

        catch (IOException e)
        {
            e.printStackTrace();
            System.out.println("Error while reading the file!!!");
        }

    }


    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        Main obj = new Main();
        System.out.println("Welcome to my encoder and decoder app.");
        System.out.println("If you want to encode your data add it in input.txt file");
        System.out.println("If you want to decode your data add it in output.txt file");


        while (true)
        {
            System.out.println("If you want to encode press 1 for decode press 2 to exit press 3");
            int option = input.nextInt();
            if(option==1)
            {
                obj.encodeDataFromUser();
            }
            else if(option==2)
            {
                obj.decodeDataFromUser();
            }
            else if(option==3)
            {
                System.out.println("Thank you for using this application!");
                break;
            }


        }


    }
}

