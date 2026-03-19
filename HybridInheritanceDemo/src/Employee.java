public class Employee extends Person{
    protected String department;

    public Employee( int personId,String name,String department) {
        super(personId,name);
        this.department=department;
    }

    public void accessEmployeePortal(){
        System.out.println(name + " accessing Employee Portal");
    }
}
