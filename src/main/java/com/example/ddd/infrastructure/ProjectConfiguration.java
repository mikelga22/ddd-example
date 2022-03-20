package com.example.ddd.infrastructure;

import com.example.ddd.application.borrowbook.BorrowBookHandler;
import com.example.ddd.application.ports.BookRepository;
import com.example.ddd.application.ports.BorrowingRepository;
import com.example.ddd.application.ports.UserRepository;
import com.example.ddd.application.returnbook.ReturnBookHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfiguration {

    private final UserRepository userRepository;
    private final BookRepository bookRepository;
    private final BorrowingRepository borrowingRepository;

    public ProjectConfiguration(UserRepository userRepository, BookRepository bookRepository, BorrowingRepository borrowingRepository) {
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
        this.borrowingRepository = borrowingRepository;
    }

    @Bean
    public BorrowBookHandler borrowBookHandler(){
        return new BorrowBookHandler(userRepository, bookRepository, borrowingRepository);
    }

    @Bean
    public ReturnBookHandler returnBookHandler(){
        return new ReturnBookHandler(userRepository, bookRepository, borrowingRepository);
    }
}
