package org.example.Database;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;

public class DatalakeReader implements timeGetter{

    ArrayList<Weather> weathers = new ArrayList<>();

    public DatalakeReader() throws IOException {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        FileReader f = new FileReader("datalakeDir/" + localDate.format(formatter) + ".events");
        JsonReader jsonReader = new JsonReader(f);
        jsonReader.setLenient(true);
        JsonArray content = new Gson().fromJson(jsonReader, JsonArray.class);

        for (JsonElement e : content) {
            Weather weather = extracted(e);
            weathers.add(weather);
        }
    }

    private static Weather extracted(JsonElement e) {
        Weather weather = new Weather();
        weather.setWeather(e.getAsJsonObject().get("ts").getAsString().substring(0,10),
                e.getAsJsonObject().get("ts").getAsString().substring(11),
                e.getAsJsonObject().get("station").getAsString(),
                e.getAsJsonObject().get("place").getAsString(),
                e.getAsJsonObject().get("mintemperature").getAsDouble(),
                e.getAsJsonObject().get("maxtemperature").getAsDouble());
        return weather;
    }


    @Override
    public Weather maxGetter() {
        return weathers.stream().max(Comparator.comparing(Weather::getMaxtemp)).get();
    }

    @Override
    public Weather minGetter() {
        return weathers.stream().min(Comparator.comparing(Weather::getMinTemp)).get();
    }
}
