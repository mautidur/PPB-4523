package com.example.mylist;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name, stud, eps, seas;
    Button add, edit, del, view;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        stud = findViewById(R.id.stud);
        eps = findViewById(R.id.eps);
        seas = findViewById(R.id.seas);

        add = findViewById(R.id.btnadd);
        edit = findViewById(R.id.btnedit);
        del = findViewById(R.id.btndel);
        view = findViewById(R.id.btnview);
        DB = new DBHelper(this);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = name.getText().toString();
                String studTXT = stud.getText().toString();
                String epsTXT = eps.getText().toString();
                String seasTXT = seas.getText().toString();

                Boolean checkinsertdata = DB.insertuserdata(nameTXT, studTXT, epsTXT, seasTXT);
                if(checkinsertdata==true)
                    Toast.makeText(MainActivity.this, "new entry inserted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "new entry not inserted", Toast.LENGTH_SHORT).show();
            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = name.getText().toString();
                String studTXT = stud.getText().toString();
                String epsTXT = eps.getText().toString();
                String seasTXT = seas.getText().toString();

                Boolean checkupdatedata = DB.updateuserdata(nameTXT, studTXT, epsTXT, seasTXT);
                if(checkupdatedata==true)
                    Toast.makeText(MainActivity.this, "entry updated", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "new entry not updated", Toast.LENGTH_SHORT).show();
            }
        });

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameTXT = name.getText().toString();

                Boolean checkupdatedata = DB.deletedata(nameTXT);
                if(checkupdatedata==true)
                    Toast.makeText(MainActivity.this, "entry deleted", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "entry not deleted", Toast.LENGTH_SHORT).show();
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = DB.getdata();
                if(res.getCount()==0){
                    Toast.makeText(MainActivity.this, "no entry exist", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()){
                    buffer.append("Name :"+res.getString(0)+"\n");
                    buffer.append("Studio :"+res.getString(1)+"\n");
                    buffer.append("Episode :"+res.getString(2)+"\n\n");
                    buffer.append("Season :"+res.getString(3)+"\n");
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setCancelable(true);
                builder.setTitle("User Entries");
                builder.setMessage(buffer.toString());
                builder.show();
            }
        });
    }
}