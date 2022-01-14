package com.example.tp1.service;

import com.example.tp1.models.ListMovies;
import com.example.tp1.models.Movie;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    public static final String ENDPOINT = "https://api.themoviedb.org";

    @GET("/3/movie/popular")
    Call<ListMovies> popularFilm(@Query("api_key") String apiKey, @Query("language") String language, @Query("page") int page);

    @GET("/3/movie/{id}")
    Call<Movie> detailFilm(@Path("id") int id, @Query("api_key") String apiKey, @Query("language") String language);

    @GET("/3/movie/upcoming")
    Call<ListMovies> upcomingFilm(@Query("api_key") String apiKey, @Query("language") String language);

    @GET("/3/search/movie")
    Call<ListMovies> searchMovies(@Query("api_key") String apiKey, @Query("query") String query, @Query("language") String language);


}