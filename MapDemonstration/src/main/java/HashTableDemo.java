import java.util.*;
public class HashTableDemo {
    public static void main(String[] args) {
        Hashtable<String, String> config = new Hashtable<>();
        config.put("8080", "Jenkins");
        config.put("9090", "Airflow");
        config.put("5000", "Development");
        config.put("6000", "Testing");


        System.out.println(config);
    }
}
