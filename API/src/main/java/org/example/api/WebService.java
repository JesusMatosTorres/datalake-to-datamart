package org.example.api;


import static spark.Spark.get;

public class WebService {

    public void start() {

        get("/v1/places/with-min-temperature", (req, res) -> {
            String from = req.queryParams("from");
            String to = req.queryParams("to");
            Controller controller = new Controller();
            return controller.minGetter(from, to);
        });

        get("/v1/places/with-max-temperature", (req, res) -> {
            String from = req.queryParams("from");
            String to = req.queryParams("to");
            Controller controller = new Controller();
            return controller.maxGetter(from, to);
        });
    }
}
