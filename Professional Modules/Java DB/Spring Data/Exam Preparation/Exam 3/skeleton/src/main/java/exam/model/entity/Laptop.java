package exam.model.entity;

import exam.model.entity.enums.WarrantyType;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;

@Entity
@Table(name = "laptops")
public class Laptop extends BaseEntity {

    @Column(name = "mac_address", nullable = false, unique = true)
    @Size(min = 8)
    private String macAddress;

    @Column(name = "cpu_speed")
    @NotNull
    private double cpuSpeed;

    @Column
    @NotNull
    @Min(8)
    @Max(128)
    private int ram;

    @Column
    @NotNull
    @Min(128)
    @Max(1024)
    private int storage;

    @Column(nullable = false, columnDefinition = "TEXT")
    @Size(min = 10)
    private int description;

    @Column
    @NotNull
    @Positive
    private BigDecimal price;

    @Column(name = "warranty_type", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private WarrantyType warrantyType;

    @ManyToOne
    private Shop shop;

    public String getMacAddress() {
        return macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public double getCpuSpeed() {
        return cpuSpeed;
    }

    public void setCpuSpeed(double cpuSpeed) {
        this.cpuSpeed = cpuSpeed;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public int getDescription() {
        return description;
    }

    public void setDescription(int description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public WarrantyType getWarrantyType() {
        return warrantyType;
    }

    public void setWarrantyType(WarrantyType warrantyType) {
        this.warrantyType = warrantyType;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }
}
