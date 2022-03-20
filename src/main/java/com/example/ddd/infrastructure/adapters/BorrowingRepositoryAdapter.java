package com.example.ddd.infrastructure.adapters;

import com.example.ddd.application.ports.BorrowingRepository;
import com.example.ddd.domain.book.Book;
import com.example.ddd.domain.book.Isbn;
import com.example.ddd.domain.book.Title;
import com.example.ddd.domain.borrowing.Borrowing;
import com.example.ddd.domain.shared.Id;
import com.example.ddd.domain.user.User;
import com.example.ddd.domain.user.Username;
import com.example.ddd.infrastructure.repository.book.BookEntity;
import com.example.ddd.infrastructure.repository.book.BookJpaRepository;
import com.example.ddd.infrastructure.repository.borrowing.BorrowingEntity;
import com.example.ddd.infrastructure.repository.borrowing.BorrowingJpaRepository;
import com.example.ddd.infrastructure.repository.user.UserEntity;
import com.example.ddd.infrastructure.repository.user.UserJpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BorrowingRepositoryAdapter implements BorrowingRepository {

    private final UserJpaRepository userJpaRepository;
    private final BookJpaRepository bookJpaRepository;
    private final BorrowingJpaRepository borrowingJpaRepository;

    public BorrowingRepositoryAdapter(UserJpaRepository userJpaRepository, BookJpaRepository bookJpaRepository, BorrowingJpaRepository borrowingJpaRepository) {
        this.userJpaRepository = userJpaRepository;
        this.bookJpaRepository = bookJpaRepository;
        this.borrowingJpaRepository = borrowingJpaRepository;
    }

    @Override
    public void save(Borrowing borrowing) {
        BorrowingEntity entity = new BorrowingEntity();
        entity.setId(borrowing.getId().value().toString());
        entity.setBook(borrowing.getBook().getId().value().toString());
        entity.setUser(borrowing.getUser().getId().value().toString());

        borrowingJpaRepository.save(entity);
    }

    @Override
    public Optional<Borrowing> findById(Id id) {
        Optional<BorrowingEntity> borrowingEntity = borrowingJpaRepository.findById(id.value().toString());
        return borrowingEntity.map(this::toBorrowing);
    }

    @Override
    public Optional<Borrowing> findByBook(Id bookId) {
        Optional<BorrowingEntity> borrowingEntity = borrowingJpaRepository.findByBook(bookId.value().toString());
        return borrowingEntity.map(this::toBorrowing);
    }

    @Override
    public void delete(Borrowing borrowing) {
        BorrowingEntity entity = new BorrowingEntity();
        entity.setId(borrowing.getId().value().toString());
        entity.setBook(borrowing.getBook().getId().value().toString());
        entity.setUser(borrowing.getUser().getId().value().toString());

        borrowingJpaRepository.delete(entity);
    }

    private Borrowing toBorrowing(BorrowingEntity entity) {
        Optional<BookEntity> bookEntity = bookJpaRepository.findById(entity.getBook());
        Optional<UserEntity> userEntity = userJpaRepository.findById(entity.getUser());

        if (bookEntity.isPresent() && userEntity.isPresent()) {
            return Borrowing.of(
                    Id.of(entity.getId()),
                    toBook(bookEntity.get()),
                    toUser(userEntity.get())
            );
        }

        return null;
    }

    private Book toBook(BookEntity entity) {
        return Book.of(
                Id.of(entity.getId()),
                Title.of(entity.getTitle()),
                Isbn.of(entity.getIsbn()),
                entity.getAvailable()
        );
    }

    private User toUser(UserEntity entity) {
        return User.of(
                Id.of(entity.getId()),
                Username.of(entity.getUsername()),
                entity.getCanBorrow()
        );
    }
}
