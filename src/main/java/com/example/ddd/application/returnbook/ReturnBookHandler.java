package com.example.ddd.application.returnbook;


import com.example.ddd.application.ports.BookRepository;
import com.example.ddd.application.ports.BorrowingRepository;
import com.example.ddd.application.ports.UserRepository;
import com.example.ddd.domain.book.Book;
import com.example.ddd.domain.borrowing.Borrowing;
import com.example.ddd.domain.shared.Id;
import com.example.ddd.domain.user.User;

import java.util.Optional;

public class ReturnBookHandler {

    private final UserRepository userRepository;
    private final BookRepository bookRepository;
    private final BorrowingRepository borrowingRepository;

    public ReturnBookHandler(UserRepository userRepository, BookRepository bookRepository, BorrowingRepository borrowingRepository) {
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
        this.borrowingRepository = borrowingRepository;
    }

    public void handle(ReturnBookCommand command) {
        Optional<Borrowing> borrowing = borrowingRepository.findByBook(Id.of(command.getBook()));

        if (!borrowing.isPresent()){
            //should throw exception
        }

        Book book = borrowing.get().getBook();
        User user = borrowing.get().getUser();

        book.setAvailable();
        user.setCanBorrow(true);

        borrowingRepository.delete(borrowing.get());
        bookRepository.save(book);
        userRepository.save(user);
    }
}
