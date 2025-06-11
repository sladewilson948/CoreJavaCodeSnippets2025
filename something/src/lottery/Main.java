package lottery;
import java.util.Scanner;


class OuterClass
{
    static int num1 = 10;

    public void greetMe()
    {
        System.out.println("Hi my name is Aman Dubey. I am sending this message from the outer class.");
    }

    static class InnerClass
    {
        public void greetFromInnerClass()
        {
            System.out.println("Hi there! greetings from the inner classs "+num1);
        }
    }
}

public class Main {


    public static void main(String[] args)
    {

        Scanner input = new Scanner(System.in);
        System.out.println("Lets see how inner classes work!!");
        OuterClass outer = new OuterClass();
        outer.greetMe();
        /// this is how we create the inner class object using the outer class
        OuterClass.InnerClass inner = new OuterClass.InnerClass();
        inner.greetFromInnerClass();
        input.close();
    }
}
