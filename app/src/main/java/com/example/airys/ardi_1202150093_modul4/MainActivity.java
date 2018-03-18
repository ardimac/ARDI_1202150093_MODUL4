package com.example.airys.ardi_1202150093_modul4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnList(View view) {
        Intent i = new Intent(MainActivity.this, List.class);
        startActivity(i);
    }

    public void btnCari(View view) {
        Intent j = new Intent(MainActivity.this, Cari.class);
        startActivity(j);
    }
}
