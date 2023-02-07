package com.example.football.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity
@Table(name = "towns")
public class Town extends BaseEntity {

    @Column(nullable = false, unique = true)
    @Size(min = 2)
    private String name;

    @Column(nullable = false)
    @Positive
    private int population;

    @Column(name = "travel_guide", nullable = false, columnDefinition = "TEXT")
    @Size(min = 10)
    private String travelGuide;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getTravelGuide() {
        return travelGuide;
    }

    public void setTravelGuide(String travelGuide) {
        this.travelGuide = travelGuide;
    }
}
