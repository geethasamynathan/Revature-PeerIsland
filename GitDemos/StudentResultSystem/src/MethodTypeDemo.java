import java.lang.invoke.MethodType;

public class MethodTypeDemo {
//Global static vartiable . can access without instance
  static   int count=100;
    //method without return without arguments
    public static void GreetMe(){

        //local scope within this method
        int numberOfCustomer=120;
       // MethodTypeDemo methodTypeDemo=new MethodTypeDemo();
       // System.out.println("Count  in GreetMe= "+methodTypeDemo.count);
        System.out.println("Count  in GreetMe= "+count);
        System.out.println("CustomerCount ="+numberOfCustomer);
        System.out.println("I am Greet me function");
    }
    public  static void main(String[] args)
    {
      // System.out.println("CustomerCount ="+numberOfCustomer); //error as numberOfCusotomer is not having global scope

       // MethodTypeDemo methodTypeDemo=new MethodTypeDemo();
        //method invocation
        GreetMe();
        System.out.println("Count  in Main= "+ count);
    }

}
