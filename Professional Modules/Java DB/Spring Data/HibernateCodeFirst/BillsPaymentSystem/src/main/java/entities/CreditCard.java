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
@NoArgsConstructor
public class CreditCard extends BillingDetail {

    @Column(nullable = false)
    private String type;

    @Column(name = "expiration_month", nullable = false)
    private String expirationMonth;

    @Column(name = "expiration_year", nullable = false)
    private int expirationYear;

    @Enumerated
    private BillingType billingType;

    public CreditCard(BillingType billingType) {
        this.billingType = BillingType.CREDIT_CARD;
    }

    public CreditCard(String type, String expirationMonth, int expirationYear, BillingType billingType) {
        this.type = type;
        this.expirationMonth = expirationMonth;
        this.expirationYear = expirationYear;
        this.billingType = BillingType.CREDIT_CARD;
    }


}
