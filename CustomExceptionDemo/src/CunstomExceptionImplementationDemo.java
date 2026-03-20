import java.util.Scanner;

public class CunstomExceptionImplementationDemo {
    public static  void main(String[] args)
    {
        BankAccount bankAccount=new BankAccount(10000);
        try {
            double amountToWithdraw;
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the amount to withdraw");
            amountToWithdraw = sc.nextDouble();
            bankAccount.withdraw(amountToWithdraw);
        }
        catch(InSufficientBalanceException e)
        {
            System.out.println(" Custom Exception : "+e.getMessage());
        }
        catch(Exception e )
        {
            System.out.println(" Error Occured "+e.getMessage());
        }

    }

}
