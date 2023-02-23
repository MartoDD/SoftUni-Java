package com.likebookapp.model.binding;

import com.likebookapp.model.entity.Mood;
import com.likebookapp.model.entity.User;

import java.util.Set;

public class ReturnedPosts {
    private Long id;

    private Mood mood;
    private String content;
    private Set<User> userLikes;
    private User user;

    public ReturnedPosts() {
    }

    public Mood getMood() {
        return mood;
    }

    public void setMood(Mood mood) {
        this.mood = mood;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Set<User> getUserLikes() {
        return userLikes;
    }

    public void setUserLikes(Set<User> userLikes) {
        this.userLikes = userLikes;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
