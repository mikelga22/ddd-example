package com.example.ddd.application.ports;

import com.example.ddd.domain.book.Book;
import com.example.ddd.domain.book.Isbn;
import com.example.ddd.domain.shared.Id;

import java.util.Optional;

public interface BookRepository {

    void save(Book book);

    Optional<Book> findById(Id id);

    Optional<Book> findByIsbn(Isbn isbn);
}
