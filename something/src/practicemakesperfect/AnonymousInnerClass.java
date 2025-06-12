package practicemakesperfect;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
class MyUsers
{
    private String name;
    private int age;
    private String city;
    private String country;

    public MyUsers(String name,int age, String city, String country)
    {
        this.name = name;
        this.age = age;
        this.city = city;
        this.country = country;
    }
}

public class AnonymousInnerClass {

    public static void main(String[] args)
    {
        System.out.println("In this program we will make use of the anonymous inner class in java");
        System.out.println("Lets create an object");
        MyUsers user1 = new MyUsers("Aman Dubey",27,"Bangalore","India");
        MyUsers user2 =  new MyUsers("Archita Dubey",22,"Mumbai","India"){

            /// now what we can do is kind of overwrite the methods defined in thge MyUsers class in here

            @Override
            public String toString()
            {
                return "Hi my name is "+getName() + " and I am "+ getAge() +" years old.";
            }


        };
        System.out.println(user1);
        System.out.println(user2);
    }
}
