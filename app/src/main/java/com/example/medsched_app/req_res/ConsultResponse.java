package com.example.medsched_app.req_res;

public class ConsultResponse {
    public String id;
    public String medicId;
    public String patientId;
    public String date;
    public String status;

    public User medic;
    public User patient;

    public static class User{
        public String firstName;
        public String lastName;
    }
}
