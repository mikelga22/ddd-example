package com.example.ddd.domain.book;

public final class Isbn {

    private final String value;

    private Isbn(String value) {
        if (value == null || value.isBlank()) {
            throw new NotValidIsbnException();
        }

        this.value = value;
    }

    public static Isbn of(String value) {
        return new Isbn(value);
    }

    public String value() {
        return this.value;
    }

    public static class NotValidIsbnException extends RuntimeException {

        public NotValidIsbnException() {
            super("Isbn is not valid");
        }
    }
}
