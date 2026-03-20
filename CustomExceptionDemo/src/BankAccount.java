public class BankAccount {
private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public void withdraw(double amount) throws  InSufficientBalanceException
    {
        if(amount>balance){
            throw new InSufficientBalanceException("Withdrawl failed : Insufficient balance");
        }
        balance-=amount;
        System.out.println(" Withdrawl successful. Remaiing Balanace : "+balance);
    }

}
