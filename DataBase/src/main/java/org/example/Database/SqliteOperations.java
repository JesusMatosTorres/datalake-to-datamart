package org.example.Database;

public interface SqliteOperations {

    void createDataBase();

    void insertMinTemp(String date, String time, String place, String station, double value);

    void insertMaxTemp(String date, String time, String place, String station, double value);
}
