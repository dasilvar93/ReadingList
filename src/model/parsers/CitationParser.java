package model.parsers;

import model.Reading;

import static model.factory.ReadingFactory.findReading;

public class CitationParser {

    public static Reading parseMlaArticle(String cit) {
        String[] split = cit.split("\"");
        String description = split[0] + " " + split[1];  // need to add year
        return findReading(description);
    }

//    private String[] splitter(String cit){
//        return cit.split(".");
//    }

    private static String removeQuotes(String str) {
       return str.substring(2);
    }
}
