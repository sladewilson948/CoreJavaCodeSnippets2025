package repetition.qjvmdx;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;
import java.util.List;
import java.util.UUID;


class OuterClass
{

    public class ManageUsers
    {

        private List<FirstInnerClass> usersList;

        public ManageUsers()
        {
            this.usersList = new ArrayList<>();
        }

        public void addAllUsersToList(List<FirstInnerClass> providedUsers)
        {
            for(FirstInnerClass users: providedUsers)
            {
                usersList.add(users);
            }
            System.out.println("Added all the users to the list!");
        }

        public void showAllTheUsers()
        {
            Runnable showAllUsers = ()->
            {
                for(FirstInnerClass users: usersList)
                {
                    try
                    {
                        System.out.println(users);
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }

                }
            };

            Thread t1 = new Thread(showAllUsers);
            t1.start();
        }

        public Optional<FirstInnerClass> findUserById(UUID id)
        {
            for(FirstInnerClass users: usersList)
            {
                if(users.getId().equals(id))
                {
                    return Optional.of(users);
                }
            }

            return Optional.empty();
        }
    }

    public class FirstInnerClass
    {

        private UUID id;
        private String name;
        private String city;
        private String country;
        private int age;

        public FirstInnerClass(String name, String city, String country, int age)
        {
            this.id = UUID.randomUUID();
            this.name = name;
            this.city = city;
            this.country = country;
            this.age = age;
        }

        @Override
        public String toString()
        {
            return "User => ("+id+", "+name+", "+city+", "+country+", "+age+")";
        }

        public UUID getId()
        {
            return id;
        }

        public int getAge()
        {
            return age;
        }

    }


    public static class SecondInnerClass
    {


    }

    public void takeMeToThirdInnerClass()
    {

        class ThirdInnerClass
        {


        }
    }
}




public class Main {

    public static void main(String[] args)
    {
        System.out.println("Revisiting everything");
    }
}
