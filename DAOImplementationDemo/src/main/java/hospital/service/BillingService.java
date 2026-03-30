package hospital.service;

import hospital.dao.BillingDAO;
import hospital.dao.BillingDAOImpl;
import hospital.model.Billing;

import java.sql.Connection;

public class BillingService {

    private final BillingDAO billingDAO = new BillingDAOImpl();

    public void addBill(Connection conn, Billing billing) throws Exception {
        if (billing.getAmount() <= 0) {
            throw new IllegalArgumentException("Bill amount must be greater than 0");
        }

        if (billing.getPaymentStatus() == null || billing.getPaymentStatus().trim().isEmpty()) {
            throw new IllegalArgumentException("Payment status cannot be empty");
        }

        billingDAO.addBill(conn, billing);
    }
}
