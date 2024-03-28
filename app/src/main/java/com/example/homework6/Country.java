package com.example.homework6;

import com.google.gson.annotations.SerializedName;

public class Country {
    @SerializedName("cca2")
    public String code;

    public Flags flags;
    private String name;
    private Integer flagId;
    private Integer square;
    private String capital;

    public Country(String name, Integer flagId, Integer square, String capital){
        this.name = name;
        this.flagId = flagId;
        this.capital = capital;
        this.square = square;
    }
    public static class Flags{
        public String png;
        public String svg;
        public String alt;
    }
    public static class Names {
        public String common;
        public String official;
    }
    public String getName() {
        return name;
    }

    public Integer getFlagId() {
        return flagId;
    }

    public Integer getSquare() {
        return square;
    }

    public String getCapital() {
        return capital;
    }
}
