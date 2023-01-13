package org.example.Database;

import java.sql.*;

public class Sqlite implements SqliteOperations {

    private String dbPath;

    public Sqlite() {
        this.dbPath = "datamartDir/datamart.db";
    }


    public void createDataBase() {
        try (Connection conn = connect(dbPath)) {
            Statement statement = conn.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS MinTemperatures (" +
                    "date TEXT NOT NULL, " +
                    "time TEXT NOT NULL, " +
                    "place TEXT NOT NULL, " +
                    "station TEXT NOT NULL, " +
                    "value NUMBER NOT NULL" +
                    ")");
            statement.execute("CREATE TABLE IF NOT EXISTS MaxTemperatures (" +
                    "date TEXT NOT NULL, " +
                    "time TEXT NOT NULL, " +
                    "place TEXT NOT NULL, " +
                    "station TEXT NOT NULL, " +
                    "value NUMBER NOT NULL" +
                    ")");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static Connection connect(String dbPath) {
        Connection conn = null;
        try {
            String url = "jdbc:sqlite:" + dbPath;
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }

    @Override
    public void insertMinTemp(String date, String time, String place,
                              String station, double value) {
        String tracks_conn = "INSERT INTO MinTemperatures(date, time, place, station, value) " +
                "VALUES (?,?,?,?,?)";
        try(Connection conn = this.connect(dbPath)) {
            PreparedStatement preStatement = conn.prepareStatement(tracks_conn);
            preStatement.setString(1,date);
            preStatement.setString(2,time);
            preStatement.setString(3,place);
            preStatement.setString(4,station);
            preStatement.setDouble(5,value);

            preStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insertMaxTemp(String date, String time, String place,
                              String station, double value) {
        String tracks_conn = "INSERT INTO MaxTemperatures(date, time, place, station, value) " +
                "VALUES (?,?,?,?,?)";
        try(Connection conn = this.connect(dbPath)) {
            PreparedStatement preStatement = conn.prepareStatement(tracks_conn);
            preStatement.setString(1,date);
            preStatement.setString(2,time);
            preStatement.setString(3,place);
            preStatement.setString(4,station);
            preStatement.setDouble(5,value);

            preStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
