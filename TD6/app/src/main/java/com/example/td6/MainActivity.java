package com.example.td6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

        Button button_search = (Button) findViewById(R.id.button);
        EditText input = (EditText) findViewById(R.id.input);
        TextView affichage_result = (TextView) findViewById(R.id.affichage_result);

        button_search.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                GithubService githubService = new Retrofit.Builder()
                        .baseUrl(GithubService.ENDPOINT)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                        .create(GithubService.class);

                githubService.searchRepos(input.getText().toString()).enqueue(new Callback<Repos>() {
                    @Override
                    public void onResponse(Call<Repos> call, Response<Repos> response) {
                        Toast toast = Toast.makeText(MainActivity.this, "Data from API ok", Toast.LENGTH_SHORT);
                        List<Repo> allRepo = response.body().getRepos();
                        StringBuilder str = new StringBuilder();
                        for (Repo repo : allRepo){
                            str.append(repo.getId()).append(", ").append(repo.getName()).append("\n");
                        }
                        affichage_result.setText(str.toString());
                    }

                    @Override
                    public void onFailure(Call<Repos> call, Throwable t) {
                        Toast toast = Toast.makeText(MainActivity.this, "onFailure ", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                });
            }
        });
    }

}