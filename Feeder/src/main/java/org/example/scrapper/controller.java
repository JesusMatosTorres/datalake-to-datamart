package org.example.scrapper;

import java.io.IOException;
import java.util.List;

public class controller {

    public void controller() throws IOException {
        AEMETWeatherScrapper scrapper = new AEMETWeatherScrapper();
        List<Weather> filtered = scrapper.scrapper();
        FileDatalake fileDatalake = new FileDatalake(filtered);
    }
}
