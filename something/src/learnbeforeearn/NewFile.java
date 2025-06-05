package learnbeforeearn;
import java.util.Scanner;


public class NewFile {


    public static void main(String[] args)
    {
        // for keyboard input from user
        Scanner input = new Scanner(System.in);
        String name;
        int age;
        float shoeSize;

        System.out.println("Please enter your name: ");
        name = input.nextLine();
        System.out.println("Please enter your age : ");
        age = input.nextInt();
        System.out.println("Please enter your shoe size : ");
        shoeSize = input.nextFloat();


        System.out.println("Your name : "+name);
        System.out.println("Your age is : "+age);
        System.out.println("Your shoe size is : "+shoeSize);
        input.close();
    }
}
