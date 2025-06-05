package something;
import java.util.*;


public class thisIsMe {


    public static void main(String[] args)
    {

        List<String> arr1 = new ArrayList<>(Arrays.asList("Aman","Dubey","is","a","fucking","legend"));
        System.out.println(arr1);
        Collections.reverse(arr1);
        System.out.println(arr1);

        for(String item: arr1)
        {
            System.out.println(item + " " + item.length());
        }
    }
}
