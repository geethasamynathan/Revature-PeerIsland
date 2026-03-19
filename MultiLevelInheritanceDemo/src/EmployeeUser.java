class EmployeeUser extends User{
    protected String department;

    public void accessEmployeeProtal(){
        System.out.println(name+" accessing Employee portal" );
    }
}