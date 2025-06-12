package practicemakesperfect;


class Animal
{
    public String makeNoise()
    {
        return "I am just an Animal";
    }
}

class Dog extends Animal
{
    @Override
    public String makeNoise()
    {
        return "Woof Woof";
    }

    public void specificMethod()
    {
        System.out.println("I am just barking around");
    }
}

class Cat extends Animal
{
    @Override
    public String makeNoise()
    {
        return "Meow meow";
    }

    public void specificMethod()
    {
        System.out.println("I am just meowing around");
    }
}

class Horse extends Animal
{
    @Override
    public String makeNoise()
    {
        return "Neigh Neigh";
    }

    public void specificMethod()
    {
        System.out.println("I am just horsing around!!");
    }
}

public class Casting {

    public static void main(String[] args)
    {
        System.out.println("In this example we will see how we can make use of upcasting and downcasting");
        // this right here is an example of Upcasting we could have also done something like
        /// upcasting mean the object gets casted to the parent class here Horse object is getting casted to Animla class
        Animal animal1 = new Horse();
        System.out.println(doAnimalStuff(animal1));
        Animal animal2 = new Cat();
        System.out.println(doAnimalStuff(animal2));
        Animal animal3 = new Dog();
        System.out.println(doAnimalStuff(animal3));
    }

    // this here indicates that we are taking in an Animal class or any of itts subclasses
    public static String doAnimalStuff(Animal animal)
    {
        // now what we can do is
        // this right here is called as Downcastingf meanbging the animal call was downcsted to its sublass or to the classes that extend it
        if(animal instanceof Horse)
        {
            ((Horse) animal).specificMethod();
        }
        if(animal instanceof Dog)
        {
            ((Dog) animal).specificMethod();
        }
        if(animal instanceof Cat)
        {
            ((Cat) animal).specificMethod();
        }

        return animal.makeNoise();
    }
}
