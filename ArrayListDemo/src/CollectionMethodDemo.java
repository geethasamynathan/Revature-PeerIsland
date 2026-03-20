import java.nio.charset.CoderResult;
import java.util.ArrayList;
import java.util.Collections;

public class CollectionMethodDemo {
    public static  void main(String[] args){
        ArrayList<String> courses= new ArrayList<>();

        courses.add("Core Java");
        courses.add("Python");
        courses.add("SQL");
        courses.add("Core Java");
        courses.add("Angular");
        courses.add("Data Engineering");
        courses.add("SQL");

        System.out.println("indexof('SQL') : "+courses.indexOf("SQL"));
        System.out.println("lastIndexOf('SQL') : "+courses.lastIndexOf("SQL"));
        System.out.println(" Courses : "+courses);
        System.out.println("Size : "+courses.size());
        System.out.println( "Is Python Curse available? "+ courses.contains("Python"));

        courses.remove("SQL");
        System.out.println("After Removal of SQL " +courses);
        System.out.println("After Removal of SQL size " +courses.size());

        System.out.println("is courses is Empty? " +courses.isEmpty());

        System.out.println(" courses[2]"+courses.get(2));
        System.out.println(" Courses : "+courses);

        courses.add(1,"Azure");
        System.out.println(" After adding courses.add(1,Azure) "+courses);

        System.out.println("indexof('Azure') : "+courses.indexOf("Azure"));

        Collections.sort(courses);
        System.out.println("After sorting : "+courses);
ArrayList<String> cloudCourses=new ArrayList<>();
cloudCourses.add("AWS");
cloudCourses.add("GCP");
cloudCourses.add("DataBricks");

courses.addAll(cloudCourses);
        System.out.println(" after addAll cloudCourses  : "+courses);
        //updating the value
//        courses.set(1,"MongoDB");
//        System.out.println(" Courses : "+courses);
//
//        courses.remove(1);
//        System.out.println("After removing courses.remove(1) : "+courses);
//
//        courses.removeLast();
//        System.out.println("After removing courses.removeLast(); : "+courses);


    }
}
