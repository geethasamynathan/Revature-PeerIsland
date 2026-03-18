public class MainClass {
    public static void main(String[] args)
    {
        //Employee.printEmployeeInfo();
       // Employee employee=new Employee();
      //  employee.getEmlpoyeeInfo();
        Employee emp1=new Employee();
        emp1.printEmployeeInfo();

        Employee emp2=new Employee(1001,"Geeta");
        emp2.printEmployeeInfo();

        Employee emp3=new Employee(104,"mani","Sr.Manager");
        emp3.printEmployeeInfo();

        Employee emp4=new Employee(emp3);
        emp4.printEmployeeInfo();


//        Employee employee1=new Employee(102,"Kavita","Consultant");
//        employee1.printEmployeeInfo();
//
//        Employee employee2=new Employee(employee1);
//        employee2.printEmployeeInfo();
//
//        employee1.printEmployeeInfo();
    }

}
