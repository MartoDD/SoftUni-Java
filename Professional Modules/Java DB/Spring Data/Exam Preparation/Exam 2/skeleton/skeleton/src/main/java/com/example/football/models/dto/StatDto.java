package com.example.football.models.dto;

import javax.validation.constraints.Positive;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

@XmlRootElement(name = "stat")
@XmlAccessorType(XmlAccessType.FIELD)
public class StatDto {

    @XmlElement(name = "shooting")
    @Positive
    private BigDecimal shooting;

    @XmlElement(name = "passing")
    @Positive
    private BigDecimal passing;

    @XmlElement(name = "endurance")
    @Positive
    private BigDecimal endurance;



    public BigDecimal getShooting() {
        return shooting;
    }

    public void setShooting(BigDecimal shooting) {
        this.shooting = shooting;
    }

    public BigDecimal getPassing() {
        return passing;
    }

    public void setPassing(BigDecimal passing) {
        this.passing = passing;
    }

    public BigDecimal getEndurance() {
        return endurance;
    }

    public void setEndurance(BigDecimal endurance) {
        this.endurance = endurance;
    }
}
