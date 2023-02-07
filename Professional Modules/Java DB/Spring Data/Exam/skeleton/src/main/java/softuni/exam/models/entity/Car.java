package softuni.exam.models.entity;

import softuni.exam.models.entity.enums.CarType;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity
@Table(name = "cars")
public class Car extends BaseEntity {

    @Column(name = "car_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private CarType carType;

    @Column(name = "car_make", nullable = false)
    @Size(min = 2, max = 30)
    private String carMake;

    @Column(name = "car_model", nullable = false)
    @Size(min = 2, max = 30)
    private String carModel;

    @Column(nullable = false)
    @Positive
    private int year;

    @Column(name = "plate_number", nullable = false, unique = true)
    @Size(min = 2, max = 30)
    private String plateNumber;

    @Column(nullable = false)
    @Positive
    private int kilometers;

    @Column(nullable = false)
    @DecimalMin("1.0")
    private double engine;

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public String getCarMake() {
        return carMake;
    }

    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public int getKilometers() {
        return kilometers;
    }

    public void setKilometers(int kilometers) {
        this.kilometers = kilometers;
    }

    public double getEngine() {
        return engine;
    }

    public void setEngine(double engine) {
        this.engine = engine;
    }
}
