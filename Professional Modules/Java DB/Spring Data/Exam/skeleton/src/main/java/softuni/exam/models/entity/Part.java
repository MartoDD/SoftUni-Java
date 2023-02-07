package softuni.exam.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.*;

@Entity
@Table(name = "parts")
public class Part extends BaseEntity {

    @Column(name = "part_name", nullable = false, unique = true)
    @Size(min = 2, max = 19)
    private String partName;

    @Column(nullable = false)
    @DecimalMin("10.0")
    @DecimalMax("2000.0")
    private double price;

    @Column(nullable = false)
    @Positive
    private int quantity;

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
