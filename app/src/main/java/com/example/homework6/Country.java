package com.example.homework6;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class Country implements Serializable {
    @SerializedName("cca2")
    public String code;

    public Flags flags;
    public Names name;
    private double area; // изменено на List<String>
    private List<String> capital; // изменено на List<String>

    private Integer population;

    public Country(String code, Flags flags, Names name, double area, List<String> capital, Integer population){
        this.code = code;
        this.flags = flags;
        this.name = name;
        this.area = area;
        this.capital = capital;
        this.population = population;
    }

    public static class Flags implements Serializable{
        public String png;
        public String svg;
        public String alt;
    }

    public static class Names implements Serializable {
        public String common;
        public String official;
    }

    public String getName() {
        return name.common;
    }

    public double getArea() { // изменено на List<String>
        return area;
    }

    public String getCapital() { // изменено на List<String>
        return capital.get(0);
    }

    public Flags getFlags() {
        return flags;
    }

    public Integer getPopulation() {
        return population;
    }
}
