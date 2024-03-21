package com.example.homework6;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import org.jetbrains.annotations.NotNull;

@Entity
public class Country {
    @NotNull
    @PrimaryKey
    public String name;

    public String flagUrl;
    public Integer square;
    public String capital;

    public Country(String name, String flagUrl, Integer square, String capital) {
        this.name = name;
        this.flagUrl = flagUrl;
        this.capital = capital;
        this.square = square;
    }

    public String getName() {
        return name;
    }

    public String getFlagUrl() {
        return flagUrl;
    }

    public Integer getSquare() {
        return square;
    }

    public String getCapital() {
        return capital;
    }
}
