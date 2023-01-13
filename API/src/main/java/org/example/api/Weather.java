package org.example.api;

public class Weather {
    public String ts;
    public String station;
    public String place;
    public int temperature;

    public Weather(String ts, String station, String place, int temperature) {
        this.ts = ts;
        this.station = station;
        this.place = place;
        this.temperature = temperature;
    }
}
