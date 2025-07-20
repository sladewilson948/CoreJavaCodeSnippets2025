package repetition.frelto;

import java.util.*;

public class ExtractPhoneNumber {


    public static void listsView()
    {
        int[] arr1 = {1,2,3,4};
        int[] arr2 = new int[5];

        for(int i=0;i<arr1.length;i++){
            arr2[i] = arr1[i];
        }
        System.out.println(arr2[4]);
    }

    public static String extractNumberFromText(String textValue)
    {
        Set<String> answers = new HashSet<>();
        Set<Character> chars = new HashSet<>(
                Arrays.asList(
                        '0','1','2','3','4','5',
                        '6','7','8','9'
                )
        );

        String temp = "";
        for(char ch: textValue.toCharArray())
        {
            if(chars.contains(ch))
            {
                temp+=ch;
            }
            else{
                if(!temp.equals(""))
                {
                    answers.add(temp);
                    temp="";
                }
            }
        }

        if(!temp.equals(""))
        {
            answers.add(temp);
        }

        for(String answer: answers)
        {
            if(answer.length()==10 && answer.charAt(0)!='0')
            {
                return answer;
            }
        }
        return "-1";


    }

    public static void main(String[] args)
    {

        System.out.println("Enter a very long text here to extract phonenumber");
        Scanner input = new Scanner(System.in);
        String textValue = input.nextLine();
        String answer = extractNumberFromText(textValue);
        System.out.println("Required phone number : "+answer);
        listsView();
    }
}
