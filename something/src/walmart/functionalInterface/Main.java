package walmart.functionalInterface;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.Function;
import java.util.Random;

public class Main {

    private static final Random random  = new Random();

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        timeToUseFunctionalInterface(input);
        input.close();
    }


    public static void timeToUseFunctionalInterface(Scanner input)
    {

        // functional interface at your service

        Consumer<String> consume = string-> System.out.println("Hello there nice to meet you, your name is "+string);
        Supplier<Double> randomDoubleNumber = ()-> random.nextDouble(2000);
        Function<Integer,String> thisIsMyFunction = value -> "The value is string is "+ value;
        Predicate<String> checkIfNullorEmpty = textVal -> textVal==null || textVal.equals("");
        System.out.println("Please enter your name : ");
        String name = "Aman Dubey the legend";
        consume.accept(name);
        System.out.println("Here is a random number for you "+ randomDoubleNumber.get());
        System.out.println("Please provide an integer : ");
        int num = random.nextInt(100000);
        String answer = thisIsMyFunction.apply(num);
        System.out.println(answer);
        System.out.println(checkIfNullorEmpty.test("aman dubey"));
        System.out.println(checkIfNullorEmpty.test(null));
        System.out.println(checkIfNullorEmpty.test("aman dubey"));
        System.out.println(checkIfNullorEmpty.test(""));
        System.out.println("Now see how we can make use of functional interface in streams!!!");
        timeToUseItInStreams();

    }

    public static void timeToUseItInStreams()
    {
        List<Integer> lists = Arrays.asList(
                1,2,3,45,23,5,344,56,34,65,23,43
        );

        // defining consumer
        Consumer<Integer> consume = val-> System.out.println(val);
        Supplier<Integer> supply = () -> 0;
        Function<Integer,Integer> doSomething = num-> num*num;
        Predicate<Integer> checkIfEven = val-> val%2==0;

        // now we will perform some operations

        int finalAnswer = lists.stream()
                .map(doSomething)
                .filter(checkIfEven)
                .peek(consume)
                .reduce(supply.get(), (count,num)-> count+1);

        System.out.println("Elements remaining are : "+finalAnswer);
    }
}
