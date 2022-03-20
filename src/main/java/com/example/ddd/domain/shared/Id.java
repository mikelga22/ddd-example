package com.example.ddd.domain.shared;

import java.util.UUID;

public final class Id {

    private final UUID value;

    private Id(UUID value) {
        if (value == null) {
            throw new NotValidIdException();
        }
        this.value = value;
    }

    public static Id of(UUID value) {
        return new Id(value);
    }

    public static Id of(String value){
        return new Id(UUID.fromString(value));
    }

    public static Id random() {
        return new Id(UUID.randomUUID());
    }

    public UUID value() {
        return this.value;
    }

    public static class NotValidIdException extends RuntimeException {

        public NotValidIdException() {
            super("Name is not valid");
        }
    }
}
