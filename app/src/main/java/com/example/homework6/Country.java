package com.example.homework6;

public class Country {
    private String name;
    private String flagUrl;
    private Integer square;
    private String capital;

    public Country(String name, String flagUrl, Integer square, String capital){
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
