package hospital.service;

import hospital.dao.PatientDAO;
import hospital.dao.PatientDAOImpl;
import hospital.model.Appointment;
import hospital.model.Billing;
import hospital.model.Patient;
import hospital.util.UnitOfWork;

public class HospitalService {
    private final PatientDAO patientDAO = new PatientDAOImpl();
    private final AppointmentService appointmentService = new AppointmentService();
    private final BillingService billingService = new BillingService();

    public void registerFullVisit(Patient patient, Appointment appointment, Billing billing) {
        UnitOfWork uow = null;
        try {
            uow = new UnitOfWork();

            patientDAO.addPatient(uow.getConnection(), patient);
            appointmentService.addAppointment(uow.getConnection(), appointment);
            billingService.addBill(uow.getConnection(), billing);

            uow.commit();
            System.out.println("Patient, appointment, and billing saved successfully.");

        } catch (Exception e) {
            System.out.println("Transaction failed. Rolling back all changes.");
            if (uow != null) {
                uow.rollback();
            }
            e.printStackTrace();
        } finally {
            if (uow != null) {
                uow.close();
            }
        }
    }
}
