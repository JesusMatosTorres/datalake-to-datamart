package org.example.api;

public class Weather {
    public String date;
    public String time;
    public String station;
    public String place;
    public double temperature;


    public Weather() {
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }


    public void setStation(String station) {
        this.station = station;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public String getDate() {
        return date;
    }

    public String getStation() {
        return station;
    }

    public String getPlace() {
        return place;
    }

    public double getTemperature() {
        return temperature;
    }

    public String getTime() {
        return time;
    }
}
