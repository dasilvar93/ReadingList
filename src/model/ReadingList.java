package model;

import java.util.ArrayList;
import java.util.List;

public class ReadingList extends Readable {

    List<Readable> readings;


    public ReadingList() {
        readings = new ArrayList<>();
    }

    public void addReading(Readable reading) {
        if (!readings.contains(reading)){
            readings.add(reading);
        }
    }

    public void removeReading(Readable reading) {
        readings.remove(reading);
    }
}

