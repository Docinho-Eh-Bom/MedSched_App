package com.example.medsched_app.screen;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medsched_app.R;
import com.example.medsched_app.model.Patient;
import com.example.medsched_app.repo.MedSchedRepository;

import java.util.ArrayList;
import java.util.List;

public class PatientListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MedSchedRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_list);


        recyclerView = findViewById(R.id.patientRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        repository = new MedSchedRepository(this);

        //new Thread(() -> {
        //    List<Patient> patients = repository.getLocalPatient();
        //    runOnUiThread(() -> {
        //        PatientAdapter adapter = new PatientAdapter(this, patients);
        //        recyclerView.setAdapter(adapter);
        //    });
        //}).start();

        List<Patient> mockPatients = new ArrayList<>();

        Patient p1 = new Patient();
        p1.userId = "1";
        p1.firstName = "João";
        p1.lastName = "Souza";
        p1.cpf = "123.456.789-00";
        p1.cellphone = "(51) 99999-0000";

        Patient p2 = new Patient();
        p2.userId = "2";
        p2.firstName = "Carlos";
        p2.lastName = "Campos";
        p2.cpf = "987.654.321-00";
        p2.cellphone = "(51) 98888-1111";

        mockPatients.add(p1);
        mockPatients.add(p2);

        PatientAdapter adapter = new PatientAdapter(this, mockPatients);
        recyclerView.setAdapter(adapter);

    }
}
