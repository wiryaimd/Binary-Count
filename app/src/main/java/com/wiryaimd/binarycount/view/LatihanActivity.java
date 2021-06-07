package com.wiryaimd.binarycount.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.wiryaimd.binarycount.R;
import com.wiryaimd.binarycount.util.CountHelper;

import java.util.Random;

public class LatihanActivity extends AppCompatActivity {

    private TextView tvf, tvto;
    private EditText edtf, edtto;
    private Button btncek, btngen;
    private LinearLayout lbenar;

    private String[] list = {"Biner", "Oktal", "Desimal", "Heksadesimal"};
    private int[] radiks = {2, 8, 10, 16};

    private Random random;
    private int radiksf, radikst, val;
    private String sf, st;

    private String result;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_latihan);

        random = new Random();

        tvf = findViewById(R.id.latihan_f);
        tvto = findViewById(R.id.latihan_s);
        edtf = findViewById(R.id.latihan_edts);
        edtto = findViewById(R.id.latihan_jawaban);
        btncek = findViewById(R.id.latihan_btncek);
        btngen = findViewById(R.id.latihan_btngenerate_soalbaru);
        lbenar = findViewById(R.id.latihan_linear1);

        genVal();
        tvf.setText(sf);
        tvto.setText(st);

        if (radiksf != 10){
            String str = CountHelper.fromDecimal(val, radiksf);
            edtf.setText(str);
        }else{
            edtf.setText(String.valueOf(val));
        }

        btncek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!edtto.getText().toString().isEmpty()) {
                    if (edtto.getText().toString().equalsIgnoreCase(result)) {
                        Toast.makeText(LatihanActivity.this, "Jawaban Benar!", Toast.LENGTH_SHORT).show();
                        lbenar.setVisibility(View.VISIBLE);
                    } else {
                        Toast.makeText(LatihanActivity.this, "Jawaban Salah!", Toast.LENGTH_SHORT).show();
                        lbenar.setVisibility(View.GONE);
                    }
                }
            }
        });

        btngen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                genVal();
                tvf.setText(sf);
                tvto.setText(st);
                if (radiksf != 10){
                    String str = CountHelper.fromDecimal(val, radiksf);
                    edtf.setText(str);
                }else{
                    edtf.setText(String.valueOf(val));
                }
                edtto.setText("");
            }
        });

    }

    public void genVal(){
        lbenar.setVisibility(View.GONE);
        val = random.nextInt(250) + 50;
        do {
            int rf = random.nextInt(4);
            int rt = random.nextInt(4);
            radiksf = radiks[rf];
            radikst = radiks[rt];
            sf = list[rf];
            st = list[rt];
        }while (radiksf == radikst);

        if (radikst != 10){
            result = CountHelper.fromDecimal(val, radikst);
        }else{
            result = String.valueOf(val);
        }
    }
}
