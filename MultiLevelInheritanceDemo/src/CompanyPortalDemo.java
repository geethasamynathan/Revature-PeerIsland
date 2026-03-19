public class CompanyPortalDemo {
    public static void main(String[] args){
        ManagerUser manager1=new ManagerUser();
        manager1.userId=101;
        manager1.name="Adhira";
        manager1.department="SDET";
        manager1.setTeamSize(12);
        manager1.login();
        manager1.accessEmployeeProtal();
        manager1.approveLeave();
        System.out.println("============== Manager Info ==========");
        manager1.displayManagerDetails();

        System.out.println(manager1.name+"is  working as Manager in "
                +manager1.department+" handles a team of"+manager1.getTeamSize());

    }
}
