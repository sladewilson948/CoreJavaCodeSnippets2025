package practicemakesperfect;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
class User
{
    private String name;
    private int age;
    private String city;
    private String country;


}

public class Main {


    public static void main(String[] args)
    {

        System.out.println("Little play with lombok");
        System.out.println("Hi my name is aman dubey");
        User user = new User();
        user.setAge(26);
        user.setCity("Bangalore");
        user.setCountry("India");
        user.setName("Aman Dubey");
        System.out.println(user);
    }
}
