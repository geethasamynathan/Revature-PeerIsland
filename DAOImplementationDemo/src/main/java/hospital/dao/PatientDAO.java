package hospital.dao;

import hospital.model.Patient;

import java.util.List;

public interface PatientDAO {
    void addPatient(Patient patient);
    Patient getPatientById(int id);
    List<Patient> getAllPatients();
    List<Patient> searchPatientByName(String name);
    List<Patient> searchPatientByDisease(String disease);
    boolean updatePatient(Patient patient);
    boolean deletePatient(int id);

}
