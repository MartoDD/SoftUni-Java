package entities;

public enum BillingType {
    CREDIT_CARD("credit_card"),
    BANK_ACCOUNT("bank_account");

    private String value;

    BillingType() {

    }

    BillingType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
