package lottery;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.util.List;


public class Loter {

    public static List<Integer> getSixRandomNumber()
    {
        Random rand = new Random();
        List<Integer> loterryNums = new ArrayList<>();
        for(int i=0;i<6;i++)
        {
            loterryNums.add(rand.nextInt(46));
        }

        return loterryNums;
    }

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        Boolean flag = false;
        List<Integer> lotteryNums = getSixRandomNumber();
        List<Integer> userNums = new ArrayList<>();
        System.out.println("Welcome to my java program");
        System.out.println("You will get six chances to pick a number from 1 to 46 and you need to get one right number to win");
        for(int i=0;i<6;i++)
        {
            System.out.println("Enter a number between 1 to 46");
            int num = Integer.parseInt(input.nextLine());
            userNums.add(num);
            System.out.println("Your chosen numbers are "+ userNums);
            if (lotteryNums.contains(num))
            {
                flag = true;
                break;
            }

        }
        if(!flag)
        {
            System.out.println("Sorry you did not win");
        }
        else
        {
            System.out.println("You wone");
        }
        System.out.println("Winning numbers were : "+lotteryNums);


        input.close();

    }
}
