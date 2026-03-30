package hospital.service;

import hospital.dao.AppointmentDAO;
import hospital.dao.AppointmentDAOImpl;
import hospital.model.Appointment;

import java.sql.Connection;

public class AppointmentService {

    private final AppointmentDAO appointmentDAO = new AppointmentDAOImpl();

    public void addAppointment(Connection conn, Appointment appointment) throws Exception {
        if (appointment.getDoctorName() == null || appointment.getDoctorName().trim().isEmpty()) {
            throw new IllegalArgumentException("Doctor name cannot be empty");
        }

        appointmentDAO.addAppointment(conn, appointment);
    }
}
