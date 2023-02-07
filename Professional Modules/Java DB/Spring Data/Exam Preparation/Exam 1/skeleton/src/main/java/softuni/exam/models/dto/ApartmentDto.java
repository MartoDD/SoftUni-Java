package softuni.exam.models.dto;

import softuni.exam.models.entity.enums.ApartmentType;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ApartmentDto {

    @XmlElement(name = "apartmentType")
    @NotNull
    private ApartmentType apartmentType;

    @XmlElement(name = "area")
    @NotNull
    @DecimalMin(value = "40.00")
    private double area;

    @XmlElement(name = "town")
    private String town;

    public ApartmentDto() {
    }

    public ApartmentType getApartmentType() {
        return apartmentType;
    }

    public void setApartmentType(ApartmentType apartmentType) {
        this.apartmentType = apartmentType;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }
}
