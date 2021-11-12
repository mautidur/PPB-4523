package com.example.menumakan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    String s1[], s2[], s3[];
    int images[]={R.drawable.baksobasic,R.drawable.baksokering,R.drawable.baksobakar,R.drawable.baksoikan,R.drawable.baksoisi,
            R.drawable.baksotelor,R.drawable.baksomercon};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.RecycleView);

        s1 = getResources().getStringArray(R.array.namamenu);
        s2 = getResources().getStringArray(R.array.descmenu);
        s3 = getResources().getStringArray(R.array.hargamenu);

        MyAdapter myAdapter = new MyAdapter(this, s1, s2, s3, images);
        recyclerView.setAdapter((myAdapter));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}