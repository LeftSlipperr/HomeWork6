package com.example.homework6;

public class Country {
    private String name;
    private Integer flagId;

    public Country(String name, Integer flagId){
        this.name = name;
        this.flagId = flagId;
    }
    public String getName() {
        return name;
    }

    public Integer getFlagId() {
        return flagId;
    }
}
