import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapBasicDemo {
    public static void main(String[] args){
        Map<Integer,String> employees=new HashMap<>();
        employees.put(101,"Harish");
        employees.put(102,"Shivam");
        employees.put(103,"Ananya");

        System.out.println(employees);
        System.out.println("103 "+employees.get(103));

        employees.put(104,"dummy");
        System.out.println(" Before Removes 104  ");
        System.out.println(employees);
        employees.remove(104);
        System.out.println(" After Removes 104  ");
        System.out.println(employees);

        System.out.println("is 102 available ? "+employees.containsKey((102)));
        System.out.println("is Dummy available ? "+employees.containsValue(("Dummy")));
        System.out.println("employees size  "+employees.size());

        Set<Integer> employeeKeySet=employees.keySet();
        System.out.println(employeeKeySet);
        Collection<String> employeeNames=employees.values();
        System.out.println(employeeNames);


        for(Map.Entry<Integer,String> entry:employees.entrySet()){
            System.out.println("Id : "+entry.getKey() + " - "+entry.getValue());
        }

        //putIfAbsent
        employees.putIfAbsent(105,"Nithin");
        System.out.println(employees);

        //replace
        employees.replace(105,"Sun");
        System.out.println(employees);

        System.out.println(employees.getOrDefault(106,"NA"));

        //forEach
        employees.forEach((id,name)->
                System.out.println("Emp Id:"+id + "Name : "+name));


        employees.computeIfAbsent(106, k ->"New Employee");
        System.out.println(employees);

        employees.computeIfPresent(106,(k,v) -> "Janani");
        System.out.println(employees);

        employees.merge(102," Kumar",(oldValue,newValue) -> oldValue+newValue);
        System.out.println(employees);
    }
}
