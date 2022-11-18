package com.example.softunigamestore.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;

public class GameDto {

    private String title;
    private BigDecimal price;
    private float size;
    private String trailer;
    private String imageUrl;
    private String description;
    private LocalDate releaseDate;

    public GameDto() {

    }

    public GameDto(String title, BigDecimal price, float size, String trailer, String imageUrl, String description, LocalDate releaseDate) {
        setTitle(title);
        setPrice(price);
        setSize(size);
        setTrailer(trailer);
        setImageUrl(imageUrl);
        setDescription(description);
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (Character.isLowerCase(title.charAt(0)) || title.length() < 3 || title.length() > 100) {
            throw new IllegalArgumentException("Invalid title.");
        }
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        if (price.floatValue()<=0){
            throw new IllegalArgumentException("Price must be a positive number");
        }
        this.price = price;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        if (size<=0){
            throw new IllegalArgumentException("Size must be a positive number");
        }
        this.size = size;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        if (trailer.length()!=11){
            throw new IllegalArgumentException("Invalid trailer URL");
        }
        this.trailer = trailer;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        if (!imageUrl.matches("^https:\\/\\/\\S+")){
            throw new IllegalArgumentException("Invalid image URL");
        }
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description.length()<20){
            throw new IllegalArgumentException("Invalid description");
        }
        this.description = description;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
}
