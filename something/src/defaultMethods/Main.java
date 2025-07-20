package defaultMethods;


interface Vehicle
{
    void start();
    //void honk();

    ///  time to introduce default method
    default void honk()
    {
        System.out.println("Honk Honk!!");
    }
}

class Car implements Vehicle
{
    @Override
    public void start()
    {
        System.out.println("Car started!!");
    }
}

class Bike implements Vehicle
{

    @Override
    public void start()
    {
        System.out.println("Bike started!!");
    }
}

class Scooter implements Vehicle
{

    @Override
    public void start()
    {
        System.out.println("Scooter started");
    }
}

public class Main {

    public static void main(String[] args)
    {
        Car car = new Car();
        Bike bike = new Bike();
        Scooter scooter = new Scooter();
        car.start();
        car.honk();
        bike.start();
        bike.honk();
        scooter.start();
        scooter.honk();
    }
}
