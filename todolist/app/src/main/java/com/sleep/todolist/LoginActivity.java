package com.sleep.todolist;

import static android.text.Html.fromHtml;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Space;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class LoginActivity extends AppCompatActivity {


    EditText txtuser, txtpass;
    Button btnlogin;
    DBhelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtuser =(EditText)findViewById(R.id.txtuser);
        txtpass =(EditText)findViewById(R.id.txtpass);
        btnlogin = (Button) findViewById(R.id.btnlogin);

        dbHelper = new DBhelper(this);

        TextView tvCreateAccount = (TextView) findViewById(R.id.tvCreateAccount);
        tvCreateAccount.setText(fromHtml("I dont have account yet "+
                "</font><font color='#3b5998'>create one</font>"));
        tvCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = txtuser.getText().toString().trim();
                String password = txtpass.getText().toString().trim();
                Boolean res = dbHelper.checkUser(username, password);
                if (res==true){
                    Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                }else{
                    Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    public static Spanned fromHtml(String html){
        Spanned result;
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
            result = Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY);
        }else{
            result= Html.fromHtml(html);
        }
        return result;
    }
}