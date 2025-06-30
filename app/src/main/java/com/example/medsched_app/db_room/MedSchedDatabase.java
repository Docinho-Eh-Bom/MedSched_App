package com.example.medsched_app.db_room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.medsched_app.model.Consult;
import com.example.medsched_app.model.Medic;
import com.example.medsched_app.model.Patient;

@Database(entities = {Medic.class, Patient.class, Consult.class}, version = 1)
public abstract class MedSchedDatabase extends RoomDatabase {
    private static MedSchedDatabase instance;

    public abstract MedicDao medicDao();
    public abstract PatientDao patientDao();
    public abstract ConsultDao consultDao();

    public static synchronized MedSchedDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(), MedSchedDatabase.class, "medsched_db").fallbackToDestructiveMigration().build();
        }
        return instance;
    }
}
