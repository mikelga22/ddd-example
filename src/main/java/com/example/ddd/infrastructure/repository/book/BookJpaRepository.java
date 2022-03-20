package com.example.ddd.infrastructure.repository.book;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface BookJpaRepository extends CrudRepository<BookEntity, String> {

    Optional<BookEntity> findByIsbn(String isbn);
}
