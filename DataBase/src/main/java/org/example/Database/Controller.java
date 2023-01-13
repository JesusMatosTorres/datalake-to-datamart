package org.example.Database;

import java.io.File;
import java.io.IOException;

public class Controller {
    public Controller() throws IOException {
        DatalakeReader datalakeReader = new DatalakeReader();
        Sqlite sqlite = new Sqlite();
        File archivo = new File("datamartDir/datamart.db");
        if (!archivo.exists()) {
            sqlite.createDataBase();
        }
        Weather min = datalakeReader.minGetter();
        sqlite.insertMinTemp(min.getTs(), min.getTime(), min.getPlace(), min.getStation(), min.getMinTemp());
        Weather max = datalakeReader.maxGetter();
        sqlite.insertMaxTemp(max.getTs(), max.getTime(), max.getPlace(), max.getStation(), max.getMaxtemp());
    }
}
