package com.example.menumakan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    ImageView mainImageView;
    TextView title, decs, price;
    Button btorder;

    String data1, data2, data3;
    int myImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mainImageView = findViewById(R.id.mainImageView);
        title = findViewById(R.id.title);
        decs = findViewById(R.id.desc);
        price = findViewById(R.id.price);
        btorder =findViewById(R.id.btnorder);

        getData();
        setData();

        btorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SecondActivity.this, "Belom dibikin kak", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getData() {
        if (getIntent().hasExtra("myImage") && getIntent().hasExtra("data1") && getIntent().hasExtra("data2") && getIntent().hasExtra("data3")) {
            data1 = getIntent().getStringExtra("data1");
            data2 = getIntent().getStringExtra("data2");
            data3 = getIntent().getStringExtra("data3");
            myImage = getIntent().getIntExtra("myImage", 1);
        } else {
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }
    }

    private void setData() {
        title.setText(data1);
        decs.setText(data2);
        price.setText(data3);
        mainImageView.setImageResource(myImage);
    }

}