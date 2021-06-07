package com.wiryaimd.binarycount;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.wiryaimd.binarycount.view.KonversiActivity;
import com.wiryaimd.binarycount.view.LatihanActivity;
import com.wiryaimd.binarycount.view.MateriActivity;
import com.wiryaimd.binarycount.view.ProfilActivity;

public class MainActivity extends AppCompatActivity {

    private LinearLayout lmateri, llatihan, lkonversi, lprofil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lmateri = findViewById(R.id.main_materi);
        llatihan = findViewById(R.id.main_latihan);
        lkonversi = findViewById(R.id.main_konversi);
        lprofil = findViewById(R.id.main_about);

        lmateri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MateriActivity.class));
            }
        });

        llatihan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LatihanActivity.class));
            }
        });

        lkonversi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, KonversiActivity.class));
            }
        });

        lprofil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ProfilActivity.class));
            }
        });

    }
}
