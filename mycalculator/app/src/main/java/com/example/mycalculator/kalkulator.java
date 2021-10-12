package com.example.mycalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class kalkulator extends AppCompatActivity {
    EditText angk1, angk2;
    TextView hasilnya;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        angk1 = (EditText) findViewById(R.id.angka1);
        angk2 = (EditText) findViewById(R.id.angka2);
        hasilnya = (TextView) findViewById(R.id.haslhitung);
    }

    public void tambah(View view) {
        int a1 = Integer.parseInt(angk1.getText().toString());
        int a2 = Integer.parseInt(angk2.getText().toString());
        Integer hasil = a1 + a2;
        hasilnya.setText(hasil.toString());
    }

    public void kurang(View view) {
        int a1 = Integer.parseInt(angk1.getText().toString());
        int a2 = Integer.parseInt(angk2.getText().toString());
        Integer hasil = a1 - a2;
        hasilnya.setText(hasil.toString());
    }
}
