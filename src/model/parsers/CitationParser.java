package model.parsers;

import model.Author;
import model.Reading;

import static model.factory.AuthorFactory.findAuthor;
import static model.factory.ReadingFactory.findReading;

public class CitationParser {

    public static Reading parseMLA(String cit) {
        String[] split = cit.split("\\.");
        Author author = findAuthor(split[0]);
        String title = removeQuotes(split[1]);
        return findReading(title, author);
    }

//    private String[] splitter(String cit){
//        return cit.split(".");
//    }

    private static String removeQuotes(String str) {
       return str.substring(2);
    }
}
