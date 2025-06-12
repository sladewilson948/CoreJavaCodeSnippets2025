package practicemakesperfect;

import java.util.Scanner;

enum AllCodes
{
    ALPHA(1000,200),
    ROMERO(200,1200),
    CHARLIE(400,1000),
    DELTA(600,1000);

    final int range;
    final int price;

    AllCodes(int range,int price)
    {
        this.range = range;
        this.price = price;
    }

    public void thisIsNormalBehavious()
    {
        System.out.println("Hi my name is an ENUM");
    }
}

public class AllOfIt {

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        // let us try to access some Enums
        AllCodes alpha = AllCodes.ALPHA;
        AllCodes romero = AllCodes.ROMERO;
        AllCodes charlie = AllCodes.CHARLIE;
        AllCodes delta = AllCodes.DELTA;

        alpha.thisIsNormalBehavious();

        getInfoAboutConstant(alpha);
        getInfoAboutConstant(romero);
        getInfoAboutConstant(charlie);
        getInfoAboutConstant(delta);
        input.close();
    }


    public static void getInfoAboutConstant(AllCodes codes)
    {

        System.out.println("Hi this is " + codes + " and I have a range of " + codes.range + " I have a price tag of " + codes.price);
    }
}
