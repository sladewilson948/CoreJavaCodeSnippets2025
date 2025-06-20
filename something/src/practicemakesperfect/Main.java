package practicemakesperfect;

import java.util.Scanner;
import java.util.Random;

class MyCar
{

    private int id;
    private String brand;
    private int year;
    private int cc;
    Random random = new Random();


    public MyCar(int id, String brand, int year, int cc)
    {
        this.id = random.nextInt();
        this.brand = brand;
        this.year = year;
        this.cc = cc;

    }
}

public class Main
{

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Lets see what we can do here!!");
        input.close();
    }

}