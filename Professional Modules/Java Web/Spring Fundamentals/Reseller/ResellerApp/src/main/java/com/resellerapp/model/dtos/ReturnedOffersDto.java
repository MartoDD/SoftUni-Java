package com.resellerapp.model.dtos;

import com.resellerapp.model.entity.Condition;
import com.resellerapp.model.entity.User;

public class ReturnedOffersDto {

    private Long id;
    private Condition condition;
    private String description;
    private double price;
    private User user;

    public ReturnedOffersDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
