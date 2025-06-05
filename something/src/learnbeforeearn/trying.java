package learnbeforeearn;
import java.util.Scanner;


public class trying
{

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Hi my name is aman dubey and I here to teach you some stuff");
        System.out.println("Enter text one : ");
        String text1 = input.nextLine();
        System.out.println("Enter second text : ");
        String text2 = input.nextLine();
        checkTwoValues(text1,text2);
    }


    public static void checkTwoValues(int num1,int num2)
    {
        if (num1==num2){
            System.out.println("The two numbers are equal");
        }
        else{
            System.out.println("The two numbers are not equal");
        }
    }


    public static void checkTwoValues(String text1, String text2)
    {
        if(text1.equals(text2))
        {
            System.out.println("The two string are equal");
        }
        else{
            System.out.println("The two strings are not equal");
        }
    }
}


