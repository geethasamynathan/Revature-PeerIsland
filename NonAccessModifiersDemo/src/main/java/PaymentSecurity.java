final class PaymentSecurity {
    void verifyTransaction() {
        System.out.println(" Transaction verified with secure rules");
    }
}

class FinalClassExample {
    public static void main(String[] args) {
        PaymentSecurity security = new PaymentSecurity();
        security.verifyTransaction();

    }

}