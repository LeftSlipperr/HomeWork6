package com.example.homework6;

public class Country {
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
