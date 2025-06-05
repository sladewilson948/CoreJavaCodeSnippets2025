package something;
import java.util.Scanner;
import java.util.Base64;

public class aboutYou
{


    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the string you want to encode : ");
        String txtVal = input.nextLine();
        String encodedVal = Base64.getEncoder().encodeToString(txtVal.getBytes());
        System.out.println("Encoded string is : "+encodedVal);
        input.close();
    }
}