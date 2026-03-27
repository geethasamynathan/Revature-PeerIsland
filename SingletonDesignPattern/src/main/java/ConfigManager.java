public class ConfigManager {
    private  static  ConfigManager instance;
    private String companyName;

    private ConfigManager(){
        System.out.println("Loading Configuration from file ...");
        companyName=" ABC Technologies";
    }

    public static  ConfigManager getInstance(){
        if(instance==null)
        {
            instance=new ConfigManager();
        }
        return instance;
    }
    public  String getCompanyName(){
        return  companyName;
    }
}
