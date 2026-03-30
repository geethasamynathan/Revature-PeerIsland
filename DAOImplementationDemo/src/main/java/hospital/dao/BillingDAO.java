package hospital.dao;

import hospital.model.Billing;

import java.sql.Connection;

public interface BillingDAO {
    void addBill(Connection conn, Billing billing) throws Exception;
}
