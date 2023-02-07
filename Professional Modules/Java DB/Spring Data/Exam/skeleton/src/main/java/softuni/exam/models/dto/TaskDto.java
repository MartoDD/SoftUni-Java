package softuni.exam.models.dto;

import javax.validation.constraints.Positive;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;


@XmlAccessorType(XmlAccessType.FIELD)
public class TaskDto {

    @XmlElement(name = "date")
    private String date;

    @XmlElement(name = "price")
    @Positive
    private BigDecimal price;

    @XmlElement(name = "car")
    private IdDto car;

    @XmlElement(name = "mechanic")
    private TaskMechanicDto mechanicName;

    @XmlElement(name = "part")
    private IdDto part;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public IdDto getCar() {
        return car;
    }

    public void setCar(IdDto car) {
        this.car = car;
    }

    public TaskMechanicDto getMechanicName() {
        return mechanicName;
    }

    public void setMechanicName(TaskMechanicDto mechanicName) {
        this.mechanicName = mechanicName;
    }

    public IdDto getPart() {
        return part;
    }

    public void setPart(IdDto part) {
        this.part = part;
    }
}
