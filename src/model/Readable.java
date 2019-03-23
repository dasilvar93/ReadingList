package model;

import java.time.LocalDate;

public abstract class Readable {
    private LocalDate dueDate;


    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getDueDate() {
        return this.dueDate;
    }
}
