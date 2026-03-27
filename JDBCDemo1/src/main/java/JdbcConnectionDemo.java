import java.sql.*;

public class JdbcConnectionDemo {
   private static final String URL="jdbc:mysql://localhost:3306/companydb";
    private static final String USERNAME = "root";
    private static final  String PASSWORD = "root@123";
    public static void main(String[] args){
        createEmployee("Harish","Developer",65000);
        createEmployee("Ananya","Devops Engineer",64000);

        System.out.println(" All Employees after insert ");
        readEmployees();

        System.out.println(" Update Employees salary ");
        updateEmployeeSalry(1,99999);
        readEmployees();

        System.out.println(" Delete employee ");
        deleteEmployee(1);
        readEmployees();
    }

    public static  Connection getConnection() throws SQLException{
        return  DriverManager.getConnection(URL,USERNAME,PASSWORD);
    }

    public static  void createEmployee(String name,String department,double salary){
        String insertQuery= "INSERT INTO employee (name,department,salary) VALUES (?,?,?)";

        try(Connection connection=getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(insertQuery)){
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,department);
            preparedStatement.setDouble(3,salary);
            int rowsInserted=preparedStatement.executeUpdate();

            if(rowsInserted>0)
            {
                System.out.println("Employee Record inserted successflly : "+name);
            }
        }catch(SQLException e)
        {
            System.out.println("Error while inserting new Employee");
            e.printStackTrace();
        }
    }

    public static void readEmployees() {
        String selectQuery = "SELECT id,name,department,salary FROM employee";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
            ResultSet resultSet = preparedStatement.executeQuery(selectQuery);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String department = resultSet.getString("department");
                double salary = resultSet.getDouble("salary");

                System.out.println("Id : " + id);
                System.out.println("Name : " + name);
                System.out.println("Department : " + department);
                System.out.println("Salary : " + salary);

            }

        } catch (SQLException e) {
            System.out.println("Error while Fetching Employees");
            e.printStackTrace();
        }
    }
    public static  void updateEmployeeSalry(int id,double newSalary){
        String updateQuery= "UPDATE employee SET salary=? WHERE id=?";

        try(Connection connection=getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(updateQuery)){
            preparedStatement.setDouble(1,newSalary);
            preparedStatement.setInt(2,id);
            int rowsInserted=preparedStatement.executeUpdate();

            if(rowsInserted>0)
            {
                System.out.println("Employee Salary updated successfully fwith the : "+id);
            }else {
                System.out.println("No Employee Salary found with the Id : "+id);
            }
        }catch(SQLException e)
        {
            System.out.println("Error while Updating salary ");
            e.printStackTrace();
        }
    }

    public static  void deleteEmployee(int id){
        String deleteQuery= "DELETE FROM employee  WHERE id=?";

        try(Connection connection=getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(deleteQuery)){
             preparedStatement.setInt(1,id);
            int rowsInserted=preparedStatement.executeUpdate();

            if(rowsInserted>0)
            {
                System.out.println("Employee deleted successflly with the Id : "+id);
            }else {
                System.out.println("No Employee Salary found with thw Id : "+id);
            }
        }catch(SQLException e)
        {
            System.out.println("Error while Deleting employee ");
            e.printStackTrace();
        }
    }
}
