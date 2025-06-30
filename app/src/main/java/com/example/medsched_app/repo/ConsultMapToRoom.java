package com.example.medsched_app.repo;

import com.example.medsched_app.model.Consult;
import com.example.medsched_app.req_res.ConsultResponse;

import java.util.ArrayList;
import java.util.List;

public class ConsultMapToRoom {
    public static List<Consult> mapResponseToConsults(List<ConsultResponse> responses){
        List<Consult> list = new ArrayList<>();
        for(ConsultResponse r : responses){
            Consult c = new Consult();
            c.id = r.id;
            c.date = r.date;
            c.status = r.status;
            c.medicId = r.medicId;
            c.patientId = r.patientId;
            c.medic = r.medic;
            c.patient = r.patient;
            list.add(c);
        }
        return list;
    }
}
