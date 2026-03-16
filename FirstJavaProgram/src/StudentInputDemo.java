import java.util.Scanner;

public class StudentInputDemo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Roll Number: ");
        int rollNo = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        byte age = sc.nextByte();

        System.out.print("Enter Section: ");
        char section = sc.next().charAt(0);

        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();

        System.out.print("Passed? (true/false): ");
        boolean passed = sc.nextBoolean();

        System.out.println("\n----- STUDENT DETAILS -----");
        System.out.println("Roll Number : " + rollNo);
        System.out.println("Name        : " + name);
        System.out.println("Age         : " + age);
        System.out.println("Section     : " + section);
        System.out.println("Marks       : " + marks);
        System.out.println("Passed      : " + passed);

        sc.close();
    }
}