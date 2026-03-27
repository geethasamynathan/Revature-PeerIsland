public class InvoiceService {

    //ConfigManager configManager=new ConfigManager();
       // ConfigManager configManager=ConfigManager.getInstance();

        public  void  generatInvoice(){
            ConfigManager configManager=ConfigManager.getInstance();
            
            System.out.println(" Invoice generated  for Company "+configManager.getCompanyName());
        }
    }


