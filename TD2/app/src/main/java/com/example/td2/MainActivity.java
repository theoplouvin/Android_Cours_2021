package com.example.td2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "Salut";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.repas);

        Integer v = 54;
        Integer n = v / 9 - 2;
        Log.i(TAG, "n ="+n);
        int f= factorielle(n);
        Log.i(TAG, n.toString()+"! ="+f);
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