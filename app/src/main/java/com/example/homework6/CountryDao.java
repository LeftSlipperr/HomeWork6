package com.example.homework6;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface CountryDao {
    @Query("SELECT * FROM country")
    List<Country> getAll();


    @Insert
    void insert(Country country);
}
