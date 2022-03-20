package com.example.ddd.infrastructure.repository.user;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name="users")
public class UserEntity {

    @Id
    private String id;
    private String username;
    private Boolean canBorrow;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean getCanBorrow() {
        return canBorrow;
    }

    public void setCanBorrow(Boolean canBorrow) {
        this.canBorrow = canBorrow;
    }
}
