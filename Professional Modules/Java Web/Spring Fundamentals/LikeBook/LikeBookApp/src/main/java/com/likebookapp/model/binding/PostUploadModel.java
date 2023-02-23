package com.likebookapp.model.binding;

import com.likebookapp.model.enums.MoodsEnum;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PostUploadModel {

    private Long id;

    @NotBlank(message = "Content cannot be blank!")
    @Size(min = 2, max = 150, message = "Content length must be between 2 and 150 characters!")
    private String content;
    @NotNull(message = "You must select mood!")
    private MoodsEnum mood;

    public PostUploadModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public MoodsEnum getMood() {
        return mood;
    }

    public void setMood(MoodsEnum mood) {
        this.mood = mood;
    }
}
