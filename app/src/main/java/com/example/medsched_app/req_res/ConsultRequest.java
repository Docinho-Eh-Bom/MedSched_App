package com.example.medsched_app.req_res;

public class ConsultRequest {
    public String date;
    public String medicId;
    public String patientId;

    public ConsultRequest(String date, String medicId, String patientId){
        this.date = date;
        this.medicId = medicId;
        this.patientId = patientId;
    }
}
