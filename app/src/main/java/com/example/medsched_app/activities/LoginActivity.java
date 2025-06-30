package com.example.medsched_app.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.medsched_app.R;
import com.example.medsched_app.repo.MedSchedRepository;
import com.example.medsched_app.req_res.LoginResponse;

public class LoginActivity extends AppCompatActivity {
    private EditText email_input, password_input;
    private Button loginBtn;
    private MedSchedRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        repository = new MedSchedRepository(this);

        email_input = findViewById(R.id.email_input);
        password_input = findViewById(R.id.password_input);
        loginBtn = findViewById(R.id.loginBtn);


        loginBtn.setOnClickListener(v -> {
            String email = email_input.getText().toString();
            String password = password_input.getText().toString();

            //Simulando login
            //new Thread(() -> {
                //LoginResponse response = repository.login(email, password);
                //runOnUiThread(() -> {
                //    if (response != null) {
                //        Intent intent = new Intent(this, HomeActivity.class);
                //        intent.putExtra("userRole", response.role);
                //        intent.putExtra("userEmail", response.email);
                //        startActivity(intent);
                //        finish();
                //    } else {
                //        Toast.makeText(this, "Invalid login", Toast.LENGTH_SHORT).show();
                //    }
                //});
        //}).start();
            String mockRole = email.contains("medic") ? "medic" : "patient";
            String nomeEmail = email.split("@")[0];
            String name = "";
            if (nomeEmail.startsWith("medic")) {
                name = nomeEmail.substring("medic".length());
            } else if (nomeEmail.startsWith("patient")) {
                name = nomeEmail.substring("patient".length());
            }
            if (email.equals("medicCarlos@gmail.com") && password.equals("123")) {
                Intent intent = new Intent(this, HomeActivity.class);
                intent.putExtra("userRole", mockRole);
                intent.putExtra("userName", name);
                startActivity(intent);
                finish();
            } else if (email.equals("patientAlberto@gmail.com") && password.equals("123")) {
                Intent intent = new Intent(this, HomeActivity.class);
                intent.putExtra("userRole", mockRole);
                intent.putExtra("userName", name);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(this, "Usuário inválido (simulado)", Toast.LENGTH_SHORT).show();
                return;
            }


        });

    }
}
