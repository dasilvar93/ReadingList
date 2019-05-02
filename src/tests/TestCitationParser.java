package tests;

import model.Author;
import model.Reading;
import org.junit.jupiter.api.Test;

import static model.factory.AuthorFactory.findAuthor;
import static model.factory.ReadingFactory.findReading;
import static model.parsers.CitationParser.parseMLA;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCitationParser {

    private Author testAuthor;
    private Reading testReading;

    @Test
    void testParserMLA() {
        testAuthor = findAuthor("Duvall, John N");
        testReading = findReading("The (Super)Marketplace of Images: Television as Unmediated Mediation in DeLillo's White Noise", testAuthor);

        Reading testParsed = parseMLA("Duvall, John N. \"The (Super)Marketplace of Images: Television as Unmediated Mediation in DeLillo's White Noise.\" Arizona Quarterly, vol. 50, no. 3, 1994, pp. 127-53.");

        assertEquals(testReading.getTitle(), testParsed.getTitle());
        assertEquals(testReading.getAuthors().contains(testAuthor), testParsed.getAuthors().contains(testAuthor));
        assertEquals(testReading, testParsed);
    }
}
