package something;
import java.util.Scanner;


class Fruits
{

    private String name;
    private int quantity;
    private String taste;


    public Fruits(String name, int quantity, String taste)
    {
        this.name = name;
        this.quantity = quantity;
        this.taste = taste;
    }


    @Override
    public String toString()
    {
        return "Hi I am a fruits my name is '" + name + "', I taste '" + taste + " and you just bought '" + quantity + "' of me 'nice to meet you";
    }


    /// let us make some methods we can use on these fruits

    public String getFruitName()
    {
        return "Hi my name is "+this.name;
    }


}



public class ShoppingSpree {


    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Let us make some fruits\n");
        System.out.print("Enter fruit name : ");
        String fruitName = input.nextLine();
        System.out.print("Enter quantity : ");
        int quantity = input.nextInt();
        input.nextLine();
        System.out.print("Enter fruits taste : ");
        String taste = input.nextLine();
        /// making fruits object
        Fruits fruit = new Fruits(fruitName,quantity,taste);
        System.out.println(fruit.getFruitName());
        System.out.println(fruit);
        input.close();
    }

}
