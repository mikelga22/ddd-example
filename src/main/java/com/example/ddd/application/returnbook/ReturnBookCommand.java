package com.example.ddd.application.returnbook;

import java.util.UUID;

public class ReturnBookCommand {

    private final UUID book;

    public ReturnBookCommand(UUID book) {
        this.book = book;
    }

    public UUID getBook() {
        return book;
    }
}
