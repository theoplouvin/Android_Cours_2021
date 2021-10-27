package com.example.td2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "Salut";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.meteo);

       /* Integer v = 54;
        Integer n = v / 9 - 2;
        Log.i(TAG, "n ="+n);
        int f= factorielle(n);
        Log.i(TAG, n.toString()+"! ="+f);*/

        Spinner staticSpinner = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> staticAdapter = ArrayAdapter.createFromResource(this, R.array.temps_choose,
                        android.R.layout.simple_spinner_item);

        staticAdapter .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        staticSpinner.setAdapter(staticAdapter);
    }

    private int factorielle(int n){
        int r;
        if(n>1){
            int fnm1 = factorielle(n-1);
            r=n*fnm1;
        }else{
            r=1;
        }
        return r;
    }

}