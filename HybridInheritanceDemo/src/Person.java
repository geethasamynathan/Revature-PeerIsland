public class Person {
    protected int personId;
    protected  String name;

    public Person( int personId,String name) {
        this.name = name;
        this.personId = personId;
    }

    public void displayPersonDetails(){
        System.out.println("Person Id : "+personId);
        System.out.println(" Name "+name);
    }
}
