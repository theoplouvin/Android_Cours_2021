package com.example.tp1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        RadioButton RadioButton = (RadioButton) findViewById(R.id.radioButton1);
        RadioButton RadioButton2 = (RadioButton) findViewById(R.id.radioButton2);
        Button buttonSetting = findViewById(R.id.saveButton);
        Intent main_activity = new Intent(this, MainActivity.class);

        buttonSetting.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View view) {
                                                    if (RadioButton.isChecked()) {
                                                        main_activity.putExtra("result", "EN");
                                                        setResult(Activity.RESULT_OK, main_activity);
                                                        finish();
                                                    } else if (RadioButton2.isChecked()){
                                                        main_activity.putExtra("result", "FR");
                                                        setResult(Activity.RESULT_OK, main_activity);
                                                        finish();
                                                    }
                                            }
                                        }
        );

    }
}
