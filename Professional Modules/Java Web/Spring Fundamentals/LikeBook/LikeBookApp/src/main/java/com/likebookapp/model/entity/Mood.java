package com.likebookapp.model.entity;

import com.likebookapp.model.enums.MoodsEnum;

import javax.persistence.*;

@Entity
@Table(name = "moods")
public class Mood extends BaseEntity{

    @Column(name = "mood_name",unique = true,nullable = false)
    @Enumerated(EnumType.STRING)
    private MoodsEnum moodName;

    private String description;

    public Mood() {
    }

    public MoodsEnum getMoodName() {
        return moodName;
    }

    public void setMoodName(MoodsEnum moodName) {
        this.moodName = moodName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
