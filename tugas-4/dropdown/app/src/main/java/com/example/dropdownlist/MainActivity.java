package com.example.dropdownlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import java.security.PublicKey;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    public String game[]={"Mobile Legend","Arena of Valor","Free Fire","PUBG","Clash of Clan","Minecraft","COD Mobile","Genshin Impact","Honkai Impact 3rd"};

    Spinner combo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView=(ListView) findViewById(R.id.listdata);
        combo=(Spinner) findViewById(R.id.combodata);

        ArrayAdapter adapter=new ArrayAdapter(MainActivity.this, R.layout.support_simple_spinner_dropdown_item,game);
        listView.setAdapter(adapter);
        combo.setAdapter(adapter);
    }
}