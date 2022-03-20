package com.example.ddd.domain.user;


public final class Username {

    private final String value;

    private Username(String value) {
        if (value == null || value.isBlank()) {
            throw new NotValidNameException();
        }

        this.value = value;
    }

    public static Username of(String value) {
        return new Username(value);
    }

    public String value() {
        return this.value;
    }

    public static class NotValidNameException extends RuntimeException {

        public NotValidNameException() {
            super("Name is not valid");
        }
    }
}
