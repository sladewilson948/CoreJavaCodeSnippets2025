package learnbeforeearn;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Scramble {


    public static void generateAllWords(String textVal)
    {
        char[] arr1 = textVal.toCharArray();
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<arr1.length;i++)
        {
            sb.append(arr1[i]);
            for(int j=0;j<arr1.length;j++)
            {
                res.add(sb.toString());
                if(j!=i)
                {
                    sb.append(arr1[j]);
                }


            }
            sb.setLength(0);
        }

        for(String text: res)
        {
            System.out.println(text);
        }
    }


    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Java program to make all possible words from the given set of chars : ");
        System.out.println("Enter all the chars you want without space : ");
        String textVal = input.nextLine();
        generateAllWords(textVal);
    }
}
