package CardArts;

class Pallets
{

    private Colorpallet c;

    public Pallets(int a,int b,int c)
    {
        this.c = new Colorpallet(a,b,c);
    }

    

    @Override
    public String toString()
    {
        return c.toString();
    }
}

class Colorpallet
{

    private int red;
    private int green;
    private int blue;

    public Colorpallet(int red,int green,int blue)
    {

        this.red = red;
        this.green = green;
        this.blue = blue;

    }

    public void setColor(int red, int green, int blue)
    {
        this.red = red;
        this.blue = blue;
        this.green = green;
    }

    @Override
    public String toString()
    {
        return "RGB("+red+","+green+","+blue+")";
    }

}

public class Main {

    public static void main(String[] args)
    {
        Pallets p1 = new Pallets(12,45,23);
        System.out.println(p1);
    }
}
