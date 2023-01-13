package org.example.scrapper;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class FileDatalake implements Datalake{
    Gson gson = new Gson();

    public FileDatalake(List<Weather> filtered) throws IOException {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        FileWriter writer = new FileWriter("datalakeDir/" + localDate.format(formatter) + ".events", true);
        writer.write(gson.toJson(filtered) + "\n");
        writer.close();
    }
}
