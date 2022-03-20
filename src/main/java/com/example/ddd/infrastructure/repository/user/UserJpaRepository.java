package com.example.ddd.infrastructure.repository.user;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UserJpaRepository extends CrudRepository<UserEntity, String> {
}
