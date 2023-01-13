package org.example.api;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Operations implements methods {
    public Operations() {
    }


    @Override
    public String filterDate(ArrayList<Weather> temperatures, String from, String to) {
        List<Weather> collect = temperatures.stream()
                .filter(d -> d.getDate().equals(from) && d.getDate().equals(to))
                .collect(Collectors.toList());
        return new Gson().toJson(collect);
    }
}
