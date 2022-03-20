package com.example.ddd.application.borrowbook;

import java.util.UUID;

public class BorrowBookCommand {

    private final UUID book;
    private final UUID user;

    public BorrowBookCommand(UUID book, UUID user) {
        this.book = book;
        this.user = user;
    }

    public UUID getBook() {
        return book;
    }

    public UUID getUser() {
        return user;
    }
}
