package org.example.scrapper;

public class Weather {
    public String ts;
    public String station;
    public String place;
    public double mintemperature;
    public double maxtemperature;


    public Weather() {
    }

    public void setWeather(String ts, String station, String place) {
        this.ts = ts;
        this.station = station;
        this.place = place;
    }

    public void setTemps(double mintemperature, double maxtemperature) {
        this.mintemperature = mintemperature;
        this.maxtemperature = maxtemperature;
    }
}
