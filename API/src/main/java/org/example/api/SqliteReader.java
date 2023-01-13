package org.example.api;

import java.sql.*;
import java.util.ArrayList;

public class SqliteReader implements DbReader{

    public Statement statement;

    public SqliteReader() throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        Connection conn = DriverManager.getConnection("jdbc:sqlite:datamartDir/datamart.db");
        this.statement = conn.createStatement();
    }

    @Override
    public ArrayList<Weather> getTemperatures(String db) {
        String sql = "SELECT * FROM " + db;
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            ArrayList<Weather> weathers = new ArrayList<>();
            while (resultSet.next()) {
                Weather weather = selectFromDataBase(resultSet);
                weathers.add(weather);
            }
            return weathers;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Weather selectFromDataBase(ResultSet resultSet) throws SQLException {
        Weather weather = new Weather();
        weather.setDate(resultSet.getString("date"));
        weather.setTime(resultSet.getString("time"));
        weather.setStation(resultSet.getString("station"));
        weather.setPlace(resultSet.getString("place"));
        weather.setTemperature(resultSet.getDouble("value"));
        return weather;
    }
}
