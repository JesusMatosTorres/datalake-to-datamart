package org.example.api;

import java.sql.SQLException;
import java.util.ArrayList;

public class Controller implements TempGetters {

    String minDataBase;
    String maxDataBase;
    SqliteReader sqliteReader;

    public Controller() throws SQLException, ClassNotFoundException {
        minDataBase = "MinTemperatures";
        maxDataBase = "MaxTemperatures";
        sqliteReader = new SqliteReader();
    }

    @Override
    public String minGetter(String from, String to) {
        ArrayList<Weather> temperatures = sqliteReader.getTemperatures(minDataBase);
        return filter(from, to, temperatures);
    }

    @Override
    public String maxGetter(String from, String to) {
        ArrayList<Weather> temperatures = sqliteReader.getTemperatures(maxDataBase);
        return filter(from, to, temperatures);
    }

    private static String filter(String from, String to, ArrayList<Weather> temperatures) {
        Operations operations = new Operations();
        return operations.filterDate(temperatures, from, to);
    }
}
