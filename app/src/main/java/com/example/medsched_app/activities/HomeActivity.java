package com.example.medsched_app.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.medsched_app.R;
import com.example.medsched_app.model.Patient;
import com.example.medsched_app.repo.MedSchedRepository;
import com.example.medsched_app.screen.ConsultListActivity;
import com.example.medsched_app.screen.PatientListActivity;

public class HomeActivity extends AppCompatActivity {
    private TextView welcomeText;
    private MedSchedRepository repository;
    Button openConsultsBtn, openPatientsBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        repository = new MedSchedRepository(this);

        welcomeText = findViewById(R.id.welcomeText);

        String role = getIntent().getStringExtra("userRole");
        String name = getIntent().getStringExtra("userName");

        openPatientsBtn = findViewById(R.id.openPatientsBtn);
        openConsultsBtn = findViewById(R.id.openConsultsBtn);

        welcomeText.setText("Bem-vindo,  " + role + " " + name + ".");


        openPatientsBtn.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, PatientListActivity.class);
            startActivity(intent);
        });

        openConsultsBtn.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, ConsultListActivity.class);
            startActivity(intent);
        });
    }
}

