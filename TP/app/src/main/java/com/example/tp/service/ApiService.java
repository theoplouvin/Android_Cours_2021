package com.example.tp.service;

import com.example.tp.models.ListMovie;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    //0bd82c8fbc70e6eae3f195e62d60a90a
     public static final String ENDPOINT = "https://api.themoviedb.org";

    @GET("/3/movie/popular")
    Call<ListMovie> popularFilm(@Query("api_key") String apiKey);
}
