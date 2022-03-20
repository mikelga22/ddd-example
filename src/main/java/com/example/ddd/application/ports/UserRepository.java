package com.example.ddd.application.ports;

import com.example.ddd.domain.shared.Id;
import com.example.ddd.domain.user.User;

import java.util.Optional;

public interface UserRepository {

    void save(User user);

    Optional<User> findById(Id id);
}
