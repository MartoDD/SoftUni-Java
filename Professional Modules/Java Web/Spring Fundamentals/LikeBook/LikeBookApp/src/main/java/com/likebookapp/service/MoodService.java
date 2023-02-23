package com.likebookapp.service;

import com.likebookapp.model.entity.Mood;
import com.likebookapp.model.enums.MoodsEnum;

public interface MoodService {

    public void initMood();

    public Mood findMoodByName(MoodsEnum moodsEnum);
}
