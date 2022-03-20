package com.example.ddd.domain.book;

public final class Title {

    private final String value;

    private Title(String value) {
        if (value == null || value.isBlank()) {
            throw new NotValidTitleException();
        }

        this.value = value;
    }

    public static Title of(String value) {
        return new Title(value);
    }

    public String value() {
        return this.value;
    }

    public static class NotValidTitleException extends RuntimeException {

        public NotValidTitleException() {
            super("Title is not valid");
        }
    }
}
