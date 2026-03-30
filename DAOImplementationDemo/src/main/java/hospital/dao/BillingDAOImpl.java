package hospital.dao;

import hospital.model.Billing;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class BillingDAOImpl implements  BillingDAO{
    @Override
    public void addBill(Connection conn, Billing billing) throws Exception {
        String sql = "INSERT INTO billing(patient_id, amount, payment_status) VALUES (?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, billing.getPatientId());
            ps.setDouble(2, billing.getAmount());
            ps.setString(3, billing.getPaymentStatus());
            ps.executeUpdate();
        }
    }
}
