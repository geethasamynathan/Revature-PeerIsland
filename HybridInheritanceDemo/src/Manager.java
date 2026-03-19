public class Manager extends Employee implements  Authenticable,ReportAccessible{
    private int teamSize;

    public Manager(int personId, String name, String department, int teamSize) {
        super(personId, name, department);
        this.teamSize = teamSize;
    }

    public int getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }
    @Override
    public void login(String username,String password){
        System.out.println("Manager login succesful for username "+username);
    }
    public  void accessReports()
    {
        System.out.println(name +" is accessing management Reports");
    }
    public void displayManagerDetails(){
        displayPersonDetails();
        System.out.println("Department "+department);
        System.out.println("Team Size"+teamSize);
    }
}
