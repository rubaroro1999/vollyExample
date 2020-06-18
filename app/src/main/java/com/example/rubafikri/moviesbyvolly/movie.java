package com.example.rubafikri.moviesbyvolly;

import java.util.List;

public class movie {
    private String title;
    private String image;
    private String rating;
    private int releasd;
    private List<String> genre;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getReleasd() {
        return releasd;
    }

    public void setReleasd(int releasd) {
        this.releasd = releasd;
    }

    public List<String> getGenre() {
        return genre;
    }

    public void setGenre(List<String> genre) {
        this.genre = genre;
    }
}
