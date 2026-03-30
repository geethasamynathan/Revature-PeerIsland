
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class PatienceServiceWithoutDAO {

    public static void addPatient(int id, String name, String disease) {
        try {
            Connection connection = DriverManager.
                    getConnection("jdbc:mysql://localhost:3306/hospitaldb", "root", "root@123");

            String insertQuery = "INSERT INTO patient (id,name,disease) VALUES (?,?,?) ";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setInt(1, id);
            ;
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, disease);

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Patient information Inserted successfully");
            } else {
                System.out.println(" Something went wrong while inserting Patient Rcord");
            }
            preparedStatement.close();
            connection.close();
            ;
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
    }

    public static void main(String[] args) {
        int id;
        String name, disease;
        try {
            System.out.println("Enter the Id, name, disease");
            Scanner sc = new Scanner(System.in);
            id = sc.nextInt();
            System.out.println("Enter Patient Name:");
            name = sc.next();

            System.out.println("Enter Disease:");
            disease = sc.next();

            addPatient(id, name, disease);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
