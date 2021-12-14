package com.example.tp1.models;

public class Movie {

    private int id;
    private String original_title;
    private String backdrop_path;
    private String overview;

    public Movie(int id, String original_title, String backdrop_path, String overview) {
        this.id = id;
        this.original_title = original_title;
        this.backdrop_path = backdrop_path;
        this.overview = overview;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }
}
