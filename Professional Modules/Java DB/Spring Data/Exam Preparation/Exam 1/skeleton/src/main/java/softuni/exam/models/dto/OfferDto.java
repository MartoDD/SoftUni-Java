package softuni.exam.models.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class OfferDto {

    @XmlElement(name = "price")
    @Positive
    @NotNull
    private BigDecimal price;

    @XmlElement(name = "agent")
    private AgentNameDto agentName;

    @XmlElement(name = "apartment")
    private ApartmentIdDto apartmentId;

    @XmlElement(name = "publishedOn")
    private String publishedOn;

    public OfferDto() {
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public AgentNameDto getAgentName() {
        return agentName;
    }

    public void setAgentName(AgentNameDto agentName) {
        this.agentName = agentName;
    }

    public ApartmentIdDto getApartmentId() {
        return apartmentId;
    }

    public void setApartmentId(ApartmentIdDto apartmentId) {
        this.apartmentId = apartmentId;
    }

    public String getPublishedOn() {
        return publishedOn;
    }

    public void setPublishedOn(String publishedOn) {
        this.publishedOn = publishedOn;
    }
}
