
class Employee
{
    private int id;
    private String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

public class Sample {
    public static void main(String[] args) {
        Employee e1 = new Employee(101, "Sam");
        Employee e2 = new Employee(101, "Sam");
 //e1=e2;
        System.out.println("e1 == e2 : " +(e1 == e2));
        System.out.println("e1.equals(e2) "+e1.equals(e2));
        System.out.println("e1 hashcode : " +e1.hashCode());
        System.out.println( "e2 hashcode : " +e2.hashCode());

        System.out.println(e1.hashCode()==e2.hashCode());
    }

}

