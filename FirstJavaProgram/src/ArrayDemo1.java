import java.util.Arrays;

public class ArrayDemo1 {
    public static void main(String[] args){
        int[] marks={101,122,103,107,100};
//        System.out.println("Size of an Array is "+marks.length);
//        int total=0;
//        for(int  mark :marks){
//            total+=mark;
//        }
//        System.out.println("Sum of Marks "+total);
//        System.out.println("Average value"+(total/marks.length));
//
//        System.out.println("First mark"+marks[0]);
//        System.out.println("Third mark"+marks[2]);
//        System.out.println("Fifth mark"+marks[4]);
//        System.out.println("Seventh mark"+marks[6]); //arrayIndexOutofBound

        System.out.println(Arrays.toString(marks));
        Arrays.sort(marks);
        System.out.println("Sorted array lements are " +Arrays.toString(marks));


    }
}

