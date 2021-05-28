package com.agriness.book.service;

import com.agriness.book.entity.Book;
import com.agriness.book.exceptions.BookAlreadyReservedException;
import com.agriness.book.exceptions.BookNotFoundException;
import com.agriness.book.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public Book getBookById(Long bookId){
        return this.bookRepository.findById(bookId).orElseThrow(BookNotFoundException::new);
    }

    public List<Book> getBooksByClientId(Long clientId){
        return this.bookRepository.findBookByClientId(clientId);
    }

    public Iterable<Book> getAllBooks(){
        return this.bookRepository.findAll();
    }

    public Book updateBook(Book book){
        return this.bookRepository.save(book);
    }

    public Book setBookAsReserved(Long bookId, Long clientId){
        Book book = this.getBookById(bookId);
        if (clientId != book.getClient().getId() && book.getStatus() == Book.Status.EMPRESTADO){
            throw new BookAlreadyReservedException();
        }
        book.setStatus(Book.Status.EMPRESTADO);
        book.setLastRentDate(LocalDateTime.now());
        return this.updateBook(book);
    }
}
