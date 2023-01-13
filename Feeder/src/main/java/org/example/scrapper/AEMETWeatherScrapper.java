package org.example.scrapper;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class AEMETWeatherScrapper implements WebScrapper {
    private static final String url = "https://opendata.aemet.es/opendata/api/observacion/convencional/todas";
    private static final String apiKey = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqZXN1c21hcmlhOTltdEBnbWFpbC5jb20iLCJqdGkiOiIxN2MyZDdiZC1hMmU4LTQ1NDktOWVlMS1kYTVjMWJlOTE2ZGYiLCJpc3MiOiJBRU1FVCIsImlhdCI6MTY3MjIxMjcwNywidXNlcklkIjoiMTdjMmQ3YmQtYTJlOC00NTQ5LTllZTEtZGE1YzFiZTkxNmRmIiwicm9sZSI6IiJ9.xfV7skc6Sir-tacvsCmw0X-gC179HsadD43xq83B4sc";

    public AEMETWeatherScrapper() {
    }

    @Override
    public List<Weather> scrapper() {
        Gson gson = new Gson();
        ArrayList<Weather> weathers = new ArrayList<>();
        try {
            JsonArray jsonElements = weatherData(gson);
            for (JsonElement e : jsonElements) {
                if(checkArea(e)) {
                    Weather weather = filter(e);
                    weathers.add(weather);
                }
            }
            return weathers;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static Weather filter(JsonElement e) {
        Weather weather = new Weather();
        weather.setWeather(e.getAsJsonObject().get("fint").getAsString(),
                e.getAsJsonObject().get("idema").getAsString(),
                e.getAsJsonObject().get("ubi").getAsString());
        try {
            weather.setTemps(e.getAsJsonObject().get("tamin").getAsDouble(),
                    e.getAsJsonObject().get("tamax").getAsDouble());
        } catch (NullPointerException ignored){
            return null;
        }
        return weather;
    }

    private static boolean checkArea(JsonElement e) {
        return e.getAsJsonObject().get("lon").getAsDouble() > -16 &&
                e.getAsJsonObject().get("lon").getAsDouble() < -15 &&
                e.getAsJsonObject().get("lat").getAsDouble() > 27.5 &&
                e.getAsJsonObject().get("lat").getAsDouble() < 28.4;
    }


    private static JsonArray weatherData(Gson gson) throws IOException {
        String response = connect(url);
        JsonObject jsonObject = gson.fromJson(response, JsonObject.class);
        String data = jsonObject.getAsJsonPrimitive("datos").getAsString();
        String content = connect(data);
        return gson.fromJson(content, JsonArray.class);

    }

    private static String connect(String url) throws IOException {
        return Jsoup.connect(url)
                .validateTLSCertificates(false)
                .timeout(6000)
                .ignoreContentType(true)
                .header("accept", "application/json")
                .header("api_key", apiKey)
                .method(Connection.Method.GET)
                .maxBodySize(0).execute().body();
    }
}
