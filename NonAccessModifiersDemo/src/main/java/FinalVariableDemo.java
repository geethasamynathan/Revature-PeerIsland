class BankRules{
    final double MINIMUM_BALANACE=1000.00;

    void showRule(){
        System.out.println(" Minimum Balance  : "+MINIMUM_BALANACE);

    }
}

public class FinalVariableDemo {

    public static void main(String[] args){
        BankRules rule=new BankRules();
       // rule.MINIMUM_BALANACE=9000.00; //error
        rule.showRule();
    }

}
