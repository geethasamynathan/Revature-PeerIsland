package hospital.model;

public class Billing {
    private int patientId;
    private double amount;
    private String paymentStatus;

    public Billing(int patientId, double amount, String paymentStatus) {
        this.patientId = patientId;
        this.amount = amount;
        this.paymentStatus = paymentStatus;
    }

    public int getPatientId() {
        return patientId;
    }

    public double getAmount() {
        return amount;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }
}
