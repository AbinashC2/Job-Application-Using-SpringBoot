package com.abinash.Firstjobapp.JOB.Reviews;

import jakarta.persistence.Entity;

@Entity
public class Review {

    private long id;
    private String title;
    private String description;
    private boolean ratings;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isRatings() {
        return ratings;
    }

    public void setRatings(boolean ratings) {
        this.ratings = ratings;
    }
}
