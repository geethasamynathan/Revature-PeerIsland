package hospital.dao;

import hospital.model.Appointment;

import java.sql.Connection;

public interface AppointmentDAO {
void addAppointment(Connection conn, Appointment appointment) throws Exception;
}
