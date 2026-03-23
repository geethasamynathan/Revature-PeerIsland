
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeLanmbdaDemo {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(101, "Ravi", "IT", 60000, 28));
        employees.add(new Employee(102, "Priya", "HR", 45000, 32));
        employees.add(new Employee(103, "Arun", "Finance", 70000, 35));
        employees.add(new Employee(104, "Divya", "IT", 55000, 26));
        employees.add(new Employee(105, "Karthik", "Admin", 40000, 30));
        employees.add(new Employee(106, "Meena", "IT", 80000, 38));

        //employees.forEach(emp -> System.out.println(emp));
        employees.forEach(System.out::println);

        //Display only IT department employees

//        employees.stream()
//                .filter(emp -> emp.getDepartment().equals("IT"))
//                .forEach(System.out::println);


//        //Find emplpoyees who got salary greater than 50k
//        employees.stream()
//                .filter(emp -> emp.getSalary() > 50000)
//                .forEach(System.out::println);


        // Lambda with multiple conditions we can use &&

//        //find the  IT department employee who got salary > 45k
//        employees.stream()
//                .filter((emp -> emp.getDepartment().equals("IT") && emp.getSalary() > 55000))
//                .forEach(System.out::println);

//        employees.sort((e1,e2)-> e1.getName().compareTo(e2.getName()));
//        employees.forEach(System.out::println);
//
//
//        System.out.println("\n Employeess sorted by Salary");
//        employees.sort((e1,e2)->Double.compare( e1.getSalary(),e2.getSalary()));
//        employees.forEach(System.out::println);
//
//        System.out.println("\n Employeess sorted by Salary by descending");
//        employees.sort((e1,e2)->Double.compare( e2.getSalary(),e1.getSalary()));
//        employees.forEach(System.out::println);
//
//        System.out.println("\n Employeess sorted by Age");
//        employees.sort((e1,e2)->Integer.compare( e1.getAge(),e2.getAge()));
//        employees.forEach(System.out::println);

//         System.out.println("\n sorted by Departmentname and then name ");
//        employees.sort((e1,e2) ->{
//            int deptCompare=e1.getDepartment().compareTo((e2.getDepartment()));
//            if(deptCompare==0)
//            {
//                return e2.getName().compareTo(e1.getName());
//            }
//            return  deptCompare;
//        });
//        employees.forEach(System.out::println);

//
//        System.out.println(" Example for map");
//        //map() -> transforms data
//        employees.stream()
//                .map(emp -> emp.getName().toUpperCase())
//                .forEach(System.out::println);
//
//
//  System.out.println(" Example for map with formatted output ");
//    //map() -> transforms data
//        employees.stream()
//                .map(emp -> emp.getName()+ " - " + emp.getDepartment() + " - " + emp.getSalary())
//            .forEach(System.out::println);


        // collect()
        List<Employee> itEmployees =employees.stream()
                .filter(emp -> emp.getDepartment().equals("IT"))
                .collect(Collectors.toList());
System.out.println("\n IT Emplyee Details ");
        itEmployees.forEach(System.out::println);


        //count
        System.out.println(" IT Employee Count");
        long count=employees.stream()
                .filter(emp -> emp.getDepartment().equals("IT"))
                .count();
        System.out.println(" Total Employees Count "+count);

        long highSalaryCount=employees.stream()
                .filter(emp -> emp.getSalary()> 60000)
                .count();
        System.out.println(" Total High salary Employees  "+highSalaryCount);

        //findFrist

        System.out.println(" Find First Employee in IT Deparment");
        employees.stream()
                .filter(emp -> emp.getDepartment().equals("IT"))
                .findFirst()
                .ifPresent(System.out::println);
}
}
