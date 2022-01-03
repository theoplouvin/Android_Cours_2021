package com.example.tp1.data;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tp1.DetailMovie;
import com.example.tp1.MainActivity;
import com.example.tp1.R;
import com.example.tp1.SearchMovie;
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
    private MovieAdapter.ReclyclerViewClickListener listener;

    public MovieLoad(MainActivity activity) {
        movieService = new Retrofit.Builder()
                .baseUrl(ApiService.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService.class);
        this.activity = activity;
        this.rvMovies = (RecyclerView) activity.findViewById(R.id.moviesRecyclerView);
    }

    public void popularData() {
        movieService.popularFilm("0bd82c8fbc70e6eae3f195e62d60a90a").enqueue(new Callback<ListMovies>() {
            @Override
            public void onResponse(@NonNull Call<ListMovies> call, @NonNull Response<ListMovies> response) {
                assert response.body() != null;
                List<Movie> allMovies = response.body().getFilmList();

                setOnClickListner(allMovies);
                MovieAdapter adapter = new MovieAdapter(allMovies, listener);
                rvMovies.setAdapter(adapter);
                rvMovies.setLayoutManager(new GridLayoutManager(activity.getApplicationContext(), 2));
            }

            @Override
            public void onFailure(@NonNull Call<ListMovies> call, @NonNull Throwable t) {
                Toast toast = Toast.makeText(activity, "onFailure ", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }

    public void upcomingData() {
        movieService.upcomingFilm("0bd82c8fbc70e6eae3f195e62d60a90a").enqueue(new Callback<ListMovies>() {
            @Override
            public void onResponse(@NonNull Call<ListMovies> call, @NonNull Response<ListMovies> response) {
                assert response.body() != null;
                List<Movie> allMovies = response.body().getFilmList();

                setOnClickListner(allMovies);
                MovieAdapter adapter = new MovieAdapter(allMovies, listener);
                rvMovies.setAdapter(adapter);
                rvMovies.setLayoutManager(new GridLayoutManager(activity.getApplicationContext(), 2));
            }

            @Override
            public void onFailure(@NonNull Call<ListMovies> call, @NonNull Throwable t) {
                Toast toast = Toast.makeText(activity, "onFailure ", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }

    public void searchMovies(String search) {
        movieService.searchMovies("0bd82c8fbc70e6eae3f195e62d60a90a", search).enqueue(new Callback<ListMovies>() {
            @Override
            public void onResponse(@NonNull Call<ListMovies> call, @NonNull Response<ListMovies> response) {
                assert response.body() != null;
                List<Movie> allMovies = response.body().getFilmList();

                if (allMovies.isEmpty()) {
                    Toast.makeText(activity, "Aucun résultat trouvé", Toast.LENGTH_LONG).show();

                }

                setOnClickListner(allMovies);
                MovieAdapter adapter = new MovieAdapter(allMovies, listener);
                rvMovies.setAdapter(adapter);
                rvMovies.setLayoutManager(new GridLayoutManager(activity.getApplicationContext(), 2));
            }

            @Override
            public void onFailure(@NonNull Call<ListMovies> call, @NonNull Throwable t) {
                Toast toast = Toast.makeText(activity, "onFailure ", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }

    private void setOnClickListner(List<Movie> allMovies) {
        listener = new MovieAdapter.ReclyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent intent = new Intent(activity.getApplicationContext(), DetailMovie.class);
                intent.putExtra("id", allMovies.get(position).getId());
                activity.startActivity(intent);
            }
        };
    }
}
