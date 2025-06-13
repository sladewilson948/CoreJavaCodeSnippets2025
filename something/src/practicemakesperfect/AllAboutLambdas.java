package practicemakesperfect;
import java.util.Scanner;


interface Printable
{
    String Print(String prefix);
}

class MyCats implements Printable
{

    public MyCats(){}

    public String Print(String prefix)
    {
        return "I am just meowing around" + prefix;
    }

}

public class AllAboutLambdas
{

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        // basically instaed of sending the object with the action we simple send the actual action as you can see here
        Printable lambdaPrintable = (prefix)-> "Hi I am just meowing around" + prefix;
        printThing(lambdaPrintable);
        input.close();
    }


    public static void printThing(Printable thing)
    {
        System.out.println(thing.Print(". Bruh this is a prefix right here."));
    }

}