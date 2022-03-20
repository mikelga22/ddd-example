package com.example.ddd.infrastructure.adapters;

import com.example.ddd.application.ports.BookRepository;
import com.example.ddd.domain.book.Book;
import com.example.ddd.domain.book.Isbn;
import com.example.ddd.domain.book.Title;
import com.example.ddd.domain.shared.Id;
import com.example.ddd.infrastructure.repository.book.BookEntity;
import com.example.ddd.infrastructure.repository.book.BookJpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookRepositoryAdapter implements BookRepository {

    private final BookJpaRepository jpaRepository;

    public BookRepositoryAdapter(BookJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public void save(Book book) {
        BookEntity entity = new BookEntity();
        entity.setId(book.getId().value().toString());
        entity.setTitle(book.getTitle().value());
        entity.setIsbn(book.getIsbn().value());
        entity.setAvailable(book.isAvailable());

        jpaRepository.save(entity);
    }

    @Override
    public Optional<Book> findById(Id id) {
        Optional<BookEntity> entity = jpaRepository.findById(id.value().toString());
        return entity.map(this::toBook);
    }

    @Override
    public Optional<Book> findByIsbn(Isbn isbn) {
        Optional<BookEntity> entity = jpaRepository.findByIsbn(isbn.value());
        return entity.map(this::toBook);
    }

    private Book toBook(BookEntity entity) {
        return Book.of(
                Id.of(entity.getId()),
                Title.of(entity.getTitle()),
                Isbn.of(entity.getIsbn()),
                entity.getAvailable()
        );
    }
}
