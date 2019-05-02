package model.factory;

import model.Author;
import model.Reading;

import java.util.HashMap;
import java.util.Map;

public class ReadingFactory {
    private static Map<String, Reading> readings = new HashMap<>();

    public static Reading findReading(String title, Author author) {
        if (readings.containsKey(title)) {
            return readings.get(title);
        } else {
            Reading reading = new Reading(title, author);
            readings.put(title, reading);
            return reading;
        }
    }
}
