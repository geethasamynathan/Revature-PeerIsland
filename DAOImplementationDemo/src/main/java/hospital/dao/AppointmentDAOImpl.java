package hospital.dao;

import hospital.model.Appointment;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AppointmentDAOImpl  implements  AppointmentDAO{

    @Override
    public void addAppointment(Connection conn, Appointment appointment) throws Exception {
        String sql = "INSERT INTO appointment(patient_id, doctor_name, appointment_date) VALUES (?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, appointment.getPatientId());
            ps.setString(2, appointment.getDoctorName());
            ps.setDate(3, java.sql.Date.valueOf(appointment.getAppointmentDate()));
            ps.executeUpdate();
        }
    }
}
