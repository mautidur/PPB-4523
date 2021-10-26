package com.example.counterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView angkakounter;
    int angka=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        angkakounter = findViewById(R.id.kounter);
    }
    public void toastclick(View view) {
        Toast.makeText(this, "Lets Start POP!", Toast.LENGTH_LONG).show();
    }

    public void tblkounter(View view) {
        angka=angka+1;
        angkakounter.setText(Integer.toString(angka));
    }
}