package com.example.medsched_app.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "patients")
public class Patient {
    @PrimaryKey
    @NonNull
    public String userId;

    public String firstName;
    public String lastName;
    public String role;
    public String email;
    public String cpf;
    public String cellphone;

    public Patient() {}
}
