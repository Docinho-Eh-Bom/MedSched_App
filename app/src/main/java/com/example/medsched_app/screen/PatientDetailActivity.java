package com.example.medsched_app.screen;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.medsched_app.R;

public class PatientDetailActivity extends AppCompatActivity {
    TextView name, cpf, cellphone;
    ImageView icon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_detail);

        icon = findViewById(R.id.imageView);
        name = findViewById(R.id.name_Detail);
        cpf = findViewById(R.id.cpf_Detail);
        cellphone = findViewById(R.id.cellphone_Detail);

        Intent intent = getIntent();
        icon.setImageResource(R.drawable.joao);
        name.setText("Nome: " + intent.getStringExtra("name"));
        cpf.setText("CPF: " + intent.getStringExtra("cpf"));
        cellphone.setText("Telefone: " + intent.getStringExtra("cellphone"));
    }

}