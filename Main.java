package hospital.app;
import java.util.List;
import java.util.Scanner;

import hospital.model.Patient;
import hospital.service.PatientService;

public class Main {
    private static final PatientService service=new PatientService();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n====== HOSPITAL PATIENT MANAGEMENT ======");
            System.out.println("1. Add Patient");
            System.out.println("2. View Patient By ID");
            System.out.println("3. View All Patients");
            System.out.println("4. Update Patient");
            System.out.println("5. Delete Patient");
            System.out.println("6. Search Patient By Name");
            System.out.println("7. Search Patient By Disease");
            System.out.println("8. Get Patient Count By Disease");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addPatient(sc);
                case 2 -> viewPatientById(sc);
                case 3 -> viewAllPatients();
                case 4 -> updatePatient(sc);
                case 5 -> deletePatient(sc);
                case 6 -> searchByName(sc);
                case 7 -> searchByDisease(sc);
                case 8 -> getPatientCountByDisease(sc);
                case 9 -> System.out.println("Exiting application...");
                default -> System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 9);

        sc.close();
    }
private static void getPatientCountByDisease(Scanner sc){
    System.out.print("Enter Disease: ");
    String disease = sc.nextLine();

    int count=service.getPatientCountByDisease(disease);
    System.out.println("Number of patients with the Disease "+count);
    }

    private static void addPatient(Scanner sc) {
        System.out.print("Enter Patient ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Patient Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Disease: ");
        String disease = sc.nextLine();
        Patient patient = new Patient(id, name, disease);
        service.registerPatient(patient);
    }

    private static void viewPatientById(Scanner sc) {
        System.out.print("Enter Patient ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        Patient patient = service.getPatientById(id);
        if (patient != null) {
            System.out.println(patient);
        } else {
            System.out.println("Patient not found.");
        }
    }

    private static void viewAllPatients() {
        List<Patient> patients = service.getAllPatients();
        if (patients.isEmpty()) {
            System.out.println("No patient records found.");
        } else {
            patients.forEach(System.out::println);
        }
    }

    private static void updatePatient(Scanner sc) {
        System.out.print("Enter Patient ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter New Name: ");
        String name = sc.nextLine();

        System.out.print("Enter New Disease: ");
        String disease = sc.nextLine();


        Patient patient = new Patient(id, name, disease);
        service.modifyPatient(patient);
    }

    private static void deletePatient(Scanner sc) {
        System.out.print("Enter Patient ID to delete: ");
        int id = sc.nextInt();
        sc.nextLine();

        service.removePatient(id);
    }

    private static void searchByName(Scanner sc) {
        System.out.print("Enter Name to search: ");
        String name = sc.nextLine();

        List<Patient> patients = service.searchByName(name);
        displaySearchResults(patients);
    }

    private static void searchByDisease(Scanner sc) {
        System.out.print("Enter Disease to search: ");
        String disease = sc.nextLine();

        List<Patient> patients = service.searchByDisease(disease);
        displaySearchResults(patients);
    }


    private static void displaySearchResults(List<Patient> patients) {
        if (patients.isEmpty()) {
            System.out.println("No matching patient records found.");
        } else {
            patients.forEach(System.out::println);
        }
    }
}
