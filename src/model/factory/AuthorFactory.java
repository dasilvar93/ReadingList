package model.factory;

import model.Author;

import java.util.HashMap;
import java.util.Map;

public class AuthorFactory {
    private static Map<String, Author> authorsMap = new HashMap<>();

    public static Author findAuthor(String name) {
        if (authorsMap.containsKey(name)) {
            return authorsMap.get(name);
        } else {
            Author retAuthor = new Author(name);
            authorsMap.put(name, retAuthor);
            return retAuthor;
        }
    }
}
