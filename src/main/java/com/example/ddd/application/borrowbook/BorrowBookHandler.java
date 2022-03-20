package com.example.ddd.application.borrowbook;

import com.example.ddd.application.ports.BookRepository;
import com.example.ddd.application.ports.BorrowingRepository;
import com.example.ddd.application.ports.UserRepository;
import com.example.ddd.domain.book.Book;
import com.example.ddd.domain.borrowing.Borrowing;
import com.example.ddd.domain.services.BorrowService;
import com.example.ddd.domain.shared.Id;
import com.example.ddd.domain.user.User;

import java.util.Optional;

public class BorrowBookHandler {

    private final UserRepository userRepository;
    private final BookRepository bookRepository;
    private final BorrowingRepository borrowingRepository;

    public BorrowBookHandler(UserRepository userRepository, BookRepository bookRepository, BorrowingRepository borrowingRepository) {
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
        this.borrowingRepository = borrowingRepository;
    }

    public void handle(BorrowBookCommand command) {
        Optional<Book> book = bookRepository.findById(Id.of(command.getBook()));
        Optional<User> user = userRepository.findById(Id.of(command.getUser()));

        if(!book.isPresent()){
            //should throw exception
        }
        else if (!user.isPresent()){
            //should throw exception
        }

        Borrowing borrowing = BorrowService.borrow(book.get(), user.get());
        borrowing.getBook().setBorrowed();
        borrowing.getUser().setCanBorrow(false);

        borrowingRepository.save(borrowing);
        bookRepository.save(borrowing.getBook());
        userRepository.save(borrowing.getUser());
    }
}
