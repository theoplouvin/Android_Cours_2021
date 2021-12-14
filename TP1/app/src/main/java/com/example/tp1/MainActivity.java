package com.example.tp1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tp1.adapter.MovieAdapter;
import com.example.tp1.data.MovieLoad;
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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        MovieLoad data = new MovieLoad(this);
        data.popularData();

        //MovieAdapter adapter = new MovieAdapter();
       // rvMovies.setAdapter(adapter);
       // rvMovies.setLayoutManager(new GridLayoutManager(this,2));

    }






}