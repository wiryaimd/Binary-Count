package com.wiryaimd.binarycount.view;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.wiryaimd.binarycount.R;
import com.wiryaimd.binarycount.util.CountHelper;

public class KonversiActivity extends AppCompatActivity {

    private EditText edtin;
    private Button btnconvert;
    private TextView tvoutput;

    private Spinner spinfrom, spinto;
    private String[] list = {"Biner", "Oktal", "Desimal", "Heksadesimal"};
    private int[] radiks = {2, 8, 10, 16};

    private int radiksf = 0, radiksto = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konversi);

        edtin = findViewById(R.id.konversi_in);
        btnconvert = findViewById(R.id.konversi_convert);
        tvoutput = findViewById(R.id.konversi_output);
        spinfrom = findViewById(R.id.konversi_from);
        spinto = findViewById(R.id.konversi_to);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(KonversiActivity.this, R.layout.item_mspinner, R.id.itemspin_text, list);
        spinfrom.setAdapter(adapter);
        spinto.setAdapter(adapter);

        spinfrom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                radiksf = radiks[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinto.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                radiksto = radiks[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnconvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (CountHelper.validasi(edtin.getText().toString(), radiksf)) {
                    if (radiksf != radiksto) {
                        if (radiksf != 10) {
                            int val = CountHelper.toDecimal(edtin.getText().toString(), radiksf);
                            String out = "Output: " + CountHelper.fromDecimal(val, radiksto);
                            tvoutput.setText(out);
                        } else {
                            try {
                                String out = "Output: " + CountHelper.fromDecimal(Integer.parseInt(edtin.getText().toString()), radiksto);
                                tvoutput.setText(out);
                            } catch (NumberFormatException e) {
                                Toast.makeText(KonversiActivity.this, "Desimal tidak bisa berisi angka", Toast.LENGTH_LONG).show();
                            }
                        }
                    } else {
                        Toast.makeText(KonversiActivity.this, "Bilangan yang ingin di konversi tidak boleh sama", Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(KonversiActivity.this, "Bilangan tidak valid, silahkan cek kembali", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

}
