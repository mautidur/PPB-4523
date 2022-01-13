package com.sleep.tugasakhir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sleep.tugasakhir.helper.Helper;

public class EditorActivity extends AppCompatActivity {

    private EditText editname, editharga, editjenis;
    private Button btnSave;
    private Helper db = new Helper(this);
    private String id, name, harga, jenis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);

        editname = findViewById(R.id.edit_name);
        editharga = findViewById(R.id.edit_harga);
        editjenis = findViewById(R.id.edit_jenis);
        btnSave = findViewById(R.id.btnsave);

        id = getIntent().getStringExtra("id");
        name = getIntent().getStringExtra("name");
        harga = getIntent().getStringExtra("harga");
        jenis = getIntent().getStringExtra("jenis");

        if (id==null || id.equals("")){
            setTitle("Tambah");
        }else{
            setTitle("Edit");
            editname.setText(name);
            editharga.setText(harga);
            editjenis.setText(jenis);
        }
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (id==null || id.equals("")){
                        save();
                    }else {
                        edit();
                    }
                }catch (Exception e){
                    Log.e("saving", e.getMessage());
                }
            }
        });
    }

    private void save(){
        if (String.valueOf(editname.getText()).equals("")||String.valueOf(editharga.getText()).equals("")||String.valueOf(editjenis.getText()).equals("")){
            Toast.makeText(getApplicationContext(), "Please fill the Data", Toast.LENGTH_SHORT).show();
        }else{
            db.insert(editname.getText().toString(), editharga.getText().toString(), editjenis.getText().toString());
            finish();
        }
    }

    private void edit(){
        if (String.valueOf(editname.getText()).equals("")||String.valueOf(editharga.getText()).equals("")||String.valueOf(editjenis.getText()).equals("")){
            Toast.makeText(getApplicationContext(), "Please fill the Data", Toast.LENGTH_SHORT).show();
        }else{
            db.update(Integer.parseInt(id),editname.getText().toString(), editharga.getText().toString(), editjenis.getText().toString());
            finish();
        }
    }
}