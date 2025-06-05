package something;
import java.util.ArrayList;
import java.util.Scanner;


/// holding and showcasing the items
class Inventory
{
    // here we are defining an array that has got to store objects in it of Item class
    private ArrayList<Item> items;

    public Inventory(){
        items = new ArrayList<>();
    }

    public void AddItems(Item item)
    {
        items.add(item);
    }

    public void AddItems(String type, int damage, String name, int quantity)
    {
        items.add(new Weapons(type,damage,name,quantity));
    }

    public void AddItems(String type, String name, int quantity)
    {
        items.add(new MyFruits(type,name,quantity));
    }

    /// let's do Compile Time polymorphism in java
    // the thing is that Method Overloading is a type of Compile time polymorphism


    public void DisplayItems()
    {
        for(Item item: items)
        {
            System.out.println(item);
        }
    }

}


class Item
{
    private String name;
    private int quantity;

    public Item(String name, int quantity)
    {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName()
    {
        return this.name;
    }

    public int getQuantity()
    {
        return this.quantity;
    }

    @Override
    public String toString()
    {
        return "Item name : '" + getName() + "' Item quantity : '" + getQuantity() + "'";
    }


}


class Weapons extends Item
{
    private String type;
    private int damage;

    public Weapons(String type, int damage, String name, int quantity)
    {
        super(name,quantity);
        this.type = type;
        this.damage = damage;
    }

    @Override
    public String toString()
    {
        return "Weapon name : '" + getName() +"' quantity : '" + getQuantity() +"' type : '" + type +"' damage : '" + damage + "'";
    }
}


class MyFruits extends Item
{
    private String type;

    public MyFruits(String type, String name, int quantity){
        super(name,quantity);
        this.type = type;
    }

    @Override
    public String toString()
    {
        return "Fruit type : '" + type + "' " + "Fruit name : '" + getName() + "' Fruit quantity : '"+ getQuantity() + "'";
    }
}


public class EncoderDecoder {


    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        // let us first create the inventory object
        Inventory inventory = new Inventory();
        Item item = new Item("Generic Item", 100);
//        MyFruits fruit = new MyFruits("Fuji", "Apple", 20);
//        Weapons weapon = new Weapons("Melee", 80, "Legend Sword", 100);

        // adding items to the inventory
        inventory.AddItems(item);
        inventory.AddItems("Fuji", "Apple", 20);
        inventory.AddItems("Melee", 80, "Legend Sword", 100);
        inventory.DisplayItems();
        input.close();
    }
}
