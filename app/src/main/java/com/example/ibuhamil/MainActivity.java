package com.example.ibuhamil;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    EditText UsernameEt, PasswordEt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UsernameEt = (EditText)findViewById(R.id.username);
        PasswordEt = (EditText)findViewById(R.id.password);

        ImageView dashboard = (ImageView) findViewById(R.id.button);

        dashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DashboardRelawan.class);
                startActivity(intent);
            }
        });
    }

    public void OnLogin(View view){
        String uname = UsernameEt.getText().toString();
        String pass = PasswordEt.getText().toString();
        String type = "login";
        LoginController loginController = new LoginController(this);
        loginController.execute(type, uname, pass);
    }


}