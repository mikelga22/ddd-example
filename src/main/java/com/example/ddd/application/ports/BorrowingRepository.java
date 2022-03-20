package com.example.ddd.application.ports;

import com.example.ddd.domain.borrowing.Borrowing;
import com.example.ddd.domain.shared.Id;

import java.util.Optional;

public interface BorrowingRepository {

    void save(Borrowing borrowing);

    Optional<Borrowing> findById(Id id);

    Optional<Borrowing> findByBook(Id bookId);

    void delete(Borrowing borrowing);
}
