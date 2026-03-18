//public class MainClass {
//    public static void main(String[] args){
//        BankAccount bankAccount=new BankAccount();
//        bankAccount.accountNumber=12345;
//        bankAccount.customerName="Harish";
//        bankAccount.balance=12000;
//        bankAccount.displayAccountInfo();
//        BankAccount bankAccount1=new BankAccount();
//        bankAccount.accountNumber=12345;
//        bankAccount.customerName="Harish";
//        bankAccount.balance=12000;
//        bankAccount1.displayAccountInfo();
//    }
//}

public class MainClass {
    public static void main(String[] args){
        BankAccount bankAccount=new BankAccount(1234,"Sam",15899.45);
        bankAccount.deposit(45000);
        bankAccount.displayAccountInfo();



    }
}

