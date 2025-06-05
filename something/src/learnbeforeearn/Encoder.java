package learnbeforeearn;
import java.util.Scanner;
import java.util.Base64;

public class Encoder {


    public static String encodeText(String textVal)
    {

        String encodedText = Base64.getEncoder().encodeToString(textVal.getBytes());
        return encodedText;
    }

    public static String decodedText(String textVal)
    {
        String decodedText = new String(Base64.getDecoder().decode(textVal));

        return decodedText;
    }


    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Let us make an encoder and decoder in java");
        System.out.println("Please enter the text : ");
        String textVal = input.nextLine();
        System.out.println("To encode your text press 1");
        System.out.println("To decode your test press 2");
        System.out.println("Please enter option here : ");
        int option = Integer.parseInt(input.nextLine());
        if(option==1)
        {
            System.out.println("Encoded text : " + encodeText(textVal));
        }
        else if(option==2)
        {
            System.out.println("Decoded text is : "+ decodedText(textVal));
        }
        else
        {
            System.out.println("Please enter a valid option!!!!");
        }

    }
}
