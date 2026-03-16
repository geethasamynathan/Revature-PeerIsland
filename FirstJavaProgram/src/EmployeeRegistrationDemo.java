public class EmployeeRegistrationDemo {
    public static void main(String[] args)
    {
        byte age=39;
        short experienceOfMonths=18;
        int employeeId=1001;
        long mobileNumber=9876543210L;

        float  woringHoursPerDay=8.5f;
        double mothlySalary=678565.50;

        char gender='F';

        boolean isActiveEmployee=true;

        String employeeName="Fransy";

        char performanceGrade='A';

        System.out.println("===================================");
        System.out.println("Employee Information");
        System.out.println("===================================");
        System.out.println("Employee Id   :"+employeeId);
        System.out.println("Employee Name   :"+employeeName);
        System.out.println("Age   :"+age);
        System.out.println("Gender   :"+gender);
        System.out.println("mobileNumber  :"+mobileNumber);
        System.out.println("Experience (Months)  :"+experienceOfMonths);
        System.out.println("working Hours/day   :"+woringHoursPerDay);
        System.out.println("Salary (Monthly)   :"+mothlySalary);
        System.out.println("Performance Grade   :"+performanceGrade);
        System.out.println("Employee status(Active)  :"+isActiveEmployee);

    }

}
