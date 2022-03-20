package com.example.ddd.infrastructure.rest;

import java.util.UUID;

public class BorrowBookRequest {

    private UUID book;
    private UUID user;

    public UUID getBook() {
        return book;
    }

    public void setBook(UUID book) {
        this.book = book;
    }

    public UUID getUser() {
        return user;
    }

    public void setUser(UUID user) {
        this.user = user;
    }
}
