package com.example.ddd.infrastructure.repository.borrowing;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface BorrowingJpaRepository extends CrudRepository<BorrowingEntity, String> {

    Optional<BorrowingEntity> findByBook(String book);
}
