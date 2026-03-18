import java.util.*;

public class Employee {
int employeeId;
String employeeName;
String designation;

static String companyName;
static{
    companyName="PeerIsland";
    System.out.println("Static block excecuted");
}
    //No-Argument Constructor
    public Employee(){
//        employeeName="NA";
//        employeeId=1;
//        designation="NA";
        this(1,"NA","NA");
        System.out.println("No- Argument Constructor called");
    }
    // 2-parametriesd constructor
    public Employee(int id, String name)
    {
        this(id,name,"Not Assigned");
        System.out.println("2 -Argument Constructor called");

    }
//Parameterised constructor
    public Employee(int id,String name,String designation)
    {
        this.employeeId=id;
        this.employeeName=name;
        this.designation=designation;
        System.out.println("Parameterised constructor called");
    }

    //Copy
    public Employee(Employee emp)
    {
        this(emp.employeeId,emp.employeeName,emp.designation);
        System.out.println("Copy Constructor called");
        employeeId=emp.employeeId+1;
        employeeName=emp.employeeName;
        designation=emp.designation;
    }

//    public  void getEmlpoyeeInfo(){
//        Scanner sc=new Scanner(System.in);
//        System.out.println("Enter the EmployeeId, Name,Designation");
//        employeeId=sc.nextInt();
//        employeeName=sc.nextLine();
//        designation=sc.nextLine();
//    }
    public  void printEmployeeInfo(){
        System.out.println("=================================");
        System.out.println("Employee details");
        System.out.println("=================================");
        System.out.println("Employee Id : "+employeeId);
        System.out.println("Employee Name : "+employeeName);
       System.out.println("Designation: "+designation);

    }
}
