import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class SetDemo {
    public static  void main(String[] args){
        Set<String> skills=new HashSet<>();
        skills.add("Java");
        skills.add("Python");
        skills.add("snowflake");
        skills.add("Service now");

        System.out.println(skills);

        //contains, isEmpty, Remove,...

        Iterator<String> iterator=skills.iterator();
        while(iterator.hasNext())
        {
            System.out.println(iterator.next());
        }

        for(String skill :skills){
            System.out.println(skill);
        }
    }
}
