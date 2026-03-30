package hospital.app;

import hospital.service.UserService;

import java.util.Scanner;

public class LoginMain {

    private static  final UserService service=new UserService();

    public static  void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n -------------------- LOGIN DEMO ----- ");
            System.out.println("1. Unsafe Login (SQL Injection Vulnerable)");
            System.out.println("2. Safe Login (Prepared Statement");
            System.out.println("1. Exit");
            System.out.println("Enter your choice");

            choice = sc.nextInt();
            sc.nextLine();


            switch (choice) {
                case 1 -> doUnsafeLogin(sc);
                case 2 -> doSafeLogin(sc);
                case 3 -> System.out.println("Exiting ... ");
                default -> System.out.println("Invalid Entry");
            }

        }while (choice!=3);

        sc.close();
    }

        private static void doUnsafeLogin(Scanner sc) {
            System.out.print("Enter username: ");
            String username = sc.nextLine();

            System.out.print("Enter password: ");
            String password = sc.nextLine();

            boolean result = service.loginUnsafe(username, password);

            if (result) {
                System.out.println("Login success (Unsafe login)");
            } else {
                System.out.println("Invalid login");
            }
        }


        private static void doSafeLogin(Scanner sc) {
        System.out.print("Enter username: ");
        String username = sc.nextLine();

        System.out.print("Enter password: ");
        String password = sc.nextLine();

        boolean result = service.loginSafe(username, password);

        if (result) {
            System.out.println("Login success (Safe login)");
        } else {
            System.out.println("Invalid login");
        }
    }
    }


