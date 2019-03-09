package model.tests;

import model.Author;
import model.Reading;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestReading {

    Reading testReading;
    Author testAuthor;
    LocalDate testPubDate;
    Author testAuthor2;

    @BeforeEach
    void setup() {
        testAuthor = new Author("Jane Doe");
        testReading = new Reading("Test Publication", testAuthor);
        testPubDate = LocalDate.of(2019, 01, 01);
        testAuthor2 = new Author("John Doe");

    }


    @Test
    void testConstructor() {
        assertEquals("Test Publication", testReading.getTitle());
        assertTrue(testReading.getAuthors().contains(testAuthor));
        assertTrue(testAuthor.getPapers().contains(testReading));
    }

    @Test
    void testPublicationDate() {
        testReading.setPublicationDate(testPubDate);

        assertEquals(testPubDate, testReading.getPublicationDate());
    }

    @Test
    void testAddAuthor() {

        testReading.addAuthor(testAuthor2);

        assertTrue(testAuthor.getPapers().contains(testReading));
        assertTrue(testAuthor2.getPapers().contains(testReading));
        assertTrue(testReading.getAuthors().contains(testAuthor2));
    }

    @Test
    void testChangeAuthor() {
        testReading.changeAuthors(testAuthor2);

        assertFalse(testAuthor.getPapers().contains(testReading));
        assertTrue(testAuthor2.getPapers().contains(testReading));
        assertTrue(testReading.getAuthors().contains(testAuthor2));
        assertFalse(testReading.getAuthors().contains(testAuthor));
    }

    @Test
    void testChangeAuthors() {
        List<Author> testAuthors = new ArrayList<>();
        Author testAuthor3 = new Author("Albert Einstein");

        testAuthors.add(testAuthor3);
        testAuthors.add(testAuthor2);

        testReading.changeAuthors(testAuthors);

        assertFalse(testAuthor.getPapers().contains(testReading));
        assertTrue(testAuthor2.getPapers().contains(testReading));
        assertTrue(testReading.getAuthors().contains(testAuthor2));
        assertFalse(testReading.getAuthors().contains(testAuthor));
        assertTrue(testReading.getAuthors().contains(testAuthor3));
        assertTrue(testAuthor3.getPapers().contains(testReading));
    }
}
