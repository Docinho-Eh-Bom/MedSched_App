package com.example.medsched_app.db_room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.medsched_app.model.Consult;

import java.util.List;

@Dao
public interface ConsultDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Consult> consults);

    @Query("SELECT * FROM consults")
    List<Consult> getAll();
}
