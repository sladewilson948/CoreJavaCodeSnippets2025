package practicemakesperfect;
import java.util.Scanner;


record EmployeeRecord(String name, String city, int age, int salary)
{


    public EmployeeRecord
    {
        if(age<0) {throw new IllegalArgumentException("Age cannot be negative good sire!!!");}
        if(salary<1000) {
            lowSalaryPrompt();
            //
        } else if (salary>10000) {
            highSalaryPrompt();
        }

    }

    public void thisIsARandomMethod(){
        System.out.println("Broski you just called this method for nothin");
    }

    public void lowSalaryPrompt() {
        System.out.println("The salary has gone below 1000INR");
    }
    public void highSalaryPrompt()
    {
        System.out.println("The salary has gone above 10000INR");
    }

    @Override
    public String toString() {
        return "Hi my name is "+name+ " and I am from "+city+" and I am "+age+ " years old.";
    }
}

public class JavaRecords {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Let us now make some employee records");
        System.out.println("Enter employee name : ");
        String name = input.nextLine();
        System.out.println("Enter employee city : ");
        String city = input.nextLine();
        System.out.println("Enter employee age : ");
        int age = Integer.parseInt(input.nextLine());
        System.out.println("Enter employee salary : ");
        int salary = Integer.parseInt(input.nextLine());

        EmployeeRecord record = new EmployeeRecord(name,city,age,salary);
        System.out.println(record.name());
        System.out.println(record.age());
        System.out.println(record.salary());
        System.out.println(record.city());
        System.out.println(" ");
        System.out.println(record);
        System.out.println(" ");
        record.thisIsARandomMethod();
        input.close();
    }
}