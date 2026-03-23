public class Employee {

    private int id;
    private String name;
    private  String department;
    private double salary;
    private int age;

    public Employee(int id, String name, String department, double salary, int age) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.age = age;
    }

    public int getAge() {
        return age;
    }


    public String getDepartment() {
        return department;
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }



    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString(){
        return "Employee{"+
                "id = "+id+
                ",Name = '" + name + '\'' +
                ", department = '"+department+'\'' +
                ", salary ="+salary+
                ", Age = "+age+
                '}';
    }
}
