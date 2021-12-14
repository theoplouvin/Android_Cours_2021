package com.example.tp1;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tp1.models.Movie;
import com.example.tp1.service.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetailMovie extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.detail_movie);

            RecyclerView rvMoviesDetails = (RecyclerView) findViewById(R.id.moviesRecyclerView);

            int movie_id = getIntent().getIntExtra("id", 0);

            ApiService movieService = new Retrofit.Builder()
                    .baseUrl(ApiService.ENDPOINT)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(ApiService.class);


            movieService.detailFilm( movie_id,"0bd82c8fbc70e6eae3f195e62d60a90a").enqueue(new Callback<Movie>() {
                @Override
                public void onResponse(Call<Movie> call, Response<Movie> response) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Data from API for Detail ok", Toast.LENGTH_SHORT);
                    toast.show();

                    Movie movie = response.body();

                    ImageView imageMovie = findViewById(R.id.imageMovieDetail);
                    Glide.with(getApplicationContext())
                            .load("https://image.tmdb.org/t/p/original/" + movie.getBackdrop_path())
                            .into(imageMovie);

                    TextView text = findViewById(R.id.descriptionDetail);
                    text.setText(movie.getOriginal_title());
                }

                @Override
                public void onFailure(Call<Movie> call, Throwable t) {
                    Toast toast = Toast.makeText(getApplicationContext(), "onFailure Api  ", Toast.LENGTH_SHORT);
                    toast.show();
                }
            });

        }
}
