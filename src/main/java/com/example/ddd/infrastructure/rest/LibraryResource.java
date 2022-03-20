package com.example.ddd.infrastructure.rest;

import com.example.ddd.application.borrowbook.BorrowBookCommand;
import com.example.ddd.application.borrowbook.BorrowBookHandler;
import com.example.ddd.application.returnbook.ReturnBookCommand;
import com.example.ddd.application.returnbook.ReturnBookHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/library")
public class LibraryResource {

    private final BorrowBookHandler borrowBookHandler;
    private final ReturnBookHandler returnBookHandler;

    public LibraryResource(BorrowBookHandler borrowBookHandler, ReturnBookHandler returnBookHandler) {
        this.borrowBookHandler = borrowBookHandler;
        this.returnBookHandler = returnBookHandler;
    }

    @PostMapping("/borrow")
    public void borrowBook(@RequestBody BorrowBookRequest request){
        BorrowBookCommand command = new BorrowBookCommand(request.getBook(), request.getUser());
        borrowBookHandler.handle(command);
    }

    @PostMapping("/return")
    public void returnBook(@RequestBody ReturnBookRequest request){
        ReturnBookCommand command = new ReturnBookCommand(request.getBook());
        returnBookHandler.handle(command);
    }
}
