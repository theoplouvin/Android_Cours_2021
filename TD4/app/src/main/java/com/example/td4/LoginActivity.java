package com.example.td4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity {

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(getLocalClassName());
        setContentView(R.layout.activity_login);

        String ID_DEFAULT = "admin";
        String MDP_DEFAULT = "admin";

        TextView textViewId = (TextView) findViewById(R.id.text_title_id);
        EditText editTextId = (EditText) findViewById(R.id.text_id);
        EditText editTextMdp = (EditText) findViewById(R.id.text_mdp);

        Button button_valid = (Button) findViewById(R.id.button_valid);

        Intent news_activity = new Intent(this, NewsActivity.class);
        Intent intent = new Intent(this, NewsActivity.class);

        button_valid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //intent.putExtra("login", editTextId.getText().toString());
                //startActivity(intent);

                NewsListApplication app = (NewsListApplication) getApplicationContext();
                app.setLogin(editTextId.getText().toString());

                if(String.valueOf(editTextId.getText()).equals(ID_DEFAULT) && String.valueOf(editTextMdp.getText()).equals(MDP_DEFAULT)) {
                    startActivity(news_activity);

                } else {
                    Toast toast = Toast.makeText(LoginActivity.this, "ID ou MDP incorrect", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }


        });
    }




}