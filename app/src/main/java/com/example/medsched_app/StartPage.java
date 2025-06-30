package com.example.medsched_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.medsched_app.activities.LoginActivity;
import com.example.medsched_app.activities.RegisterActivity;

public class StartPage extends AppCompatActivity {

    TextView startTitle;
    ImageView medSchedIcon;
    Button loginBtn, registerBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.start_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.start_page), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        startTitle = findViewById(R.id.startTitle);
        medSchedIcon = findViewById(R.id.medsched_icon);
        loginBtn = findViewById(R.id.loginBtn);
        registerBtn = findViewById(R.id.registerBtn);
    }

    public void toLogin(View view) {
        Intent login = new Intent(this, LoginActivity.class);
        startActivity(login);
    }

    public void toRegister(View view) {
        Intent register = new Intent(this, RegisterActivity.class);
        startActivity(register);
    }
}