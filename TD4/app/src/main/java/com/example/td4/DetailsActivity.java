package com.example.td4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DetailsActivity extends AppCompatActivity {

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(getLocalClassName());
        setContentView(R.layout.activity_details);

        Button button_back = (Button) findViewById(R.id.button_back);
        Button button_ok = (Button) findViewById(R.id.button_ok);

        Intent news_activity = new Intent(this, NewsActivity.class);

        button_ok.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startActivity(news_activity);
            }
        });

        button_back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }
}