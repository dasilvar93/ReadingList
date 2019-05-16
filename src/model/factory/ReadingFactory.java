package model.factory;

import model.Reading;

import java.util.HashMap;
import java.util.Map;

public class ReadingFactory {
    private static Map<String, Reading> readings = new HashMap<>();

    public static Reading findReading(String description) {
        if (readings.containsKey(description)) {
            return readings.get(description);
        } else {
            Reading reading = new Reading(description);
            readings.put(description, reading);
            return reading;
        }
    }
}
