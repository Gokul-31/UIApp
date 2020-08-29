package com.example.uiapp;

public class SpecificMovie {

    int imageId;
    int name;
    int genre;
    int desc;
    int rating;

    public SpecificMovie(int imageId, int name, int genre, int desc, int rating) {
        this.imageId = imageId;
        this.name = name;
        this.genre = genre;
        this.desc = desc;
        this.rating = rating;
    }

    public int getImageId() {
        return imageId;
    }

    public int getName() {
        return name;
    }

    public int getGenre() {
        return genre;
    }

    public int getDesc() {
        return desc;
    }

    public int getRating() {
        return rating;
    }
}
