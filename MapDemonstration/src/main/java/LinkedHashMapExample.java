import java.util.*;

public class LinkedHashMapExample {
    public static void main(String[] args){
        LinkedHashMap<Integer,String> courseMap=new LinkedHashMap<>();
        courseMap.put(1,"Java");
        courseMap.put(4,"Python");
        courseMap.put(3,"AWS");
        courseMap.put(2,"K8s");
        System.out.println(courseMap);

    }
}
