package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static model.Status.NOT_STARTED;

public class Reading extends Readable {

    String title;
    List<Author> authors = new ArrayList<>();
    LocalDate publicationDate;
    String publication;
    Status status;

    public Reading(String title, Author author) {
        this.title = title;
        this.addAuthor(author);
        this.status = NOT_STARTED;
    }

    public Reading(String title, List<Author> authors) {
        this.title = title;
        this.authors = authors;
        this.status = NOT_STARTED;
    }

    //EFFECTS: returns title of reading
    public String getTitle() {
        return this.title;
    }

    //MODIFIES: this, author
    //EFFECTS: if author is null, sets author and adds this reading to authors papers list. If there is an author, it
    //         removes the Reading from that authors papers list then sets new author and adds reading to its paper list
    public void addAuthor(Author author) {
        if (!authors.contains(author)) {
            authors.add(author);
            author.addReading(this);
        }
    }
    //MODIFIES: this, author
    //EFFECTS: removes author from authors, and removes reading from author's papers.
    public void removeAuthor(Author author) {
        if (authors.contains(author)) {
            authors.remove(author);
            author.removeReading(this);
        }
    }

    //EFFECTS: returns Authors of reading
    public List<Author> getAuthors() {
        return authors;
    }

    //MODIFIES: this
    //EFFECTS: sets publication date
    public void setPublicationDate(LocalDate pubDate) {
        this.publicationDate = pubDate;
    }

    //EFFECTS: returns publication date
    public LocalDate getPublicationDate() {
        return this.publicationDate;
    }

    //MODIFIES: this
    //EFFECTS: removes all current authors and replaces them with given author
    public void changeAuthors(Author author){
        for (int i = 0; i < authors.size(); i++) {
            removeAuthor(authors.get(i));
        }
        addAuthor(author);
    }
    //MODIFIES: this
    //EFFECTS: removes all current authors and replaces them with given list of authors
    public void changeAuthors(List<Author> authorsAdd) {
        for (int i = 0; i < authors.size(); i++) {
            removeAuthor(authors.get(i));
        }
        for (Author a: authorsAdd) {
            addAuthor(a);
        }
    }

    //EFFECTS: returns status
    public Status getStatus() {
        return this.status;
    }

    //MODIFIES: this
    //EFFECTS: Changes current status
    public void setStatus(Status status) {
        this.status = status;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reading reading = (Reading) o;
        return title.equals(reading.title) &&
                authors.equals(reading.authors) &&
                Objects.equals(publicationDate, reading.publicationDate) &&
                Objects.equals(publication, reading.publication);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, authors, publicationDate, publication);
    }
}
