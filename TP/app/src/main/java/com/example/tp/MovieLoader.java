package com.example.tp;

import android.content.Intent;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tp.models.Film;
import com.example.tp.models.ListMovie;
import com.example.tp.service.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MovieLoader {

    private final PopularActivity activity;
    private ApiService theMovieService;
    private RecyclerView recycler;

    public MovieLoader(PopularActivity activity) {
        theMovieService = new Retrofit.Builder()
                .baseUrl(ApiService.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService.class);
        recycler = activity.findViewById(R.id.moviesRecyclerView);
        this.activity = activity;

        recycler.setLayoutManager(new GridLayoutManager(activity,2));
    }

    public void refresh(int activity, ActivityResultLauncher<Intent> callback){
        List<Film> listMovies = new ArrayList<Film>();

        switch (activity){
            case R.id.action_popular:

                theMovieService.popularFilm("0bd82c8fbc70e6eae3f195e62d60a90a").enqueue(new Callback<ListMovie>() {
                    @Override
                    public void onResponse(Call<ListMovie> call, Response<ListMovie> response) {
                        Toast toast = Toast.makeText(MovieLoader, "Appel API POPULAR OK ", Toast.LENGTH_SHORT);
                        toast.show();

                       listMovies.addAll(response.body().getFilmList());
                    }

                    @Override
                    public void onFailure(Call<ListMovie> call, Throwable t) {
                        Toast toast = Toast.makeText(MovieLoader.this, "Appel API POPULAR KO ", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                });
        }
    }




}
