package learnbeforeearn;

import java.util.*;

public class WorstSort {


    public static void main(String[] args)
    {
        List<String> myList = new ArrayList<>(Arrays.asList("My","name","is","aman","dubey"));
        for (String val: myList)
        {
            System.out.println(val);
        }
        List<Integer> nums = new ArrayList<>();
        Random rand = new Random();
        for(int i=0;i<5;i++)
        {
            nums.add(rand.nextInt(10000));
        }

        // now we will put the sorting algorithm here
        while(!isSorted(nums))
        {
            Collections.shuffle(nums);
        }

        nums.forEach(x-> System.out.print(x + ", "));
    }


    /// method to check if a list of numbers is sorted or not

    public static boolean isSorted(List<Integer> lists)
    {



        if(lists==null)
        {
            return true;
        }
        else if(lists.size()==1)
        {
            return true;
        }
        else
        {
            for(int i=0;i<lists.size()-1;i++)
            {
                int val1 = lists.get(i);
                int val2 = lists.get(i+1);
                if (val2-val1<0)
                {
                    return false;
                }

            }
            return true;

        }
    }
}
