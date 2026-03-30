package hospital.service;

import hospital.dao.PatientDAO;
import hospital.dao.PatientDAOImpl;
import hospital.model.Patient;

import java.util.List;

public class PatientService {

    private final PatientDAO patientDAO = new PatientDAOImpl() ;

        public void registerPatient(Patient patient) {
            if (patient.getName() == null || patient.getName().trim().isEmpty()) {
                System.out.println("Patient name cannot empty. ");
                return;
            }
            if (patient.getDisease() == null || patient.getDisease().trim().isEmpty()) {
                System.out.println("Disease Cannnot be  empty. ");
                return;
            }

            patientDAO.addPatient(patient);
        }


        public Patient getPatientById(int id) {
            return patientDAO.getPatientById(id);
        }


        public List<Patient> getAllPatients() {
            return patientDAO.getAllPatients();
        }


        public List<Patient> searchByName(String name) {
            return patientDAO.searchPatientByName(name);
        }


        public List<Patient> searchByDisease(String disease) {
            return patientDAO.searchPatientByDisease(disease);
        }


        public void modifyPatient(Patient patient) {
            if (patient.getId() <= 0) {
                System.out.println("Invalid Patient Id");
                return;
            }
            boolean updated = patientDAO.updatePatient(patient);
            if (updated) {
                System.out.println("Patient data updated");
            }
            else {
                System.out.println("Patient Id not Found to  update");
            }
        }


        public void removePatient(int id) {
            boolean deleted = patientDAO.deletePatient(id);
            if (deleted) {
                System.out.println("Patient deleted successfully.");
            } else {
                System.out.println("Patient not found or delete failed.");
            }

        }

        public int getPatientCountByDisease(String disease){
            if(disease== null || disease.trim().isEmpty())
            {
                System.out.println("Disease cannot be Empty");
                return 0;
            }
            return  patientDAO.getPatientCountByDisease(disease);
        }
    }


