package com.example.tp1.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListMovies {

    @SerializedName("results")
    public List<Movie> filmList;

    public ListMovies(List<Movie> filmList) {
        this.filmList = filmList;
    }

    public List<Movie> getFilmList() {
        return filmList;
    }

    public void setFilmList(List<Movie> filmList) {
        this.filmList = filmList;
    }
}
