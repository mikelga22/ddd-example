package com.example.ddd.domain.user;

import com.example.ddd.domain.shared.Id;

public final class User {

    private final Id id;
    private final Username username;
    private Boolean canBorrow;

    private User(Id id, Username name, Boolean canBorrow) {
        this.id = id;
        this.username = name;
        this.canBorrow = canBorrow;
    }

    public static User of(Id id, Username name, Boolean canBorrow) {
        return new User(id, name, canBorrow);
    }

    public Id getId() {
        return id;
    }

    public Username getUsername() {
        return username;
    }

    public Boolean canBorrow() {
        return canBorrow;
    }

    public void setCanBorrow(Boolean canBorrow) {
        this.canBorrow = canBorrow;
    }
}
