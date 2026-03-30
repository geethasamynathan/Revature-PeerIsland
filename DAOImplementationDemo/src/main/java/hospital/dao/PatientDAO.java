package hospital.dao;

import hospital.model.Patient;

import java.sql.Connection;
import java.util.List;

public interface PatientDAO {
    void addPatient(Patient patient) ;
    void addPatient(Connection conn,Patient patient) throws  Exception;

    Patient getPatientById(int id);
    List<Patient> getAllPatients();
    List<Patient> searchPatientByName(String name);
    List<Patient> searchPatientByDisease(String disease);
    boolean updatePatient(Patient patient);
    boolean deletePatient(int id);
    int getPatientCountByDisease(String disease);
}
