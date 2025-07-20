package functionalinterface;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {


    public static void main(String[] args)
    {

        final Random random = new Random();
        // consumer takes in a single argument and returns no result

        Consumer<String> printer = message -> System.out.println(message);
        printer.accept("My name is aman dubey");

        // Supplier does not take an input rather it provides a number
        Supplier<Double> randomNumberSuplier = ()-> random.nextDouble(1999);
        System.out.println("Here is a random number "+randomNumberSuplier.get());

        // function interface

        Function<Integer,String> intToStringConverter = integer-> "Number "+integer;
        String result = intToStringConverter.apply(34);
        System.out.println("Result "+result);

        // predicate as the name suggest is used to get a boolean value for checking some condition
        Predicate<String> isNullOrEmpty = str -> str==null || str.isEmpty();

        System.out.println("Is null or empty "+ isNullOrEmpty.test(""));
        System.out.println("Is null or empty "+ isNullOrEmpty.test(null));
        System.out.println("Is null or empty "+ isNullOrEmpty.test("Aman Dubey"));
        System.out.println("Is null or empty "+ isNullOrEmpty.test("Walmart"));

    }
}
