package com.sleep.todolist;

import static com.sleep.todolist.LoginActivity.fromHtml;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {


    EditText txtuser, txtpass, txtconpass;
    Button btnregister;
    DBhelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        dbHelper = new DBhelper(this);
        txtuser= (EditText) findViewById(R.id.UsernameReg);
        txtpass = (EditText) findViewById(R.id.txtPassReg);
        txtconpass = (EditText) findViewById(R.id.txtConPass);
        btnregister = (Button) findViewById(R.id.btnregister);

        TextView tvRegister = (TextView) findViewById(R.id.tvRegister);

        tvRegister.setText(fromHtml("Back to " +
                "</font><font color='#3b5998'>Login</font>"));
        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });
        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = txtuser.getText().toString().trim();
                String password = txtpass.getText().toString().trim();
                String conpassword = txtconpass.getText().toString().trim();

                ContentValues values = new ContentValues();

                if (!password.equals(conpassword)){
                    Toast.makeText(RegisterActivity.this, "Password not match", Toast.LENGTH_SHORT).show();
                }else if (password.equals("")||username.equals("")){
                    Toast.makeText(RegisterActivity.this, "Username or password cannot be empty", Toast.LENGTH_SHORT).show();
                }else {
                    values.put(DBhelper.row_username, username);
                    values.put(DBhelper.row_password, password);
                    dbHelper.insertData(values);

                    Toast.makeText(RegisterActivity.this, "Register successful", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
    }

    public static Spanned fromHtml(String html){
        Spanned result;
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.N){
            result = Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY);
        }else {
            result = Html.fromHtml(html);
        }
        return result;
    }
}