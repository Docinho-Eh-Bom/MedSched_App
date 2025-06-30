package com.example.medsched_app.db_room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.medsched_app.model.Medic;

import java.util.List;

@Dao
public interface MedicDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Medic> medics);

    @Query("SELECT * FROM medics")
    List<Medic> getAll();
}
