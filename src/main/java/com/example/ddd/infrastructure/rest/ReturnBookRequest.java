package com.example.ddd.infrastructure.rest;

import java.util.UUID;

public class ReturnBookRequest {

    private UUID book;

    public UUID getBook() {
        return book;
    }

    public void setBook(UUID book) {
        this.book = book;
    }
}
