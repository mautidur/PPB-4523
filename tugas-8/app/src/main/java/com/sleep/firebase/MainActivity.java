package com.sleep.firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    EditText nimsiswa,namasiswa;
    Button btsave, btview;
    DatabaseReference reference;
    FirebaseDatabase rootNode;
    Mahasiswa mahasiswa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nimsiswa=findViewById(R.id.nimmhs);
        namasiswa=findViewById(R.id.nmmhs);
        btsave=findViewById(R.id.tblsave);
        //btview=findViewById(R.id.tblview);
        mahasiswa=new Mahasiswa();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World!");

        /*reference= FirebaseDatabase.getInstance().getReference().child("siswa");

        btsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mahasiswa.setNim(nimsiswa.getText().toString().trim());
                mahasiswa.setNama(namasiswa.getText().toString().trim());
                reference.push().setValue(mahasiswa);
                Toast.makeText(MainActivity.this, "Data Saved", Toast.LENGTH_SHORT).show();
            }
        });*/


    }
}