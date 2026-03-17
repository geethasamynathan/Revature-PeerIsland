public class Company {

    static class HRPolicy {
        public void showPolicy() {
            System.out.println(" Office Timing 9:00 am tp 5:00  PM");

        }
    }
        public static  void main(String[] args){
        Company.HRPolicy policy=new Company.HRPolicy();
        policy.showPolicy();
    }
}
