public class OrderService {

    //ConfigManager configManager=new ConfigManager();
    public  void  createOrder(){
        ConfigManager configManager=ConfigManager.getInstance();
        System.out.println(" Order Created for Company "+configManager.getCompanyName());
    }
}
