class ManagerUser extends EmployeeUser {
    private int teamSize;

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }
    public int getTeamSize() {
        return teamSize;
    }

    public void approveLeave() {
        System.out.println("Manager approove Leave");
    }

    public void displayManagerDetails() {
        System.out.println("user Id" + userId);
        System.out.println("name" + name);
        System.out.println("Department" + department);
        System.out.println("Team Size" + teamSize);
    }

}