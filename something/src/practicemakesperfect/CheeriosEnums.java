package practicemakesperfect;

enum MyCereals
{
    CHOCOS(20,100),
    HONEY_COMBS(40,200),
    MUFFINS(56,200),
    DAISY(60,500);

    final int levelOfTaste;
    final int price;

    MyCereals(int levelOfTaste, int price)
    {
        this.levelOfTaste = levelOfTaste;
        this.price = price;
    }
}

public class CheeriosEnums {


    public static void main(String[] args)
    {
        System.out.println("Lets get some cereals");
        MyCereals cereal = MyCereals.CHOCOS;
        if(cereal==MyCereals.CHOCOS)
        {
            System.out.println(cereal.levelOfTaste);
            System.out.println("The price of this cereal is "+cereal.price);
        }

    }
}
