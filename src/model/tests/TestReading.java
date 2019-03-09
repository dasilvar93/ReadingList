package model.tests;

import model.Author;
import model.Reading;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestReading {

    Reading testReading;
    Author testAuthor;
    LocalDate testPubDate;

    @BeforeEach
    void setup() {
        testAuthor = new Author("Jane Doe");
        testReading = new Reading("Test Publication", testAuthor);
        testPubDate = LocalDate.of(2019, 01, 01);

    }


   @Test
    void testConstructor() {
       assertEquals("Test Publication", testReading.getTitle());
       assertEquals(testAuthor, testReading.getAuthor());
   }

   @Test
    void testPublicationDate() {
        testReading.setPublicationDate(testPubDate);

        assertEquals(testPubDate, testReading.getPublicationDate());
   }
}
