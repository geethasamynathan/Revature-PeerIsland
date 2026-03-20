import java.util.*;

public class ArithmeticExample {
    public static void main(String[] args) {

        try {
            String companyName=null;
           // int count=companyName.length();
            int totalSalary, no_of_employees;
            System.out.println("Enter the Salary");
            Scanner sc = new Scanner((System.in));
            totalSalary=sc.nextInt();
          // String salary="sample";
          //  totalSalary = Integer.parseInt(salary);
            System.out.println("Enter the no of Employees");
            no_of_employees = sc.nextInt();

            double avgSalary = totalSalary / no_of_employees;
            System.out.println("Average Salary : " + avgSalary);


        }
        catch(NumberFormatException e)
        {
            System.out.println(" Please enter number only");
        }
        catch (ArithmeticException ae) {
            System.out.println(" cannot divide by Zero");
        }
        catch(NullPointerException ne)
        {
            System.out.println(" Null Pointer exception occured");
        }
        catch (Exception e) {
            System.out.println("Error Occured : " + e.getMessage());

        }
        finally{
            System.out.println("End of the program");
        }
    }
}
