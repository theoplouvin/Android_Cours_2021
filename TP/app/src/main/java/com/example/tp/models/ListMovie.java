package com.example.tp.models;

import com.example.tp.models.Film;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListMovie {

    @SerializedName("results")
    public List<Film> filmList;

    public ListMovie(List<Film> filmList) {
        this.filmList = filmList;
    }

    public List<Film> getFilmList() {
        return filmList;
    }

    public void setFilmList(List<Film> filmList) {
        this.filmList = filmList;
    }
}
