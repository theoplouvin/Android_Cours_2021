package com.example.tp1.data;

import android.widget.Toast;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tp1.MainActivity;
import com.example.tp1.R;
import com.example.tp1.adapter.MovieAdapter;
import com.example.tp1.models.ListMovies;
import com.example.tp1.models.Movie;
import com.example.tp1.service.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieLoad {

    private ApiService movieService;
    private MainActivity activity;
    private RecyclerView rvMovies;

    public MovieLoad(MainActivity activity) {
        movieService = new Retrofit.Builder()
                .baseUrl(ApiService.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService.class);
        this.activity = activity;
        this.rvMovies = (RecyclerView) activity.findViewById(R.id.moviesRecyclerView);
    }

    public void popularData(){
        movieService.popularFilm("0bd82c8fbc70e6eae3f195e62d60a90a").enqueue(new Callback<ListMovies>() {
            @Override
            public void onResponse(Call<ListMovies> call, Response<ListMovies> response) {
                List<Movie> allMovies = response.body().getFilmList();
                Toast toast = Toast.makeText(activity, "Data from API ok", Toast.LENGTH_SHORT);
                toast.show();

                MovieAdapter adapter = new MovieAdapter(allMovies);
                rvMovies.setAdapter(adapter);
                rvMovies.setLayoutManager(new GridLayoutManager(activity.getApplicationContext(), 2));
            }

            @Override
            public void onFailure(Call<ListMovies> call, Throwable t) {
                Toast toast = Toast.makeText(activity, "onFailure ", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
}
