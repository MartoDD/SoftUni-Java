package com.resellerapp.model.entity;

import com.resellerapp.model.enums.ConditionEnums;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "conditions")
public class Condition extends BaseEntity {

    @Column(unique = true, nullable = false)
    @Enumerated(EnumType.STRING)
    private ConditionEnums name;

    @Column(nullable = false)
    private String description;

    @OneToMany(mappedBy = "condition")
    private Set<Offer> offers;


    public Condition() {
    }

    public ConditionEnums getName() {
        return name;
    }

    public void setName(ConditionEnums name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Offer> getOffers() {
        return offers;
    }

    public void setOffers(Set<Offer> offers) {
        this.offers = offers;
    }
}
