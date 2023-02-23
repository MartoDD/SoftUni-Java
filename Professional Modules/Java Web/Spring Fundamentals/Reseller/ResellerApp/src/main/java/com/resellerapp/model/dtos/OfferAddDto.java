package com.resellerapp.model.dtos;

import com.resellerapp.model.enums.ConditionEnums;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class OfferAddDto {

    private Long id;

    @NotBlank(message = "Description cannot be blank!")
    @Size(min = 2,max = 50,message = "Description length must be between 2 and 50 characters!")
    private String description;
    @Positive(message = "Price needs to be a positive number!")

    private double price;
    @NotNull(message = "You must select a condition!")
    private ConditionEnums condition;

    public OfferAddDto() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ConditionEnums getCondition() {
        return condition;
    }

    public void setCondition(ConditionEnums condition) {
        this.condition = condition;
    }
}
