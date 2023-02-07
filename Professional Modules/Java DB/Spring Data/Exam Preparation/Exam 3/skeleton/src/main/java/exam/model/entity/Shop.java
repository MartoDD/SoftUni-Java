package exam.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Table(name = "shops")
public class Shop extends BaseEntity {

    @Column(nullable = false, unique = true)
    @Size(min = 4)
    private String name;

    @Column(nullable = false)
    @Min(20000)
    private int income;

    @Column(nullable = false)
    @Size(min = 4)
    private String address;

    @Column(name = "employee_count", nullable = false)
    @Min(1)
    @Max(50)
    private int employeeCount;

    @Column(name = "shop_area", nullable = false)
    @Min(150)
    private int shopArea;

    @ManyToOne
    private Town town;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }

    public int getShopArea() {
        return shopArea;
    }

    public void setShopArea(int shopArea) {
        this.shopArea = shopArea;
    }

    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }
}
