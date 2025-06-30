package com.example.medsched_app.db_room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.medsched_app.model.Patient;

import java.util.List;

@Dao
public interface PatientDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Patient> patients);

    @Query("SELECT *  FROM patients")
    List<Patient> getAll();
}
