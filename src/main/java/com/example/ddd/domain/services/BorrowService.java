package com.example.ddd.domain.services;

import com.example.ddd.domain.book.Book;
import com.example.ddd.domain.borrowing.Borrowing;
import com.example.ddd.domain.shared.Id;
import com.example.ddd.domain.user.User;

public class BorrowService {

    public static Borrowing borrow(Book book, User user) {

        if (!book.isAvailable()) {
            throw new BorrowingException("Book is not available");
        } else if (!user.canBorrow()) {
            throw new BorrowingException("user can not borrow");
        }

        return Borrowing.of(
                Id.random(),
                book,
                user
        );
    }

    public static class BorrowingException extends RuntimeException {

        public BorrowingException(String message) {
            super(message);
        }
    }
}
