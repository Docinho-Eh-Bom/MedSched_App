package com.example.medsched_app.screen;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.medsched_app.R;

public class ConsultDetailActivity extends AppCompatActivity {
    TextView dateText, patientText, medicText, statusText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consult_detail);

        dateText = findViewById(R.id.date_Detail);
        patientText = findViewById(R.id.patient_Detail);
        medicText = findViewById(R.id.medic_Detail);
        statusText = findViewById(R.id.status_Detail);

        Intent intent = getIntent();
        dateText.setText("Data: " + intent.getStringExtra("consult_Date"));
        patientText.setText("Paciente: " + intent.getStringExtra("consult_Patient"));
        medicText.setText("Médico: " + intent.getStringExtra("consult_Medic"));
        statusText.setText("Status: " + intent.getStringExtra("consult_Status"));


    }
}

