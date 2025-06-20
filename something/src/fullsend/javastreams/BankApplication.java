package fullsend.javastreams;
import java.util.Scanner;


// reate a Java class called BankAccount with methods to deposit, withdraw,
// and check balance. Ensure that the balance cannot go negative.

class Bank
{

    private long bankBalance;

    public Bank(long bankBalance)
    {
        this.bankBalance = bankBalance;
    }

    public long getBalance()
    {
        return this.bankBalance;
    }


    public void withdrawAmount(long amount)
    {
        if(this.getBalance()<=amount)
        {
            System.out.println("CANNOT PROCEED WITH THE OPERATION, INSUFFICIENT FUND");
        }
        else{
            long newBalance = this.getBalance() - amount;
            setBankBalance(newBalance);
        }
    }

    public void depositAmount(long amount)
    {
        setBankBalance(getBalance() + amount);
    }


    // method to set the balance
    public void setBankBalance(long balance)
    {
        if(balance<=0)
        {
            System.out.println("Balance cannot be zero");
        }
        else{
            this.bankBalance = balance;
            System.out.println("Change Accepted");
        }
    }


}


public class BankApplication {

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        Bank bank = new Bank(100000);
        System.out.println("Enter the amount you want to deposit : ");
        long amount = Long.parseLong(input.nextLine());
        bank.depositAmount(amount);
        System.out.println("Display new balance : " + bank.getBalance());
        input.close();
    }


}
