package entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;

@Entity
@Getter
@Setter
public class BankAccount extends BillingDetail {

    @Column(name = "bank_name", nullable = false)
    private String bankName;

    @Column(name = "switf_code", nullable = false)
    private String swiftCode;

    @Enumerated
    private BillingType billingType;

    public BankAccount() {
        billingType = BillingType.BANK_ACCOUNT;
    }

    public BankAccount(String bankName, String swiftCode, BillingType billingType) {
        this.bankName = bankName;
        this.swiftCode = swiftCode;
        this.billingType = BillingType.BANK_ACCOUNT;
    }
}
