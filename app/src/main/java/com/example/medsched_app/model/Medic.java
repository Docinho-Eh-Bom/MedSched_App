package com.example.medsched_app.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;

@Entity(tableName = "medics")
public class Medic {
    @PrimaryKey
    @NonNull
    public String userId;

    public String firstName;
    public String lastName;
    public String role;
    public String email;
    public String speciality;
    public String crm;

    public Medic() {}//pro retro
}
