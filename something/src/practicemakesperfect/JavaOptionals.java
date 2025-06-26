package practicemakesperfect;
import java.util.Optional;
import java.util.Scanner;

class Employee
{

    private final int id;
    private final String name;
    private final String city;
    private final String country;


    public Employee(int id, String name, String city, String country){
        this.id = id;
        this.name = name;
        this.city = city;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        return "Hi my name is "+name+ " and I am from "+city+", "+country+" it was nice meeting you! "+id;
    }

}

public class JavaOptionals {

    public static void main(String[] args)
    {

        System.out.println("Welcome to Optionals!!");
        System.out.println("Let us create an employee");
        Optional<Employee> optionalEmployee = createEmployeeAndReturn();
        if(optionalEmployee.isPresent()){System.out.println(optionalEmployee.get().getName());}
        else{System.out.println(0);}


        Optional<Employee> emp1 = createEmployeeAndReturn();
        Employee empone = emp1.orElse(new Employee(0,"UNKNOWN","UNKNOWN","UNKNOWN"));
        System.out.println(empone);
        System.out.println(empone.getName());


    }


    public static Optional<Employee> createEmployeeAndReturn()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Please provide us with the below details");
        System.out.println("Enter name : ");
        String name = input.nextLine();
        System.out.println("Enter id : ");
        int id = Integer.parseInt(input.nextLine());
        System.out.println("Enter city : ");
        String city = input.nextLine();
        System.out.println("Enter country : ");
        String country = input.nextLine();
        System.out.println("Creating Object");
        Employee myemp = new Employee(id,name,city,country);


        return Optional.of(myemp);
    }
}
