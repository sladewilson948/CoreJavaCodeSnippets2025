package practicemakesperfect;


class MyCheese
{
    private int levelOfStinkiness;
    public void setLevelOfStinkiness(int level)
    {
        this.levelOfStinkiness = level;
    }
    public int getLevelOfStinkiness()
    {
        return this.levelOfStinkiness;
    }
}

public class Pass {

    public static void main(String[] args)
    {
        System.out.println("Here we will see how java is always passed by value");
        MyCheese cheese = new MyCheese();
        cheese.setLevelOfStinkiness(100);
        System.out.println(cheese.getLevelOfStinkiness());
        inceaseLevelOfStinckiness(cheese);
        System.out.println(cheese.getLevelOfStinkiness());
    }

    private static void inceaseLevelOfStinckiness(MyCheese cheese)
    {
        cheese.setLevelOfStinkiness(cheese.getLevelOfStinkiness() + 500);
    }
}
