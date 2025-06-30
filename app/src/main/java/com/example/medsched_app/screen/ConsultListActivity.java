package com.example.medsched_app.screen;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.medsched_app.R;
import com.example.medsched_app.model.Consult;
import com.example.medsched_app.repo.MedSchedRepository;
import com.example.medsched_app.req_res.ConsultResponse;

import java.util.ArrayList;
import java.util.List;

public class ConsultListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MedSchedRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consult_list);

        recyclerView = findViewById(R.id.consultRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        repository = new MedSchedRepository(this);


        //Num mundo ideal as informações viriam do repo
        //new Thread(() -> {
        //    List<Consult> consultList = repository.getLocalConsult();
        //    runOnUiThread(() -> {
        //        ConsultAdapter adapter = new ConsultAdapter(this, consultList);
        //        recyclerView.setAdapter(adapter);
        //    });
        //}).start();

        List<Consult> mockConsults = new ArrayList<>();

        Consult c1 = new Consult();
        c1.id = "1";
        c1.date = "2025-07-01";
        c1.status = "SCHEDULLED";
        c1.medic = new ConsultResponse.User();
        c1.medic.firstName = "Dra. Ana";
        c1.medic.lastName = "Silva";
        c1.patient = new ConsultResponse.User();
        c1.patient.firstName = "Carlos";
        c1.patient.lastName = "Ferreira";

        Consult c2 = new Consult();
        c2.id = "2";
        c2.date = "2025-07-02";
        c2.status = "COMPLETED";
        c2.medic = new ConsultResponse.User();
        c2.medic.firstName = "Dr. Pedro";
        c2.medic.lastName = "Oliveira";
        c2.patient = new ConsultResponse.User();
        c2.patient.firstName = "Marina";
        c2.patient.lastName = "Dias";

        mockConsults.add(c1);
        mockConsults.add(c2);

        ConsultAdapter adapter = new ConsultAdapter(this, mockConsults);
        recyclerView.setAdapter(adapter);

    }

}
