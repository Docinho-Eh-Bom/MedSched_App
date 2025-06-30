package com.example.medsched_app.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.example.medsched_app.req_res.ConsultResponse;

@Entity(tableName = "consults")
public class Consult {
    @PrimaryKey
    @NonNull
    public String id;

    public String medicId;
    public String patientId;
    public String date;
    public String status;

    //pros nomes da consult
    @Ignore
    public ConsultResponse.User medic;
    @Ignore
    public ConsultResponse.User patient;

    public Consult() {}

    public static class User {
        public String firstName;
        public String lastName;
    }
}
