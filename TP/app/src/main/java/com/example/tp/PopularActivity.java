package com.example.tp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.tp.adapter.FilmAdapter;
import com.example.tp.models.Film;
import com.example.tp.models.ListMovie;
import com.example.tp.service.ApiService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PopularActivity extends AppCompatActivity {

    private int activityId = R.id.action_popular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Film> listFilm = new ArrayList<>();

        ApiService theMovieService = new Retrofit.Builder()
                .baseUrl(ApiService.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService.class);

        RecyclerView recycler = this.findViewById(R.id.moviesRecyclerView);

        recycler.setLayoutManager(new GridLayoutManager(this,2));

            theMovieService.popularFilm("0bd82c8fbc70e6eae3f195e62d60a90a").enqueue(new Callback<ListMovie>() {
                @Override
                public void onResponse(Call<ListMovie> call, Response<ListMovie> response) {
                    Toast toast = Toast.makeText(PopularActivity.this, "Appel API OK ", Toast.LENGTH_SHORT);
                    toast.show();

                    listFilm.addAll(response.body().getFilmList());

                }

                @Override
                public void onFailure(Call<ListMovie> call, Throwable t) {
                    Toast toast = Toast.makeText(PopularActivity.this, "Appel API KO ", Toast.LENGTH_SHORT);
                    toast.show();
                }
            });

        RecyclerView rvFilm = (RecyclerView) findViewById(R.id.moviesRecyclerView);

        FilmAdapter adapter = new FilmAdapter(listFilm);
        rvFilm.setAdapter(adapter);
        rvFilm.setLayoutManager(new LinearLayoutManager(this));

    }
}
