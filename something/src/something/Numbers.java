package something;



public class Numbers {

    public static void main(String args[])
    {
        int[] nums  ={1,2,3,4,5,6,7,8,9,10};
        for(int num:nums)
        {
            if(num%2==0)
            {
                System.out.print(num + " ");
            }
        }
    }
}
