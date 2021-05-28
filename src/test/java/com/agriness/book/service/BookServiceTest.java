package com.agriness.book.service;

import com.agriness.book.entity.Book;
import com.agriness.book.exceptions.BookAlreadyReservedException;
import com.agriness.book.exceptions.BookNotFoundException;
import com.agriness.book.repository.BookRepository;
import com.agriness.client.entity.Client;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;


    @Test
    void setBookAsReserved__SetStatusToEMPRESTADO() {
        Client clientMock = Client.builder().id(1L).name("Teste Client").build();
        Book bookMock = Book.builder()
                .id(2L)
                .lastRentDate(LocalDateTime.now())
                .client(clientMock)
                .title(String.format("Book Test Fake"))
                .status(Book.Status.DISPONIVEL)
                .build();
        when(this.bookRepository.findById(bookMock.getId())).thenReturn(Optional.of(bookMock));
        when(this.bookRepository.save(any())).thenReturn(bookMock);
        Book bookSaved = this.bookService.setBookAsReserved(bookMock.getId(), bookMock.getId());
        Assertions.assertEquals(bookSaved.getId(), bookMock.getId());
    }

    @Test
    void setBookAsReserved__ThrowException__WhenBookNotFound() {
        when(this.bookRepository.findById(1L)).thenThrow(BookNotFoundException.class);
        Assertions.assertThrows(BookNotFoundException.class, () -> {
            this.bookService.setBookAsReserved(1L, 2L);
        });
    }

    @Test
    void setBookAsReserved__ThrowException__WhenBookResevedToAnotherPerson() {
        Client clientMock = Client.builder().id(1L).name("Teste Client").build();
        Book bookMock = Book.builder()
                .id(2L)
                .lastRentDate(LocalDateTime.now())
                .client(clientMock)
                .title(String.format("Book Test Fake"))
                .status(Book.Status.EMPRESTADO)
                .build();
        when(this.bookRepository.findById(bookMock.getId())).thenReturn(Optional.of(bookMock));
        Assertions.assertThrows(BookAlreadyReservedException.class, () -> {
            this.bookService.setBookAsReserved(bookMock.getId(), 55L);
        });
    }
}