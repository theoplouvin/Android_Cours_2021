package com.example.tp.models;

public class Film {

    private String backdrop_path;
    private int id;
    private String original_title;
    private String overview;

    public Film(String backdrop_path, int id, String original_title, String overview, String imageUrl) {
        this.backdrop_path = backdrop_path;
        this.id = id;
        this.original_title = original_title;
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
