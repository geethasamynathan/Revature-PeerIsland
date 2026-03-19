public class HybridImplementationDemo {
    public static void main(String[] args){
        Manager manager=new Manager(103,"Oswal","admin",25);
        System.out.println("============== Manager login ====================");
        manager.login("oswal","admin!23");

        System.out.println("==============Manager Details =====");
        manager.displayManagerDetails();

        System.out.println("\n =============== Manager Actions ========");
        manager.accessEmployeePortal();
        manager.accessReports();


    }
}
