package model;

import java.time.LocalDate;
import java.util.Objects;

public class Reading {

    String title;
    Author author;
    LocalDate publicationDate;
    String publication;

    public Reading(String title, Author author) {
        this.title = title;
        this.author = author;
    }

    //EFFECTS: returns title of reading
    public String getTitle() {
        return this.title;
    }

    public void setAuthor(Author author) {
        if (!author.equals(this.author)) {
            if (this.author == null) {
                this.author = author;
                author.addReading(this);
            } else {
                this.author.removeReading(this);
                this.author = author;
                author.addReading(this);
            }
        }
    }

    //EFFECTS: returns Author of reading
    public Author getAuthor() {
        return this.author;
    }

    //EFFECTS: sets publication date
    public void setPublicationDate(LocalDate pubDate) {
        this.publicationDate = pubDate;
    }

    //EFFECTS: returns publication date
    public LocalDate getPublicationDate() {
        return this.publicationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reading reading = (Reading) o;
        return title.equals(reading.title) &&
                author.equals(reading.author) &&
                Objects.equals(publicationDate, reading.publicationDate) &&
                Objects.equals(publication, reading.publication);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, publicationDate, publication);
    }
}
