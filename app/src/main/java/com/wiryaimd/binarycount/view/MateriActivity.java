package com.wiryaimd.binarycount.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.wiryaimd.binarycount.R;
import com.wiryaimd.binarycount.fragment.BinerFragment;
import com.wiryaimd.binarycount.fragment.DesimalFragment;
import com.wiryaimd.binarycount.fragment.HeksadesimalFragment;
import com.wiryaimd.binarycount.fragment.OktalFragment;

public class MateriActivity extends AppCompatActivity {

    private Button btndesimal, btnbiner, btnoktal, btnhex;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materi);

        btndesimal = findViewById(R.id.materi_btndesimal);
        btnbiner = findViewById(R.id.materi_btnbiner);
        btnoktal = findViewById(R.id.materi_btnoktal);
        btnhex = findViewById(R.id.materi_btnheksadesimal);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction().replace(R.id.materi_mainframe, new DesimalFragment(MateriActivity.this));
        ft.commit();

        btndesimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction().replace(R.id.materi_mainframe, new DesimalFragment(MateriActivity.this));
                ft.commit();
            }
        });

        btnbiner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction().replace(R.id.materi_mainframe, new BinerFragment(MateriActivity.this));
                ft.commit();
            }
        });

        btnoktal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction().replace(R.id.materi_mainframe, new OktalFragment());
                ft.commit();
            }
        });

        btnhex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction().replace(R.id.materi_mainframe, new HeksadesimalFragment());
                ft.commit();
            }
        });


    }
}
