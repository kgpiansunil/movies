package com.chi_square.movierating.data;

/**
 * Created by Rishank on 26-08-2017.
 */

public class MovieList {
    private String name;
    private float rating;
    private int id;
    private int year;
    private int imdb_id;
    private int thumbnail;

    public MovieList() {
    }

    public MovieList(int id, String name, float rating, int year, int imdb_id, int thumbnail) {
        this.name = name;
        this.id = id;
        this.rating = rating;
        this.year = year;
        this.imdb_id = imdb_id;
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getLink() {
        return imdb_id;
    }

    public void setLink(int imdb_id) {
        this.imdb_id = imdb_id;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}
