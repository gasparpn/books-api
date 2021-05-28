package com.agriness.api.v1;

import com.agriness.book.dto.BookDTO;
import com.agriness.book.entity.Book;
import com.agriness.book.exceptions.BookAlreadyReservedException;
import com.agriness.book.exceptions.BookNotFoundException;
import com.agriness.book.repository.BookRepository;
import com.agriness.book.service.BookService;
import com.agriness.client.entity.Client;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookControllerTest {

    @Mock
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookController bookController;

    @Test
    void getAllBooks__ReturnStatus200AndBooksInTheBody() {
        List<Book> booksMocks = getMockBooks();
        when(this.bookService.getAllBooks()).thenReturn(booksMocks);
        ResponseEntity<List<BookDTO>> response = bookController.getAllBooks();
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
        Assertions.assertEquals(response.getBody().size(), booksMocks.size());
    }

    @Test
    void getBooksByClientId__ReturnStatus200AndBookInTheBody() {
        List<Book> booksMocks = getMockBooks();
        when(this.bookService.getBooksByClientId(1L)).thenReturn(booksMocks);
        ResponseEntity<List<BookDTO>> response = bookController.getBooksByClientId(1L);
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
        Assertions.assertEquals(response.getBody().size(), booksMocks.size());
    }

    @Test
    void reserveBook__ReturnStatus200__WhenBookNotReserved() {
        Client clientMock = Client.builder().id(1L).name("Teste Client").build();
        Book bookMock = Book.builder()
                .id(2L)
                .lastRentDate(LocalDateTime.now())
                .client(clientMock)
                .title(String.format("Book Test Fake"))
                .status(Book.Status.DISPONIVEL)
                .build();
        when(this.bookService.setBookAsReserved(bookMock.getId(), clientMock.getId())).thenReturn(bookMock);
        ResponseEntity<BookDTO> response = bookController.reserveBook(bookMock.getId(), clientMock.getId());
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
        Assertions.assertEquals(response.getBody().getId(), bookMock.getId());
    }

    @Test
    void reserveBook__ThrowException__WhenBookIsReservedForOtherPerson() {
        when(this.bookService.setBookAsReserved(1L, 2L)).thenThrow(BookAlreadyReservedException.class);
        Assertions.assertThrows(BookAlreadyReservedException.class, () -> {
            this.bookController.reserveBook(1L, 2L);
        });
    }

    @Test
    void reserveBook__ThrowException__WhenBookNotFound() {
        when(this.bookService.setBookAsReserved(1L, 2L)).thenThrow(BookNotFoundException.class);
        Assertions.assertThrows(BookNotFoundException.class, () -> {
            this.bookController.reserveBook(1L, 2L);
        });
    }

    public List<Book> getMockBooks(){
        List<Book> books = new ArrayList<Book>();
        Client client = Client.builder().id(1L).name("Client Test Fake").build();
        for(Long i = 0L; i < 3; i++) {
            books.add(Book
                    .builder()
                    .id(i)
                    .lastRentDate(LocalDateTime.now())
                    .client(client)
                    .title(String.format("Book Test %s", 1))
                    .status(Book.Status.DISPONIVEL)
                    .build());
        }
        return books;
    }
}