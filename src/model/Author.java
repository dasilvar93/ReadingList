package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Author {
    String name;
    String affiliation;
    List<Reading> papers = new ArrayList<>();

    public Author(String name) {
        this.name = name;
    }

    public void addReading(Reading reading) {
        if (!papers.contains(reading)) {
            papers.add(reading);
            reading.setAuthor(this);
        }
    }

    public void removeReading(Reading reading) {
        if (papers.contains(reading)) {
            papers.remove(reading);
        }
    }

    public List<Reading> getPapers() {

        return Collections.unmodifiableList(papers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return name.equals(author.name) &&
                Objects.equals(affiliation, author.affiliation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, affiliation);
    }
}
