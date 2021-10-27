package com.example.td3_dice_roller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button rollButton = (Button) findViewById(R.id.button);
        TextView text = (TextView) findViewById(R.id.text);
        TextView text2 = (TextView) findViewById(R.id.text2);

        EditText editText = (EditText) findViewById(R.id.editText);
        Button valid =(Button) findViewById(R.id.button_valid);

        final String[] NbFace = {"6"};

        valid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                NbFace[0] = editText.getText().toString();

                Toast toast = Toast.makeText(MainActivity.this, "Setup face ok, value : " + NbFace[0], Toast.LENGTH_SHORT);
                toast.show();
            }
        });


        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(MainActivity.this, "Dé lancé!", Toast.LENGTH_SHORT);
                toast.show();

                //set le TextView
                text.setText((alea(Integer.parseInt(NbFace[0]))));
                text2.setText((alea(Integer.parseInt(NbFace[0]))));

            }
        });

    }

    //retourne un string d'un nombre aleatoire entre 0 et n
    private String alea(int n){
        Random random = new Random();
        return String.valueOf(random.nextInt(n));
    }
}