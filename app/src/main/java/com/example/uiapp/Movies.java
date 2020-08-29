package com.example.uiapp;

import java.io.Serializable;

public class Movies implements Serializable {

    int imageId;
    int name;
    int genre;
    int desc;
    int rating;

    int img2Id=0;
    int img3Id=0;

    public int getImg2Id() {
        return img2Id;
    }

    public int getImg3Id() {
        return img3Id;
    }

    public Movies(int imageId, int name, int genre, int desc, int rating) {
        this.imageId = imageId;
        this.name = name;
        this.genre = genre;
        this.desc = desc;
        this.rating = rating;
    }

    public Movies(int imageId, int name, int genre, int desc, int rating, int img2Id, int img3Id) {
        this.imageId = imageId;
        this.name = name;
        this.genre = genre;
        this.desc = desc;
        this.rating = rating;
        this.img2Id = img2Id;
        this.img3Id = img3Id;
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
