package com.pttk.cinema.model;

public class Movie {
    private int id;
    private String name;
    private String category;
    private String description;
    private Integer duration;
    private Integer ageRating;

    public Movie() {
    }

    public Movie(String name, String category, String description, Integer duration, Integer ageRating) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.duration = duration;
        this.ageRating = ageRating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getAgeRating() {
        return ageRating;
    }

    public void setAgeRating(Integer ageRating) {
        this.ageRating = ageRating;
    }

    public void addMovie() {
        // Method để thêm phim vào database
        // Sẽ được implement trong DAO
    }
}
