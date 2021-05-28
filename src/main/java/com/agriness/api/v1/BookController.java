package com.agriness.api.v1;


import com.agriness.book.dto.BookDTO;
import com.agriness.book.entity.Book;
import com.agriness.book.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) { this.bookService = bookService; }

    @GetMapping(value = "/books")
    public ResponseEntity<List<BookDTO>> getAllBooks(){
        Iterable<Book> books = this.bookService.getAllBooks();
        return ResponseEntity.ok(BookDTO.fromListBookToListBookDTO(books));
    }

    @GetMapping("/client/{clientId}/books")
    public ResponseEntity<List<BookDTO>> getBooksByClientId(@PathVariable Long clientId){
        List<Book> books = this.bookService.getBooksByClientId(clientId);
        return ResponseEntity.ok(BookDTO.fromListBookToListBookDTO(books));
    }

    @PostMapping("books/{bookId}/reserve")
    public ResponseEntity<BookDTO> reserveBook(@PathVariable Long bookId, @RequestParam Long clientId){
        Book book = this.bookService.setBookAsReserved(bookId, clientId);
        BookDTO bookDTO = BookDTO.fromBookToBookDTO(book);
        return ResponseEntity.ok(bookDTO);
    }
}
