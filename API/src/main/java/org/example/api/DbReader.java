package org.example.api;

import java.util.ArrayList;

public interface DbReader {

    ArrayList<Weather> getTemperatures(String db);
}
