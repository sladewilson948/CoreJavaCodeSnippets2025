package repetition.frelto;

import java.util.Scanner;


public class NewJava
{

    public static void main(String[] args)
    {

        Scanner input = new Scanner(System.in);
        System.out.println("Hello there please enter your name : ");
        String name = input.nextLine();
        System.out.println("Please enter your age : ");
        int age = Integer.parseInt(input.nextLine());
        System.out.println(STR."Hello there : \{name} and I am \{age} years old!!");
        input.close();
    }
}