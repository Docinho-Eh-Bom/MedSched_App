package com.example.medsched_app.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.medsched_app.R;
import com.example.medsched_app.screen.RegisterMedicFragment;
import com.example.medsched_app.screen.RegisterPatientFragment;
import com.example.medsched_app.repo.MedSchedRepository;
import com.example.medsched_app.req_res.RegisterRequest;
import com.example.medsched_app.req_res.RegisterResponse;

public class RegisterActivity extends AppCompatActivity {
    private EditText email_input, password_input, firstName_input, lastName_input;
    private Button registerBtn;
    private MedSchedRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        repository = new MedSchedRepository(this);

        firstName_input = findViewById(R.id.firstName_input);
        lastName_input = findViewById(R.id.lastName_input);
        email_input = findViewById(R.id.email_input);
        password_input = findViewById(R.id.password_input);
        registerBtn = findViewById(R.id.registerBtn);

        Spinner roleSpinner = findViewById(R.id.roleSpinner);

        roleSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Fragment selectedFragment;
                if (position == 0) {
                    selectedFragment = new RegisterPatientFragment();
                } else {
                    selectedFragment = new RegisterMedicFragment();
                }

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.roleFieldsContainer, selectedFragment)
                        .commit();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.roleFieldsContainer);

        registerBtn.setOnClickListener(v -> {
            String firstName = firstName_input.getText().toString();
            String lastName = lastName_input.getText().toString();
            String email = email_input.getText().toString();
            String password = password_input.getText().toString();
            String role = roleSpinner.getSelectedItem().toString().toUpperCase();
            String cpf = null;
            String cellphone = null;
            String crm = null;
            String speciality = null;

            if (currentFragment instanceof RegisterPatientFragment) {
                RegisterPatientFragment patientFragment = (RegisterPatientFragment) currentFragment;
                cpf = patientFragment.getCpf();
                cellphone = patientFragment.getCellphone();
            } else if (currentFragment instanceof RegisterMedicFragment) {
                RegisterMedicFragment medicFragment = (RegisterMedicFragment) currentFragment;
                crm = medicFragment.getCrm();
                speciality = medicFragment.getSpeciality();
            }

            RegisterRequest request = new RegisterRequest(firstName, lastName, email, password, role, cpf, cellphone, crm, speciality);

            new Thread(() -> {
                RegisterResponse response = repository.register(request);
                runOnUiThread(() -> {
                    if(response != null){
                        Toast.makeText(this, "Register was a success", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(this, HomeActivity.class);
                        intent.putExtra("userRole", role);
                        intent.putExtra("userEmail", email);
                        String fullName = firstName + " " + lastName;
                        intent.putExtra("userFullName", fullName);
                        startActivity(intent);

                        finish();
                    }else{
                        Toast.makeText(this, "Error on register", Toast.LENGTH_SHORT).show();
                    }
                });
            }).start();
        });
    }
}
