package com.example.td4;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NewsActivity extends AppCompatActivity {

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(getLocalClassName());
        setContentView(R.layout.activity_news);

        Button button_back = (Button) findViewById(R.id.button_back);
        Button button_detail = (Button) findViewById(R.id.button_detail);
        Button button_about = (Button) findViewById(R.id.button_about);

        TextView textforcompte = (TextView) findViewById(R.id.textforcompte);

        Intent news_activity = new Intent(this, DetailsActivity.class);

        /*Intent intent = getIntent();
        String login = null;
        if (intent.hasExtra("login")) {
            login = intent.getStringExtra("login");
        }
        textforcompte.setText(login);
        */

        NewsListApplication app = (NewsListApplication) getApplicationContext();
        String login = app.getLogin();
        textforcompte.setText(login);

        button_detail.setOnClickListener(new View.OnClickListener(){
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

        button_about.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String url = "https://news.google.com/";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });
    }
}
