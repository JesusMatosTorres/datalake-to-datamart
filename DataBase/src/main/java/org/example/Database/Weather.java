package org.example.Database;

public class Weather {
    public String ts;
    public String time;
    public String station;
    public String place;
    public double mintemp;
    public double maxtemp;


    public Weather() {
    }

    public void setWeather(String ts, String hour, String station, String place, double mintemp, double maxtemp) {
        this.ts = ts;
        this.time = hour;
        this.station = station;
        this.place = place;
        this.mintemp = mintemp;
        this.maxtemp = maxtemp;
    }

    public String getTs() {
        return ts;
    }

    public String getTime() {
        return time;
    }

    public String getStation() {
        return station;
    }

    public String getPlace() {
        return place;
    }

    public double getMinTemp() {
        return mintemp;
    }

    public double getMaxtemp() {
        return maxtemp;
    }

}
