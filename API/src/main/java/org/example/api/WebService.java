package org.example.api;

import java.util.HashMap;
import java.util.Map;
import static spark.Spark.get;

public class WebService {
    private final Map<String, command> commands = new HashMap<>();

    //public void start() {
        //get("/v1/places/with-min-temperature", this::min);
        //get("/v1/places/with-max-temperature", this::max);
    //}

    //private String min(Request request, Response response) {
        //return commands.get("min").execute(parametersIn(request));
    //}

    //private String max(Request request, Response response) {
        //return commands.get("max").execute(parametersIn(request));
    //}
}
