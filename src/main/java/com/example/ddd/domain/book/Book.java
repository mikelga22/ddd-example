package com.example.ddd.domain.book;

import com.example.ddd.domain.shared.Id;

public final class Book {

    private final Id id;
    private final Title title;
    private final Isbn isbn;
    private Boolean isAvailable;


    private Book(Id id, Title title, Isbn isbn, Boolean isAvailable) {
        this.id = id;
        this.title = title;
        this.isbn = isbn;
        this.isAvailable = isAvailable;
    }

    public static Book of(Id id, Title title, Isbn isbn, Boolean isAvailable) {
        return new Book(id, title, isbn, isAvailable);
    }

    public Id getId() {
        return id;
    }

    public Title getTitle() {
        return title;
    }

    public Isbn getIsbn() {
        return isbn;
    }

    public Boolean isAvailable() {
        return isAvailable;
    }

    public void setBorrowed() {
        this.isAvailable = false;
    }

    public void setAvailable() {
        this.isAvailable = true;
    }
}
