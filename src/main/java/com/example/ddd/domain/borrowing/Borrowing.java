package com.example.ddd.domain.borrowing;

import com.example.ddd.domain.book.Book;
import com.example.ddd.domain.shared.Id;
import com.example.ddd.domain.user.User;

public final class Borrowing {

    private final Id id;
    private final Book book;
    private final User user;

    private Borrowing(Id id, Book book, User user) {
        this.id = id;
        this.book = book;
        this.user = user;
    }

    public static Borrowing of(Id id, Book book, User user) {
        return new Borrowing(id, book, user);
    }

    public Id getId() {
        return id;
    }

    public Book getBook() {
        return book;
    }

    public User getUser() {
        return user;
    }
}
