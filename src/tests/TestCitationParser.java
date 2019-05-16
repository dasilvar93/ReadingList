package tests;

import model.Author;
import model.Reading;
import org.junit.jupiter.api.Test;

import static model.factory.AuthorFactory.findAuthor;
import static model.factory.ReadingFactory.findReading;
import static model.parsers.CitationParser.parseMlaArticle;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCitationParser {

    private Author testAuthor;
    private Reading testReading;

    @Test
    void testParserMLA() {
        testAuthor = findAuthor("Duvall, John N");
        testReading = findReading("Duvall, John N.  The (Super)Marketplace of Images: Television as Unmediated Mediation in DeLillo's White Noise.");

        Reading testParsed = parseMlaArticle("Duvall, John N. \"The (Super)Marketplace of Images: Television as Unmediated Mediation in DeLillo's White Noise.\" Arizona Quarterly, vol. 50, no. 3, 1994, pp. 127-53.");

        assertEquals(testReading.getDescription(), testParsed.getDescription());
        assertEquals(testReading, testParsed);
    }
}
