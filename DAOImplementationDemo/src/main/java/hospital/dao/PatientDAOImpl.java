package hospital.dao;

import hospital.model.Patient;
import hospital.util.DBConection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientDAOImpl implements  PatientDAO{
    @Override
    public void addPatient(Patient patient) {
       String  insertQuery = "INSERT INTO patient (id,name,disease) VALUES (?,?,?) ";
      ;
        try(Connection conn= DBConection.getConnection();
            PreparedStatement ps=conn.prepareStatement(insertQuery)){

        ps.setInt(1, patient.getId());      ;
        ps.setString(2, patient.getName());
        ps.setString(3, patient.getDisease());

        int rowsInserted = ps.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("Patient information Inserted successfully");
        } else {
            System.out.println(" Something went wrong while inserting Patient Rcord");
        }
    }catch (SQLIntegrityConstraintViolationException e)
        {
            System.out.println("Patient Id Already Exists");
        }
        catch (SQLException e)
        {
            System.out.println("Error while inserting  Patient "+e.getMessage());
        }
    }
    @Override
    public void addPatient(Connection conn, Patient patient) throws Exception {
        String insertQuery = "INSERT INTO patient (id, name, disease) VALUES (?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(insertQuery)) {
            ps.setInt(1, patient.getId());
            ps.setString(2, patient.getName());
            ps.setString(3, patient.getDisease());
            ps.executeUpdate();
        }
    }
    @Override
    public Patient getPatientById(int id) {
        String sql = "SELECT * FROM patient WHERE id= ?";
        try (Connection conn = DBConection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return extractPatient(rs);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error while FEtching by   Patient Id " + e.getMessage());
        }
        return  null;
    }


        @Override
        public List<Patient> getAllPatients() {
            List<Patient> patients=new ArrayList<>();
            String sql="SELECT * FROM patient";
            try(Connection conn=DBConection.getConnection();
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery())
            {
                while(rs.next()) {
                    patients.add(extractPatient(rs));
                }
            }catch (SQLException e)
            {
                System.out.println("Error While Fetching all Patient "+e.getMessage());
            }
            return patients;
        }

        @Override
        public List<Patient> searchPatientByName (String name) {
            List<Patient> patients = new ArrayList<>();
            String sql = "SELECT * FROM patient WHERE name LIKE ?";

            try (Connection con = DBConection.getConnection();
                 PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, "%" + name + "%");
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        patients.add(extractPatient(rs));
                    }
                }
            } catch (SQLException e) {
                System.out.println("Error While Fetching  Patients by name " + e.getMessage());
            }
            return  patients;
        }

        @Override
        public List<Patient> searchPatientByDisease (String disease){
            List<Patient> patients = new ArrayList<>();
            String sql = "SELECT * FROM patient WHERE disease LIKE ?";

            try (Connection con = DBConection.getConnection();
                 PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, "%" + disease + "%");
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        patients.add(extractPatient(rs));
                    }
                }
            } catch (SQLException e) {
                System.out.println("Error While Fetching  Patients by disease " + e.getMessage());
            }
            return  patients;
        }

        @Override
        public boolean updatePatient (Patient patient){
            String sql = "UPDATE patient SET name = ?, disease = ? WHERE id = ?";

            try (Connection con = DBConection.getConnection();
                 PreparedStatement ps = con.prepareStatement(sql)) {

                ps.setString(1, patient.getName());
                ps.setString(2, patient.getDisease());
                ps.setInt(3, patient.getId());

                int rows = ps.executeUpdate();
                return rows > 0;

            } catch (SQLException e) {
                System.out.println("Error while updating patient: " + e.getMessage());
            }

            return false;
        }

           @Override
        public boolean deletePatient (int id){
            String sql = "DELETE FROM patient WHERE id = ?";

            try (Connection con = DBConection.getConnection();
                 PreparedStatement ps = con.prepareStatement(sql)) {

                ps.setInt(1, id);
                int rows = ps.executeUpdate();
                return rows > 0;

            } catch (SQLException e) {
                System.out.println("Error while deleting patient: " + e.getMessage());
            }

            return false;
        }


   public int getPatientCountByDisease(String disease)
   {
       int count=0;
       String sql="{call GetPatientCountByDisease(?,?)}";
       try(Connection conn=DBConection.getConnection();
       CallableStatement cs=conn.prepareCall(sql))
       {
           cs.setString(1,disease); //In parameter
           cs.registerOutParameter(2,Types.INTEGER); //OUT paramater

           cs.execute();
           count=cs.getInt(2);
       }catch(Exception e)
       {
           e.printStackTrace();
       }
       return count;
   }

        Patient extractPatient (ResultSet rs) throws SQLException {
            return new Patient(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("disease")
            );
        }
    }

