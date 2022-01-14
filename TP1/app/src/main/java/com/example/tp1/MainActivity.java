package com.example.tp1;


import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.GridView;

import com.example.tp1.data.MovieLoad;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MovieLoad movieLoad = new MovieLoad(this);
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        final String[] language = {"EN"};
        movieLoad.popularData(1);

        ActivityResultLauncher<Intent> someActivityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK) {
                            Intent data = result.getData();
                            assert data != null;
                                String choiceText = data.getStringExtra("result");
                                if (choiceText != null) {
                                    movieLoad.searchMovies(choiceText);
                                }
                        }
                    }
                });

        ActivityResultLauncher<Intent> someActivityResultLauncher2 = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK) {
                            Intent data = result.getData();
                            assert data != null;
                            String choiceText = data.getStringExtra("result");
                            if (choiceText != null) {
                                language[0] = choiceText;
                                movieLoad.setLanguage(language[0]);
                                setTitle("Popular Movies");
                                bottomNav.setSelectedItemId(R.id.action_popular);
                            }
                        }
                    }
                });


        bottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case (R.id.action_popular):
                        setTitle("Popular Movies");
                        movieLoad.popularData(1);
                        break;
                    case (R.id.action_upcoming):
                        setTitle("Upcoming Movies");
                        movieLoad.upcomingData();
                        break;
                    case (R.id.action_search):
                        setTitle("Search Movies");
                        someActivityResultLauncher.launch(new Intent(MainActivity.this, SearchMovie.class));
                        break;
                    case (R.id.action_setting):
                        setTitle("Settings");
                        someActivityResultLauncher2.launch(new Intent(MainActivity.this, SettingsActivity.class));
                }
                return true;
            }
        });
    }


}