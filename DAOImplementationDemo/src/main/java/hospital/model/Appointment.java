package hospital.model;

import java.time.LocalDate;

public class Appointment {

    private int patientId;
    private String doctorName;
    private LocalDate appointmentDate;

    public Appointment(int patientId, String doctorName, LocalDate appointmentDate) {
        this.patientId = patientId;
        this.doctorName = doctorName;
        this.appointmentDate = appointmentDate;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }
}
