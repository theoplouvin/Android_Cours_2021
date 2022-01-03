package com.example.tp1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tp1.data.MovieLoad;

public class SearchMovie extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        EditText choice = findViewById(R.id.choiceMovie);
        Button buttonSearch = findViewById(R.id.searchButton);
        Intent main_activity = new Intent(this, MainActivity.class);

        buttonSearch.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        if (choice == null) {
                            Toast toast = Toast.makeText(SearchMovie.this, "Empty Fields, retry !", Toast.LENGTH_SHORT);
                            toast.show();
                        } else {
                            main_activity.putExtra("result", choice.getText().toString());
                            setResult(Activity.RESULT_OK, main_activity);
                            finish();
                        }
                    }
                }
        );

    }
}
