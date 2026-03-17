public class Calculator {
   //method without Return without arguments
    public void addition()
    {
        int num1,num2,sum;
        num1=500;
        num2=340;
        sum=num1+num2;
        System.out.println(num1+" + "+num2 +"= "+sum);
      int subtractionResult=  subtraction(num1,num2);
      System.out.println("Subtraction Of "+ num2+" - "+num1 + "= "+subtractionResult);
    }

    //Method with return with Arguments
    private int subtraction (int num1, int num2)
    {
        int difference=num2-num1;
        return difference;
        //System.out.println(" Difference of "+num2 +" - "+ num1 " = "+difference);
    }

    //method with Return without arguments
    private int product(){
        int num1, num2,product;
        num1=10;
        num2=7;
        product=num1*num2;
        return product;
    }

    public void findtheQuotient(int num1, int num2)
    {
        int result=0;
        if(num2!=0)
        {
           result=num1/num2;
        }
       System.out.println(num1 +" / "+num2 + "="+ result);
    }
public static String GreetMe(String name)
{
    return "Hello"+name + " Welcome ";
}

}
