package com.example.football.models.entity;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Entity
@Table(name = "stats")
public class Stat{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    @Positive
    private BigDecimal shooting;

    @Column(nullable = false)
    @Positive
    private BigDecimal passing;

    @Column(nullable = false)
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
